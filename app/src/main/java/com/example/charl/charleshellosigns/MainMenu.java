package com.example.charl.charleshellosigns;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.charl.charleshellosigns.AccountActivity.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;


public class MainMenu extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        //Declaration de la bar d'outils
        Toolbar toolbar = findViewById(R.id.main_menu_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml("<font color='#ffffff'>HelloSigns </font>"));
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);


        //Ouverture de l'activite de selection de quiz
        Button btn_quiz = (Button)findViewById(R.id.button_Quiz);
        btn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent l'activity lesson/tuto //
                Intent QuizSelection = new Intent(MainMenu.this, QuizSelection.class);
                startActivity(QuizSelection);
            }
        });

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
                                Intent intent = new Intent(MainMenu.this, QuizSelection.class);
                                startActivity(intent);
                                return true;

                            case R.id.deconnection:
                                Intent login = new Intent (MainMenu.this, MainActivity.class);
                                startActivity(login);
                            return true;

                            case R.id.dictionary:
                                Intent dict = new Intent (MainMenu.this, Dictionary.class);
                                startActivity(dict);
                                return true;
                        }

                        return true;
                    }
                });
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
