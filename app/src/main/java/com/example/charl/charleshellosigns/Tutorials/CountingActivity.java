package com.example.charl.charleshellosigns.Tutorials;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.charl.charleshellosigns.R;


public class CountingActivity extends AppCompatActivity {
    ViewPager viewPager;
    com.example.charl.charleshellosigns.Tutorials.CountingSwipeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counting);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new com.example.charl.charleshellosigns.Tutorials.CountingSwipeAdapter(this);
        viewPager.setAdapter(adapter);
    }
}
