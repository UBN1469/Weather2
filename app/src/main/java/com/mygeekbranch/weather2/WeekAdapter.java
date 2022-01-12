package com.mygeekbranch.weather2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WeekAdapter extends RecyclerView.Adapter<WeekAdapter.ViewHolder> {
    private List <WeekWeatherModel> list;

    public WeekAdapter(List<WeekWeatherModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.week_weather_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.day.setText(list.get(position).getDate());
        holder.temperature.setText(list.get(position).getTemperature());

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView day, temperature;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.DayWeek);
            temperature =itemView.findViewById(R.id.DayTemperature);
        }
    }
}
