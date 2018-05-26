package com.example.charl.charleshellosigns;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Objects;


public class ResultActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        //Declaration de la bar d'outils
        Toolbar toolbar = findViewById(R.id.main_menu_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml("<font color='#ffffff'>HelloSigns </font>"));
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        //Declaration du drawer de navigation
        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);


                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here


                        int id = menuItem.getItemId();
                        switch (id) {
                            case R.id.quizzes:
                                Intent intent = new Intent(ResultActivity.this, QuizSelection.class);
                                startActivity(intent);
                                return true;
                            case R.id.home:
                                Intent MainMenu = new Intent(ResultActivity.this, MainMenu.class);
                                startActivity(MainMenu);
                                return true;
                        }

                        return true;
                    }
                });




//get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
//get text view
        TextView t=(TextView)findViewById(R.id.textResult);
        TextView tscore=(TextView)findViewById(R.id.textScore);
//get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");

//display score
        bar.setRating(score);
        bar.setClickable(false);
        bar.setFocusable(false);
        bar.setFilterTouchesWhenObscured(false);
        switch (score)
        {
            case 0: t.setText("Raté !");
                tscore.setText("0/5");
                break;
            case 1: t.setText("Raté !");
                tscore.setText("1/5");
                break;
            case 2: t.setText("Moyen !");
                tscore.setText("2/5");
                break;
            case 3: t.setText("Ca passe !");
                tscore.setText("3/5");
                break;
            case 4:t.setText("Pas mal !");
                tscore.setText("4/5");
                break;
            case 5:t.setText("Incroyable ! Score parfait !");
                tscore.setText("5/5");
                break;
        }
    }

    public void goToResults(View view) {
        Intent intent = new Intent(this, QuizSelection.class);
        startActivity(intent);
    }

    //Création du menu
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.main_menu, menu);

        //Recuperation d'un mot recherche par le dictionaire

        return super.onCreateOptionsMenu(menu);

        //return true;
    }

    //Parametre du menu
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}