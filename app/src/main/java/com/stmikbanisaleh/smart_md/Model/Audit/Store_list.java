package com.stmikbanisaleh.smart_md.Model.Audit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;




public class Store_list {

    @SerializedName("schedule_id")
    @Expose
    private int schedule_id;
    @SerializedName("store_id")
    @Expose
    private String store_id;
    @SerializedName("store_name")
    @Expose
    private String store_name;

    public Store_list() {
    }

    public Store_list(int schedule_id, String store_id, String store_name) {
        this.schedule_id = schedule_id;
        this.store_id = store_id;
        this.store_name = store_name;
    }

    public int getId() {
        return schedule_id;
    }

    public void setId(int id) {
        this.schedule_id = id;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }


}
