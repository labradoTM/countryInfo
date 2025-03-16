package com.netzwerkbetriebssysteme;

import com.google.common.base.Joiner;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.StringResourceModel;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringJoiner;

public class LandingPage extends WebPage {

    IModel<String> outputModel;

    public LandingPage() {

    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        Form<FormObject> form = new Form<>("form", new Model<FormObject>(new FormObject()));
        outputModel = new Model<>("");
        IModel<String> eingabe1Model = new PropertyModel<>(form.getModel(), "input");
        TextField<String> eingabe1 = new TextField<>("eingabe1", eingabe1Model);
        IModel<Boolean> checkboxModel = new PropertyModel<>(form.getModel(), "rawResponse");
        CheckBox checkBox = new CheckBox("rawInput", checkboxModel);
        Label output = new Label("output", outputModel);
        output.setOutputMarkupId(true);

        IModel<List<StringPair>> listModel = new IModel<List<StringPair>>() {

            List<StringPair> list = new ArrayList<>();
            @Override
            public List<StringPair> getObject() {
                return list;
            }

            @Override
            public void setObject(List<StringPair> object) {
                this.list = object;
            }
        };
        ListView<StringPair> listView = new ListView<StringPair>("table", listModel) {
            @Override
            protected void populateItem(ListItem<StringPair> item) {
                item.add(new Label("title", item.getModelObject().getTitle()));
                item.add(new Label("content", item.getModelObject().getContent()));
            }
        };
        final WebMarkupContainer tableContainer = new WebMarkupContainer("tableContainer");
        tableContainer.setOutputMarkupId(true);
        AjaxButton button = new IndicatingAjaxButton("acceptButton", form) {

            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                super.onSubmit(target);

                outputModel.setObject("");
                listModel.setObject(new ArrayList<>());

                HttpRequest request = HttpRequest.newBuilder(URI.create("https://restcountries.com/v3.1/name/" + ((FormObject) getForm().getModelObject()).getInput()))
                    .GET()
                    .build();

                HttpClient client = HttpClient.newHttpClient();
                HttpResponse<String> response;
                try {
                    List<StringPair> contentPair = new ArrayList<>();

                    response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    if (response.statusCode() != 200) {
                        JSONObject json = new JSONObject(response.body());
                        outputModel.setObject("Status Code: " + response.statusCode() + "\n" + json.get("message"));
                        target.add(output);
                        target.add(tableContainer);
                        return;
                    }

                    if (((FormObject) getForm().getModelObject()).getRawResponse()) {
                        output.setDefaultModelObject(response.body());
                    }
                    else {
                        JSONObject json = new JSONObject(response.body().substring(1, response.body().length() - 1));

                        final JSONArray jsonArray = (JSONArray) json.get("borders");
                        final List<String> list = new ArrayList<>();
                        if (jsonArray != null) {
                            int len = jsonArray.length();
                            for (int i=0;i<len;i++){
                                list.add(jsonArray.get(i).toString());
                            }
                        }

                        contentPair.add(new StringPair("borders: ", Joiner.on(", ").join(list)));
                        contentPair.add(new StringPair("capital: ", Joiner.on(", ").join(extractJsonArray((JSONArray) json.get("capital")))));
                        contentPair.add(new StringPair("subregion: ", json.get("subregion").toString()));
                        contentPair.add(new StringPair("region: ", json.get("region").toString()));
                        contentPair.add(new StringPair("timezones: ", Joiner.on(", ").join(extractJsonArray((JSONArray) json.get("timezones")))));
                        listModel.setObject(contentPair);
                    }
                }
                catch (IOException | InterruptedException e) {
                    outputModel.setObject("Verbindung zum API fehlgeschlagen!");
                }

                target.add(output);
                target.add(tableContainer);
            }

            private List<String> extractJsonArray(JSONArray jsonArray) {
                final List<String> list = new ArrayList<>();
                if (jsonArray != null) {
                    int len = jsonArray.length();
                    for (int i=0;i<len;i++){
                        list.add(jsonArray.get(i).toString());
                    }
                }

                return list;
            }
        };

        add(form);
        form.add(tableContainer);
        form.add(eingabe1);
        form.add(output);
        form.add(button);
        form.add(checkBox);
        tableContainer.add(listView);

    }

    private class StringPair implements Serializable {
        String title;
        String content;

        public StringPair(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
