package com.product.general_stores.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "Get_In_Touch")
public class GetInTouch {

    @MongoId
    private String id;
    private String name;
    private String email;
    private String subject;
    private String desc_message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDesc_message() {
        return desc_message;
    }

    public void setDesc_message(String desc_message) {
        this.desc_message = desc_message;
    }

    public GetInTouch(String name, String email, String subject, String desc_message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.desc_message = desc_message;
    }

    @Override
    public String toString() {
        return "GetInTouch{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + desc_message + '\'' +
                '}';
    }
}
