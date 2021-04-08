package com.example.yaz_1_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TableLayout;

import com.example.yaz_1_1.model.VP2Adapter;
import com.google.android.material.tabs.TabLayout;

public class TabbedActivity extends AppCompatActivity {


    TabLayout tabLayout;
    ViewPager2 viewPagerMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        tabLayout =  findViewById(R.id.tablayout_main);
        viewPagerMain = findViewById(R.id.vpMain);
        VP2Adapter adapter = new VP2Adapter(this,3);
        viewPagerMain.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerMain.setCurrentItem(tab.getPosition());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}