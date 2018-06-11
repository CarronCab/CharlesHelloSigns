package com.example.charl.charleshellosigns;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.charl.charleshellosigns.Tutorials.TutosActivity;

import java.util.Objects;

public class Dictionary extends AppCompatActivity {

    ImageView picture;
    EditText textEdit;

    private DrawerLayout mDrawerLayout;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        picture = (ImageView)findViewById(R.id.pictureDict);
        picture.setImageResource(0);
        textEdit = (EditText)findViewById(R.id.inputDict);

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


                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here


                        int id = menuItem.getItemId();
                        switch (id) {
                            case R.id.home:
                                Intent home = new Intent(Dictionary.this, MainMenu.class);
                                startActivity(home);
                                return true;
                            case R.id.quizzes:
                                Intent intent = new Intent(Dictionary.this, QuizSelection.class);
                                startActivity(intent);
                                return true;

                            case R.id.deconnection:
                                Intent login = new Intent (Dictionary.this, MainActivity.class);
                                startActivity(login);
                                return true;

                            case R.id.lessons:
                                Intent lecon = new Intent( Dictionary.this, TutosActivity.class);
                                startActivity(lecon);
                                return true;

                            case R.id.parametre:
                                Intent param = new Intent(Dictionary.this, ProfileActivity.class);
                                startActivity(param);
                                return true;

                        }

                        return true;
                    }
                });

    }

    public void research(View view){
        setPictures(textEdit.getText().toString(), picture);
    }

    private void setPictures(String rd, ImageView pic){
        if(rd.equalsIgnoreCase("1") || rd.equalsIgnoreCase("un")){
            pic.setImageResource(R.drawable.signe1);
        }
        else if(rd.equalsIgnoreCase("2") || rd.equalsIgnoreCase("Deux")){
            pic.setImageResource(R.drawable.signe2);
        }
        else if(rd.equalsIgnoreCase("3") || rd.equalsIgnoreCase("Trois")){
            pic.setImageResource(R.drawable.signe3);
        }
        else if(rd.equalsIgnoreCase("4") || rd.equalsIgnoreCase("Quatre")){
            pic.setImageResource(R.drawable.signe4);
        }
        else if(rd.equalsIgnoreCase("5") || rd.equalsIgnoreCase("Cinq")){
            pic.setImageResource(R.drawable.signe5);
        }
        else if(rd.equalsIgnoreCase("6") || rd.equalsIgnoreCase("Six")){
            pic.setImageResource(R.drawable.signe6);
        }
        else if(rd.equalsIgnoreCase("7") || rd.equalsIgnoreCase("Sept")){
            pic.setImageResource(R.drawable.signe7);
        }
        else if(rd.equalsIgnoreCase("8") || rd.equalsIgnoreCase("Huit")){
            pic.setImageResource(R.drawable.signe8);
        }
        else if(rd.equalsIgnoreCase("9") || rd.equalsIgnoreCase("Neuf")){
            pic.setImageResource(R.drawable.signe9);
        }
        else if(rd.equalsIgnoreCase("10") || rd.equalsIgnoreCase("Dix")){
            pic.setImageResource(R.drawable.signe10);
        }
        else if(rd.equalsIgnoreCase("11") || rd.equalsIgnoreCase("Onze")){
            pic.setImageResource(R.drawable.signe11);
        }
        else if(rd.equalsIgnoreCase("12") || rd.equalsIgnoreCase("Douze")){
            pic.setImageResource(R.drawable.signe12);
        }
        else if(rd.equalsIgnoreCase("13") || rd.equalsIgnoreCase("Treize")){
            pic.setImageResource(R.drawable.signe13);
        }
        else if(rd.equalsIgnoreCase("14") || rd.equalsIgnoreCase("Quatorze")){
            pic.setImageResource(R.drawable.signe14);
        }
        else if(rd.equalsIgnoreCase("15") || rd.equalsIgnoreCase("Quinze")){
            pic.setImageResource(R.drawable.signe15);
        }
        else if(rd.equalsIgnoreCase("16") || rd.equalsIgnoreCase("Seize")){
            pic.setImageResource(R.drawable.signe16);
        }
        else if(rd.equalsIgnoreCase("17") || rd.equalsIgnoreCase("Dix-Sept")){
            pic.setImageResource(R.drawable.signe17);
        }
        else if(rd.equalsIgnoreCase("18") || rd.equalsIgnoreCase("Dix-huit")){
            pic.setImageResource(R.drawable.signe18);
        }
        else if(rd.equalsIgnoreCase("19") || rd.equalsIgnoreCase("Dix-neuf")){
            pic.setImageResource(R.drawable.signe19);
        }
        else if(rd.equalsIgnoreCase("20") || rd.equalsIgnoreCase("Vingt")){
            pic.setImageResource(R.drawable.signe20);
        }
        else if(rd.equalsIgnoreCase("2h15")){
            pic.setImageResource(R.drawable.signe2h15);
        }
        else if(rd.equalsIgnoreCase("3h10")){
            pic.setImageResource(R.drawable.signe3h10);
        }
        else if(rd.equalsIgnoreCase("4h")){
            pic.setImageResource(R.drawable.signe4h);
        }
        else if(rd.equalsIgnoreCase("4h45")){
            pic.setImageResource(R.drawable.signe4h45);
        }
        else if(rd.equalsIgnoreCase("9h")){
            pic.setImageResource(R.drawable.signe9h);
        }
        else if(rd.equalsIgnoreCase("20h")){
            pic.setImageResource(R.drawable.signe20h);
        }
        else if(rd.equalsIgnoreCase("papa")){
            pic.setImageResource(R.drawable.signepapa);
        }
        else if(rd.equalsIgnoreCase("maman")){
            pic.setImageResource(R.drawable.signemaman);
        }
        else if(rd.equalsIgnoreCase("fils")){
            pic.setImageResource(R.drawable.signefils);
        }
        else if(rd.equalsIgnoreCase("fille")){
            pic.setImageResource(R.drawable.signefille);
        }
        else if(rd.equalsIgnoreCase("oncle")){
            pic.setImageResource(R.drawable.signeoncle);
        }
        else if(rd.equalsIgnoreCase("tante")){
            pic.setImageResource(R.drawable.signetante);
        }
        else if(rd.equalsIgnoreCase("grandpere")){
            pic.setImageResource(R.drawable.signegrandpere);
        }
        else if(rd.equalsIgnoreCase("grandmere")){
            pic.setImageResource(R.drawable.signegrandmere);
        }
        else if(rd.equalsIgnoreCase("famille")){
            pic.setImageResource(R.drawable.signefamille);
        }
        else if(rd.equalsIgnoreCase("frere")){
            pic.setImageResource(R.drawable.signefrere);
        }
        else if(rd.equalsIgnoreCase("soeur")){
            pic.setImageResource(R.drawable.signesoeur);
        }
        else {
            Toast.makeText(getApplicationContext(),"Ce signe n'est pas dans la base de données",Toast.LENGTH_LONG).show();
        }

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
