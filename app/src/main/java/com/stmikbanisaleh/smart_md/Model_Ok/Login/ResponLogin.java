package com.stmikbanisaleh.smart_md.Model_Ok.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponLogin {


    @SerializedName("message")
    @Expose
    private  String message;

    @SerializedName("status")
    @Expose
    private  boolean status;

    @SerializedName("Token")
    @Expose
    private  String Token;

    @SerializedName("name")
    @Expose
    private  String name;

    public ResponLogin() {
    }

    public ResponLogin(String message, boolean status, String token, String name) {
        this.message = message;
        this.status = status;
        Token = token;
        this.name = name;
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

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
