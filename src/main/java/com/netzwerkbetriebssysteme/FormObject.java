package com.netzwerkbetriebssysteme;

import java.io.Serializable;

public class FormObject implements Serializable {

    String input;
    Boolean rawResponse;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Boolean getRawResponse() {
        return rawResponse;
    }

    public void setRawResponse(Boolean rawResponse) {
        this.rawResponse = rawResponse;
    }
}
