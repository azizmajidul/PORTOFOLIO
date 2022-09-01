package com.stmikbanisaleh.smart_md.Model_Ok.Visit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.List;

public class PagingResponStore_v {

    @SerializedName("Data")
    @Expose
    private List<ListVisit> Data;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private boolean status;

    @SerializedName("totalcount")
    @Expose
    int totalcount;

    public PagingResponStore_v() {
    }

    public PagingResponStore_v(List<ListVisit> data, String message, boolean status, int totalcount) {
        Data = data;
        this.message = message;
        this.status = status;
        this.totalcount = totalcount;
    }

    public List<ListVisit> getData() {
        return Data;
    }

    public void setData(List<ListVisit> data) {
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

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }
}
