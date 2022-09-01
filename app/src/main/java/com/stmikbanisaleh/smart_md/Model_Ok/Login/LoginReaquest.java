package com.stmikbanisaleh.smart_md.Model_Ok.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginReaquest {

//    @SerializedName("id")
//    @Expose
//    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("password")
    @Expose
    private String password;

//    @SerializedName("role_id")
//    @Expose
//    private String role_id;

    public LoginReaquest() {
    }
    public LoginReaquest(String id, String name, String email, String password, String role_id) {
//        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
//        this.role_id = role_id;
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getRole_id() {
//        return role_id;
//    }
//
//    public void setRole_id(String role_id) {
//        this.role_id = role_id;
//    }
}
