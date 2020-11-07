package com.example.sendrti.ModelClass;

public class ImageModel {
    private int type;
    private int url_file;
    private int url_file2;


    public ImageModel(int type, int url_file) {
        this.type = type;
        this.url_file = url_file;

    }
    public ImageModel(int url_file) {
        this.url_file2 = url_file;

    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUrl_file() {
        return url_file;
    }

    public void setUrl_file(int url_file) {
        this.url_file = url_file;
    }

}
