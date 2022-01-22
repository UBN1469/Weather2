package com.mygeekbranch.weather2;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
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
//
//                Bundle bundle = new Bundle();
//                bundle.putString("city","Kiev");
//                MainFragment mainFragment =new MainFragment();
//                mainFragment.setArguments(bundle);
//
//                getParentFragmentManager().beginTransaction()
//                        .replace(R.id.main_container , MainFragment.instanceOf())
//                        .commit();

               


            }
        });


    }

    public  void initFragmentMain(String city){

        Bundle bundle = new Bundle();
        bundle.putString("city",city);
        MainFragment mainFragment =new MainFragment();
        mainFragment.setArguments(bundle);

         getParentFragmentManager().beginTransaction()
                .replace(R.id.main_container , mainFragment)
                .commit();
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
        cityAdapter =new CityAdapter(cityModels ,this);
        cityRecyclerView.setAdapter(cityAdapter);
    }


}