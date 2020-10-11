package com.example.finalbloodcare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList hos_id, hos_name, hos_district, hos_no;


    HospitalAdapter(Activity activity, Context context, ArrayList hos_id, ArrayList hos_name, ArrayList hos_district,
                    ArrayList hos_no) {
        this.activity = activity;
        this.context = context;
        this.hos_id = hos_id;
        this.hos_name = hos_name;
        this.hos_district = hos_district;
        this.hos_no = hos_no;
    }

    @androidx.annotation.NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        android.view.View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull MyViewHolder holder, final int position) {

        holder.hos_id_txt.setText(String.valueOf(hos_id.get(position)));
        holder.hos_name_txt.setText(String.valueOf(hos_name.get(position)));
        holder.hos_district_txt.setText(String.valueOf(hos_district.get(position)));
        holder.hos_mob_txt.setText(String.valueOf(hos_no.get(position)));

        holder.mainLayout.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(context, Edit_hospital.class);
                intent.putExtra("id", String.valueOf(hos_id.get(position)));
                intent.putExtra("name", String.valueOf(hos_name.get(position)));
                intent.putExtra("district", String.valueOf(hos_district.get(position)));
                intent.putExtra("phone", String.valueOf(hos_no.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return hos_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        android.widget.TextView hos_id_txt, hos_name_txt, hos_district_txt, hos_mob_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@androidx.annotation.NonNull android.view.View itemView) {
            super(itemView);
            hos_id_txt = itemView.findViewById(R.id.hos_id);
            hos_name_txt = itemView.findViewById(R.id.hos_name_text);
            hos_district_txt = itemView.findViewById(R.id.hos_district_text);
            hos_mob_txt = itemView.findViewById(R.id.hos_phone_text);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
