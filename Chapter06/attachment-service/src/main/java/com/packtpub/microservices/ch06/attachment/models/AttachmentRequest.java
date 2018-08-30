package com.packtpub.microservices.ch06.attachment.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class AttachmentRequest {
    private String fileName;

    private String data;

    public AttachmentRequest() {}

    public AttachmentRequest(String fileName, String data) {
        this.fileName = fileName;
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @JsonProperty("file")
    private void unpackFileName(Map<String, String> file) {
        this.fileName = file.get("name");
        this.data = file.get("data");
    }
}
