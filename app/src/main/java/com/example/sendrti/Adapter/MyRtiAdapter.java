package com.example.sendrti.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sendrti.ModelClass.ChatModel;
import com.example.sendrti.ModelClass.RtiModel;
import com.example.sendrti.R;

import java.util.ArrayList;
import java.util.List;

public class MyRtiAdapter extends RecyclerView.Adapter<MyRtiAdapter.MyViewholder> {

    private ArrayList<RtiModel> dataSet = new ArrayList<>();
    private Context mContext;

    public MyRtiAdapter(ArrayList<RtiModel> rtiModels, Context activity) {
        this.dataSet = rtiModels;
        this.mContext = activity;


    }

    @NonNull
    @Override
    public MyRtiAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.myrtiadapter, parent, false);
        return new MyViewholder(view);
    }

    public Context getmContext() {
        return mContext;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRtiAdapter.MyViewholder holder, int position) {


         RtiModel movie = dataSet.get(position);
         holder.rtiApplication.setText(movie.getRtiAppliactionNumber());
         holder.month.setText(movie.getMonth());
         holder.status.setText(movie.getStatus());
         holder.data.setText(movie.getDate());
         holder.btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Navigation.findNavController(v).navigate(R.id.nav_pricing2);
             }
         });


    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
    public class MyViewholder extends RecyclerView.ViewHolder{
        private TextView rtiApplication;
        private TextView status;
        private TextView data;
        private TextView month;
        private Button btn;

        public MyViewholder(@NonNull View itemView) {

            super(itemView);
            status = itemView.findViewById(R.id.statuspending);
            data = itemView.findViewById(R.id.number);
            month = itemView.findViewById(R.id.date);
            rtiApplication = itemView.findViewById(R.id.Rtiappliaction);
            btn = itemView.findViewById(R.id.Paynow);
        }


    }
}
