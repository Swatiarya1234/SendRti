package com.example.sendrti.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sendrti.ModelClass.ChatModel;
import com.example.sendrti.R;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter {

    private ArrayList<ChatModel>dataSet = new ArrayList<>();
    Context mContext;
    int total_types;

    public ChatAdapter(ArrayList<ChatModel>data, Context context) {
        this.dataSet = data;
        this.mContext = context;
        total_types = dataSet.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View listItem= layoutInflater.inflate(R.layout.activity_image_imageleft, parent, false);
//        MyViewHolder viewHolder = new MyViewHolder(listItem);

        View view;
        switch (viewType) {

            case ChatModel.RECEIVERTYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.activity_image_imageleft, parent, false);
                return new MyViewHolder(view);
            case ChatModel.SENDERTYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_image_imageright, parent, false);
                return new MyViewHolder2(view);

//            case Model.AUDIO_TYPE:
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.audio_type, parent, false);
//                return new AudioTypeViewHolder(view);
        }
        return null;

      //  return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


    }

    @Override
    public int getItemViewType(int position) {

        switch (dataSet.get(position).type) {
            case 0:
                return ChatModel.RECEIVERTYPE;
            case 1:
                return ChatModel.SENDERTYPE;

//            case 2:
//                return ChatModel.AUDIO_TYPE;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder{
        TextView image;
        ImageView imageView;
        public MyViewHolder2(View itemView){
            super(itemView);
           // imageView.setVisibility(itemView);

        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
