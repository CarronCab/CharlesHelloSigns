package com.example.charl.charleshellosigns.Tutorials;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
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

import com.example.charl.charleshellosigns.Dictionary;
import com.example.charl.charleshellosigns.MainActivity;
import com.example.charl.charleshellosigns.MainMenu;
import com.example.charl.charleshellosigns.ProfileActivity;
import com.example.charl.charleshellosigns.QuizSelection;
import com.example.charl.charleshellosigns.R;

import java.util.Objects;

public class TutosActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutos);

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
                                Intent home = new Intent(TutosActivity.this, MainMenu.class);
                                startActivity(home);
                                return true;

                            case R.id.quizzes:
                                Intent intent = new Intent(TutosActivity.this, QuizSelection.class);
                                startActivity(intent);
                                return true;

                            case R.id.deconnection:
                                Intent login = new Intent (TutosActivity.this, MainActivity.class);
                                startActivity(login);
                                return true;

                            case R.id.dictionary:
                                Intent dict = new Intent (TutosActivity.this, Dictionary.class);
                                startActivity(dict);
                                return true;

                            case R.id.parametre:
                                Intent param = new Intent(TutosActivity.this, ProfileActivity.class);
                                startActivity(param);
                                return true;


                        }

                        return true;
                    }
                });
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
