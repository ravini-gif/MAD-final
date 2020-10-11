package com.example.finalbloodcare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList event_id, event_name, location, date,time;


    EventAdapter(Activity activity, Context context, ArrayList event_id, ArrayList event_name, ArrayList location,
                    ArrayList date, ArrayList time) {
        this.activity = activity;
        this.context = context;
        this.event_id = event_id;
        this.event_name = event_name;
        this.location = location;
        this.date =  date;
        this.time = time;
    }

    @androidx.annotation.NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        android.view.View view = inflater.inflate(R.layout.my_row2, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull EventAdapter.MyViewHolder holder, final int position) {

        holder.e_id_txt.setText(String.valueOf(event_id.get(position)));
        holder.ename_txt.setText(String.valueOf(event_name.get(position)));
        holder.location_txt.setText(String.valueOf(location.get(position)));
        holder.date_txt.setText(String.valueOf(date.get(position)));
        holder.time_txt.setText(String.valueOf(time.get(position)));
        holder.mainLayout.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(context, Edit_hospital.class);
                intent.putExtra("id", String.valueOf(event_id.get(position)));
                intent.putExtra("name", String.valueOf(event_name.get(position)));
                intent.putExtra("mail", String.valueOf(location.get(position)));
                intent.putExtra("phone", String.valueOf(date.get(position)));
                intent.putExtra("phone", String.valueOf(time.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return event_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        android.widget.TextView e_id_txt, ename_txt, location_txt, date_txt,time_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@androidx.annotation.NonNull android.view.View itemView) {
            super(itemView);
            e_id_txt = itemView.findViewById(R.id.event_id);
            ename_txt = itemView.findViewById(R.id.event_name_text);
            location_txt = itemView.findViewById(R.id.event_location_text);
            date_txt = itemView.findViewById(R.id.date_text);
            time_txt = itemView.findViewById(R.id.time_text);
            mainLayout = itemView.findViewById(R.id.mainLayout2);
        }
    }
}
