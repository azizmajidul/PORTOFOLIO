package com.stmikbanisaleh.smart_md.Model_Ok.Report;

import com.google.gson.annotations.SerializedName;
import com.stmikbanisaleh.smart_md.Ui.Report;

public class PostReport {
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;

    @SerializedName("data")
    String data;
    Report report;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        report = report;
    }
}
