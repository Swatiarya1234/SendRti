package com.example.sendrti.ModelClass;

public class RtiModel2 {
    private String RtiAppliactionNumber;
    private String status;
    private String date;
    private String month;

    public RtiModel2(String rtiAppliactionNumber, String status, String date, String month) {
        RtiAppliactionNumber = rtiAppliactionNumber;
        this.status = status;
        this.date = date;
        this.month = month;
    }


    public String getRtiAppliactionNumber() {
        return RtiAppliactionNumber;
    }

    public void setRtiAppliactionNumber(String rtiAppliactionNumber) {
        RtiAppliactionNumber = rtiAppliactionNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }



}
