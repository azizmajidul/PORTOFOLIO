package com.stmikbanisaleh.smart_md.Model_Ok.Visit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListVisit {
    @SerializedName("schedule_id")
    @Expose
    private int schedule_id;
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("id_toko")
    @Expose
    private String id_toko;

    @SerializedName("store_id")
    @Expose
    private String store_id;

    @SerializedName("store_name")
    @Expose
    private String store_name;

    public ListVisit() {
    }

    public ListVisit(int schedule_id, String id_toko, String store_id, String store_name, String id) {
        this.schedule_id = schedule_id;
        this.id_toko = id_toko;
        this.store_id = store_id;
        this.store_name = store_name;
        this.id = id;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getId_toko() {
        return id_toko;
    }

    public void setId_toko(String id_toko) {
        this.id_toko = id_toko;
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
