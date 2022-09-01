package com.stmikbanisaleh.smart_md.Model_Ok.History;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListHistory {

    @SerializedName("created_date")
    @Expose
    private String created_date;

    @SerializedName("store_id")
    @Expose
    private String store_id;

    @SerializedName("store_name")
    @Expose
    private String store_name;

    @SerializedName("product_name")
    @Expose
    private String product_name;


    public ListHistory() {
    }

    public ListHistory(String created_date, String store_id, String store_name, String product_name) {
        this.created_date = created_date;
        this.store_id = store_id;
        this.store_name = store_name;
        this.product_name = product_name;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
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

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
}
