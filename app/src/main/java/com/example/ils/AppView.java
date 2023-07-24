package com.example.ils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.view.FrameMetrics;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.ils.fragments.Activities;
import com.example.ils.fragments.ForYou;
import com.example.ils.fragments.Home;
import com.example.ils.fragments.Profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class AppView extends AppCompatActivity {

    private Context AppCxt = AppView.this;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_view);

        Helpers helper = new Helpers();

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case (R.id.item_1):
                        helper.replaceFragment(AppCxt, new Home());
//                        replaceFragment(new Home());
                        break;
                    case (R.id.item_2):
                        helper.replaceFragment(AppCxt, new ForYou());
                        break;
                    case (R.id.item_3):
                        helper.replaceFragment(AppCxt, new Activities());
                        break;
                    case (R.id.item_4):
                        helper.replaceFragment(AppCxt, new Profile());
                }
                return true;
            }
        });

    }
}
