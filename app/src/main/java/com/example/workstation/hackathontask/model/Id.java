package com.example.workstation.hackathontask.model;

import com.google.gson.annotations.SerializedName;

public class Id{
    @SerializedName("_id")
    private String id;
    @SerializedName("key")
    private String key;
    @SerializedName("value")
    private String value;
    @SerializedName("createdAt")
    private String createdAt;

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
