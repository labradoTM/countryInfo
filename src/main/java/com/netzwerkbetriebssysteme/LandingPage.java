package com.netzwerkbetriebssysteme;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;

public class LandingPage extends WebPage {

    IModel<String> outputModel;

    public LandingPage() {

    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        outputModel = new Model<>("");
        IModel<String> eingabe1Model = new Model<>("");

        Form<FormObject> form = new Form<>("form", new Model<FormObject>(new FormObject()));
        TextField<String> eingabe1 = new TextField<>("eingabe1", eingabe1Model);
        Label output = new Label("output", outputModel);
        output.setOutputMarkupId(true);
        AjaxButton button = new AjaxButton("acceptButton", form) {

            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                super.onSubmit(target);

                HttpRequest request = HttpRequest.newBuilder(URI.create("https://restcountries.com/v3.1/name/deutschland"))
                    .GET()
                    .build();

                HttpClient client = HttpClient.newHttpClient();
                HttpResponse<String> response;
                try {
                    response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    outputModel.setObject(response.body());
                } catch (IOException | InterruptedException e) {
                    outputModel.setObject("Verbindung zum API fehlgeschlagen!");
                }

                target.add(output);
            }

        };

        add(form);
        form.add(eingabe1);
        form.add(output);
        form.add(button);
    }
}
