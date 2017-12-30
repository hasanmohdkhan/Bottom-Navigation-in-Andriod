package com.example.hasanzian.bottomnavigation;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //toolbar
        toolbar = getSupportActionBar();

        //linking Navigation
        BottomNavigationView navigation = (BottomNavigationView)findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar.setTitle("Shop");



    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment;
                    switch (item.getItemId()){

                        case R.id.navigation_shop:
                            toolbar.setTitle("Shop");
                            return true;

                        case R.id.navigation_gift:
                            toolbar.setTitle("Gifts");
                            return true;

                        case R.id.navigation_cart:
                            toolbar.setTitle("Cart");
                            return true;

                        case R.id.navigation_profile:
                            toolbar.setTitle("Profile");
                            return true;

                    }







                    return false;
                }
            };





}
