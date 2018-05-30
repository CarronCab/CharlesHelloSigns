package com.example.charl.charleshellosigns.Tutorials;


import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.example.charl.charleshellosigns.R;

public class FamilyActivity extends AppCompatActivity {
    ViewPager viewPager;
    FamilySwipeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counting);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new FamilySwipeAdapter(this);
        viewPager.setAdapter(adapter);
    }
}

