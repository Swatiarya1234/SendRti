package com.example.sendrti.ModelClass;

public class ChatModel {

    public static final int SENDERTYPE=0;
    public static final int RECEIVERTYPE=2;

    public int type;
    public String text;
    public ImageModel imageModel;



    public ImageModel getImageModel() {
        return imageModel;
    }

    public void setImageModel(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ChatModel(int type, String text)
    {
        this.type=type;

        this.text=text;
    }
    public ChatModel(ImageModel imageModel)
    {

        this.imageModel = imageModel;
    }
}
