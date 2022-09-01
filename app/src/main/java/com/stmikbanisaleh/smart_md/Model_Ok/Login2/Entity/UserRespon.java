package com.stmikbanisaleh.smart_md.Model_Ok.Login2.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRespon {


    @SerializedName("Data")
    @Expose
    private User Data;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private boolean status;

    public UserRespon() {
    }

    public UserRespon(User data, String message, boolean status) {
        Data = data;
        this.message = message;
        this.status = status;
    }

    public User getData() {
        return Data;
    }

    public void setData(User data) {
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
