package com.mygeekbranch.weather2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentFragment = getSupportFragmentManager().findFragmentById(R.id.main_container);

        if (currentFragment == null){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container , new MainFragment())
                .commit();
    }
    }
}