package com.example.sendrti.ModelClass;

public class ChatModel2 {
    public static final int SENDERTYPE=0;
    public static final int RECEIVERTYPE=2;

    public int type;
    public String text;
    public ImageModel2 imageModel;



    public ImageModel2 getImageModel() {
        return imageModel;
    }

    public void setImageModel(ImageModel2 imageModel) {
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

    public ChatModel2(int type, String text)
    {
        this.type=type;

        this.text=text;
    }
    public ChatModel2(ImageModel2 imageModel)
    {

        this.imageModel = imageModel;
    }
}
