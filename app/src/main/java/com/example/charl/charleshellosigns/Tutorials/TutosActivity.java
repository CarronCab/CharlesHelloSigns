package com.example.charl.charleshellosigns.Tutorials;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.charl.charleshellosigns.R;

public class TutosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutos);
    }

    public void goToCounting(View view) {
        Intent intent = new Intent(this, CountingActivity.class);
        startActivity(intent);
    }

    public void goToFamily(View view) {
        Intent intent = new Intent(this, FamilyActivity.class);
        startActivity(intent);
    }
    public void goToTime(View view) {
        Intent intent = new Intent(this, TimeActivity.class);
        startActivity(intent);
    }

    public void goToIntroduce(View view) {
        Intent intent = new Intent(this, IntroduceActivity.class);
        startActivity(intent);
    }

}
