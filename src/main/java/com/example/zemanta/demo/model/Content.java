package com.example.zemanta.demo.model;

/**
 * Model to be displayed to the user in console
 */
public class Content {
    private final String contentBody;

    public Content(String contentBody) {
        this.contentBody = contentBody;
    }

    // Getter required for conversion to JSON
    public String getContentBody() {
        return contentBody;
    }
}
