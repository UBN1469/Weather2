package com.mygeekbranch.weather2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder>{


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.city.setText("Привет");

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView city;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            city= itemView.findViewById(R.id.city_item_textView);
        }
    }
}
