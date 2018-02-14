package com.example.workstation.hackathontask.model;

import com.google.gson.annotations.SerializedName;

public class Record{
    @SerializedName("_id")
    private Id id;
    @SerializedName("totalCount")
    private Integer totalCount;

    public Id getId() {
        return id;
    }

    public Integer getTotalCount() {
        return totalCount;
    }
}
