package com.example.charl.charleshellosigns.Tutorials;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charl.charleshellosigns.R;


public class TimeActivity extends AppCompatActivity{
    ViewPager viewPager;
    TimeSwipeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counting);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new TimeSwipeAdapter(this);
        viewPager.setAdapter(adapter);
    }
}
