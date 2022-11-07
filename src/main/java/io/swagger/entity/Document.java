package io.swagger.entity;

import javax.persistence.*;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int document_id;

    private String name;

    private String mimeType;

    private String content;

    public Document() {
    }

    public Document(String name, String mimeType, String content) {
        this.name = name;
        this.mimeType = mimeType;
        this.content = content;
    }

    public Document(int document_id, String name, String mimeType, String content) {
        this.document_id = document_id;
        this.name = name;
        this.mimeType = mimeType;
        this.content = content;
    }

    public int getDocument_id() {
        return document_id;
    }

    public void setDocument_id(int document_id) {
        this.document_id = document_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
