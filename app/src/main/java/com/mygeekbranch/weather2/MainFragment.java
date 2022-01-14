package com.mygeekbranch.weather2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    RecyclerView weekRecyclerView;
    List <WeekWeatherModel> weekList;
    WeekAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initWeekList();
        weekRecyclerView = view.findViewById(R.id.week_recyclerView);
        weekRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        weekRecyclerView.setLayoutManager(layoutManager);

        // Декорация карточек (полоска между карточками)
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.item_seporator));
        weekRecyclerView.addItemDecoration(itemDecoration);


        adapter = new WeekAdapter(weekList);
        weekRecyclerView.setAdapter(adapter);




        Button city_button = getView().findViewById(R.id.buttonCity);
        city_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new CityFragment() )
                        .addToBackStack(null)
                        .commit();


            }
        });

        Button setting_button = getView().findViewById(R.id.buttonSetting);
        setting_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new SettingFragment() )
                        .addToBackStack(null)
                        .commit();


            }
        });
    }
    public void initWeekList(){
       weekList = new ArrayList<>();
       weekList.add(new WeekWeatherModel("ПН","+12"));
       weekList.add(new WeekWeatherModel("Вт","+5"));
       weekList.add(new WeekWeatherModel("СР","+7"));
       weekList.add(new WeekWeatherModel("ЧТ","+8"));
       weekList.add(new WeekWeatherModel("ПТ","+10"));
       weekList.add(new WeekWeatherModel("СБ","+17"));
       weekList.add(new WeekWeatherModel("ВС","+20"));

    }


}