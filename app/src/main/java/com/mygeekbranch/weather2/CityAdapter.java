package com.mygeekbranch.weather2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder>{
    private List<CityModel> modelList;
    CityFragment cityFragment;

    public CityAdapter(List<CityModel> modelList, CityFragment cityFragment) {
        this.modelList = modelList;
        this.cityFragment =cityFragment;
    }

    @NonNull
        @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.city.setText(modelList.get(position).getCity());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), holder.city.getText(),Toast.LENGTH_SHORT).show();
                cityFragment.initFragmentMain(holder.city.getText().toString());

            }

        });

    }



    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView city;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            city= itemView.findViewById(R.id.city_item_textView);
        }
    }


}
