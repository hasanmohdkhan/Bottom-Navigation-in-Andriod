package com.example.hasanzian.bottomnavigation;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
        // method for loading Fragment in frameLayout
        loadFragment(new StoreFragment());
 


    }




    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    android.support.v4.app.Fragment fragment;
                    switch (item.getItemId()){

                        case R.id.navigation_shop:
                            toolbar.setTitle("Shop");
                            fragment = new StoreFragment();
                            loadFragment(fragment);

                            return true;

                        case R.id.navigation_gift:
                            toolbar.setTitle("My Gifts");
                            fragment = new GiftFragment();
                            loadFragment(fragment);
                            return true;

                        case R.id.navigation_cart:
                            toolbar.setTitle("Cart");
                            fragment = new CartFragment();
                            loadFragment(fragment);
                            return true;

                        case R.id.navigation_profile:
                            toolbar.setTitle("Profile");
                            fragment = new ProfileFragment();
                            loadFragment(fragment);
                            return true;

                    }







                    return false;
                }
            };



    private void loadFragment(Fragment fragment)
    {
     // Load Fragment
        // Fragment Transition for 1 activity to another
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        // Setting fragment into frame_container(@link FrameLayout) into main_activity.xml
        transaction.replace(R.id.frame_container,fragment);

        // By calling addToBackStack(), the replace transaction is saved to
        // the back stack so the user can reverse the transaction and bring
        // back the previous fragment by pressing the Back button.
        transaction.addToBackStack(null);
        // commit loading fragment
        transaction.commit();



    }

}
