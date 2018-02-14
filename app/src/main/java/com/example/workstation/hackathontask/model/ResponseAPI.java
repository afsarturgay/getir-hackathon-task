package com.example.workstation.hackathontask.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by workstation on 03/02/2018.
 */

public class ResponseAPI {
    @SerializedName("code")
    private Integer code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("records")
    private List<Record> records = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}

