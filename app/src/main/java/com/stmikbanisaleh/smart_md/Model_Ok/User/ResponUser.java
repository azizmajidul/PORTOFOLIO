package com.stmikbanisaleh.smart_md.Model_Ok.User;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.stmikbanisaleh.smart_md.Model_Ok.Visit.ListVisit;

import java.util.List;

public class ResponUser {


    @SerializedName("Data")
    @Expose
    private List<UserList> Data;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private boolean status;

    public ResponUser() {
    }

    public ResponUser(List<UserList> data, String message, boolean status) {
        Data = data;
        this.message = message;
        this.status = status;
    }

    public List<UserList> getData() {
        return Data;
    }

    public void setData(List<UserList> data) {
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
