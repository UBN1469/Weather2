package com.mygeekbranch.weather2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class CityFragment extends Fragment {
    private RecyclerView cityRecyclerView;
    private CityAdapter cityAdapter;
    private List <CityModel> cityModels;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initLIstCity();
        buildRecyclerVew(view);
        EditText setCityEditText = getView().findViewById(R.id.set_city_edit_text);
        Button setCityButton = getView().findViewById(R.id.set_city_button);
        setCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = setCityEditText.getText().toString();
                cityModels.add(new CityModel(city));
                cityAdapter.notifyDataSetChanged();
            }
        });


    }

    private   void initLIstCity(){
        cityModels = new ArrayList<>();
        cityModels.add(new CityModel("Moscow"));
        cityModels.add(new CityModel("New York"));
        cityModels.add(new CityModel("Denwer"));

    }

    private   void buildRecyclerVew(View view){
        cityRecyclerView = view.findViewById(R.id.city_recyclerView);
        cityRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        cityRecyclerView.setLayoutManager(layoutManager);
        cityAdapter =new CityAdapter(cityModels);
        cityRecyclerView.setAdapter(cityAdapter);
    }


}