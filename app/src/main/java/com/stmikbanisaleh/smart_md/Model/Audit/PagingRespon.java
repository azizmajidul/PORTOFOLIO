package com.stmikbanisaleh.smart_md.Model.Audit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.stmikbanisaleh.smart_md.Model.Audit.Store_list;

import java.util.List;

public class PagingRespon {
    @SerializedName("Data")
    @Expose
    private List<Store_list> Data;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private boolean status;


    //Note Data sesuai dengan API

    public PagingRespon() {
    }

    public PagingRespon(List<Store_list> data, String message, boolean status) {
        Data = data;
        this.message = message;
        this.status = status;
    }

    public List<Store_list> getData() {
        return Data;
    }

    public void setData(List<Store_list> data) {
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
