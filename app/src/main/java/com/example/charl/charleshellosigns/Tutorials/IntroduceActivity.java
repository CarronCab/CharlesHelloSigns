package com.example.charl.charleshellosigns.Tutorials;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

import com.example.charl.charleshellosigns.R;

public class IntroduceActivity extends AppCompatActivity {
    ViewPager viewPager;
    IntroduceSwipeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counting);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new IntroduceSwipeAdapter(this);
        viewPager.setAdapter(adapter);
    }

}
