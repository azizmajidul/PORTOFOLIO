package com.stmikbanisaleh.smart_md.Model_Ok.History;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.stmikbanisaleh.smart_md.Model_Ok.Visit.ListVisit;

import java.util.List;

public class ResponHistory {

    @SerializedName("Data")
    @Expose
    private List<ListHistory> Data;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private boolean status;

    public ResponHistory() {
    }

    public ResponHistory(List<ListHistory> data, String message, boolean status) {
        Data = data;
        this.message = message;
        this.status = status;
    }

    public List<ListHistory> getData() {
        return Data;
    }

    public void setData(List<ListHistory> data) {
        Data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
