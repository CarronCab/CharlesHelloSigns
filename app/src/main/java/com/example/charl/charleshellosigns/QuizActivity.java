package com.example.charl.charleshellosigns;

import android.app.PendingIntent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

public class QuizActivity extends AppCompatActivity {
    List<Question> quesList;
    int score=0;
    int qid=0;
    Question currentQ;
    TextView txtQuestion;
    String tda, tdb, tdc;
    Intent intent;
    ImageView pic1;
    ImageView pic2;
    ImageView pic3;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        //Declaration de la bar d'outils
        Toolbar toolbar = findViewById(R.id.main_menu_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml("<font color='#ffffff'>HelloSigns </font>"));
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);


        pic1 = (ImageView)findViewById(R.id.picture1);
        pic3 = (ImageView)findViewById(R.id.picture2);
        pic2 = (ImageView)findViewById(R.id.picture3);
        intent = getIntent();
        int quizNbr = intent.getIntExtra("quizNbr", 0);
        DbHelper db=new DbHelper(this);
        if(quizNbr == 1){
            quesList=db.getAllQuestions();
        }
        if(quizNbr == 2){
            quesList=db.getAllQuestions2();
        }
        if(quizNbr == 3){
            quesList=db.getAllQuestions3();
        }
        if(quizNbr == 4){
            quesList=db.getAllQuestions4();
        }

        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        setQuestionView();
        setPictures(tda,pic1);
        setPictures(tdb,pic2);
        setPictures(tdc,pic3);

        pic1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                if(currentQ.getANSWER().equals(tda)) {
                    pic1.setBackgroundResource(R.drawable.backgroundborder);
                }
                else if(currentQ.getANSWER().equals(tdb)) {
                    pic2.setBackgroundResource(R.drawable.backgroundborder);
                    pic1.setBackgroundResource(R.drawable.backgroundborderwrong);
                }
                else if(currentQ.getANSWER().equals(tdc)) {
                    pic3.setBackgroundResource(R.drawable.backgroundborder);
                    pic1.setBackgroundResource(R.drawable.backgroundborderwrong);
                }

                pic1.setClickable(false);
                pic2.setClickable(false);
                pic3.setClickable(false);


                new CountDownTimer(5000, 1) {
                    public void onTick(final long millisUntilFinished) {
                        txtQuestion.setText("Prochaine question dans " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        pic1.setBackgroundResource(0);
                        pic2.setBackgroundResource(0);
                        pic3.setBackgroundResource(0);
                        pic1.setClickable(true);
                        pic2.setClickable(true);
                        pic3.setClickable(true);
                        if(currentQ.getANSWER().equals(tda))
                        {
                            score++;
                            Log.d("score", "Your score"+score);
                        }
                        if(qid<5){
                            currentQ=quesList.get(qid);
                            setQuestionView();
                            setPictures(tda,pic1);
                            setPictures(tdb,pic2);
                            setPictures(tdc,pic3);

                        }else{
                            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                            Bundle b = new Bundle();
                            b.putInt("score", score); //Your score
                            intent.putExtras(b); //Put your score to your next Intent
                            startActivity(intent);
                            finish();
                        }
                    }
                }.start();

            }
        });


        pic2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                if(currentQ.getANSWER().equals(tda)) {
                    pic1.setBackgroundResource(R.drawable.backgroundborder);
                    pic2.setBackgroundResource(R.drawable.backgroundborderwrong);
                }
                else if(currentQ.getANSWER().equals(tdb)) {
                    pic2.setBackgroundResource(R.drawable.backgroundborder);
                }
                else if(currentQ.getANSWER().equals(tdc)) {
                    pic3.setBackgroundResource(R.drawable.backgroundborder);
                    pic2.setBackgroundResource(R.drawable.backgroundborderwrong);
                }

                pic1.setClickable(false);
                pic2.setClickable(false);
                pic3.setClickable(false);


                new CountDownTimer(5000, 1) {
                    public void onTick(final long millisUntilFinished) {
                        txtQuestion.setText("Prochaine question dans " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        pic1.setBackgroundResource(0);
                        pic2.setBackgroundResource(0);
                        pic3.setBackgroundResource(0);
                        pic1.setClickable(true);
                        pic2.setClickable(true);
                        pic3.setClickable(true);
                        if(currentQ.getANSWER().equals(tdb))
                        {
                            score++;
                            Log.d("score", "Your score"+score);
                        }
                        if(qid<5){
                            currentQ=quesList.get(qid);
                            setQuestionView();
                            setPictures(tda,pic1);
                            setPictures(tdb,pic2);
                            setPictures(tdc,pic3);

                        }else{
                            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                            Bundle b = new Bundle();
                            b.putInt("score", score); //Your score
                            intent.putExtras(b); //Put your score to your next Intent
                            startActivity(intent);
                            finish();
                        }
                    }
                }.start();

            }
        });

        pic3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                if(currentQ.getANSWER().equals(tda)) {
                    pic1.setBackgroundResource(R.drawable.backgroundborder);
                    pic3.setBackgroundResource(R.drawable.backgroundborderwrong);
                }
                else if(currentQ.getANSWER().equals(tdb)) {
                    pic2.setBackgroundResource(R.drawable.backgroundborder);
                    pic3.setBackgroundResource(R.drawable.backgroundborderwrong);
                }
                else if(currentQ.getANSWER().equals(tdc)) {
                    pic3.setBackgroundResource(R.drawable.backgroundborder);
                }

                pic1.setClickable(false);
                pic2.setClickable(false);
                pic3.setClickable(false);


                new CountDownTimer(5000, 1) {
                    public void onTick(final long millisUntilFinished) {
                        txtQuestion.setText("Prochaine question dans " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        pic1.setBackgroundResource(0);
                        pic2.setBackgroundResource(0);
                        pic3.setBackgroundResource(0);
                        pic1.setClickable(true);
                        pic2.setClickable(true);
                        pic3.setClickable(true);
                        if(currentQ.getANSWER().equals(tdc))
                        {
                            score++;
                            Log.d("score", "Your score"+score);
                        }
                        if(qid<5){
                            currentQ=quesList.get(qid);
                            setQuestionView();
                            setPictures(tda,pic1);
                            setPictures(tdb,pic2);
                            setPictures(tdc,pic3);

                        }else{
                            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                            Bundle b = new Bundle();
                            b.putInt("score", score); //Your score
                            intent.putExtras(b); //Put your score to your next Intent
                            startActivity(intent);
                            finish();
                        }
                    }
                }.start();

            }
        });
    }
    /* @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         // Inflate the menu; this adds items to the action bar if it is present.
         getMenuInflater().inflate(R.menu.activity_quiz, menu);
         return true;
     }
     */
    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        tda = (currentQ.getOPTA());
        tdb = (currentQ.getOPTB());
        tdc = (currentQ.getOPTC());
        qid++;
    }

    private void setPictures(String rd, ImageView pic){
        if(rd.equals("Signe 1")){
            pic.setImageResource(R.drawable.signe1);
        }
        else if(rd.equals("Signe 2")){
            pic.setImageResource(R.drawable.signe2);
        }
        else if(rd.equals("Signe 3")){
            pic.setImageResource(R.drawable.signe3);
        }
        else if(rd.equals("Signe 4")){
            pic.setImageResource(R.drawable.signe4);
        }
        else if(rd.equals("Signe 5")){
            pic.setImageResource(R.drawable.signe5);
        }
        else if(rd.equals("Signe 6")){
            pic.setImageResource(R.drawable.signe6);
        }
        else if(rd.equals("Signe 7")){
            pic.setImageResource(R.drawable.signe7);
        }
        else if(rd.equals("Signe 8")){
            pic.setImageResource(R.drawable.signe8);
        }
        else if(rd.equals("Signe 9")){
            pic.setImageResource(R.drawable.signe9);
        }
        else if(rd.equals("Signe 10")){
            pic.setImageResource(R.drawable.signe10);
        }
        else if(rd.equals("Signe 11")){
            pic.setImageResource(R.drawable.signe11);
        }
        else if(rd.equals("Signe 12")){
            pic.setImageResource(R.drawable.signe12);
        }
        else if(rd.equals("Signe 13")){
            pic.setImageResource(R.drawable.signe13);
        }
        else if(rd.equals("Signe 14")){
            pic.setImageResource(R.drawable.signe14);
        }
        else if(rd.equals("Signe 15")){
            pic.setImageResource(R.drawable.signe15);
        }
        else if(rd.equals("Signe 16")){
            pic.setImageResource(R.drawable.signe16);
        }
        else if(rd.equals("Signe 17")){
            pic.setImageResource(R.drawable.signe17);
        }
        else if(rd.equals("Signe 18")){
            pic.setImageResource(R.drawable.signe18);
        }
        else if(rd.equals("Signe 19")){
            pic.setImageResource(R.drawable.signe19);
        }
        else if(rd.equals("Signe 20")){
            pic.setImageResource(R.drawable.signe20);
        }
        else if(rd.equals("Signe 2h15")){
            pic.setImageResource(R.drawable.signe2h15);
        }
        else if(rd.equals("Signe 3h10")){
            pic.setImageResource(R.drawable.signe3h10);
        }
        else if(rd.equals("Signe 4h")){
            pic.setImageResource(R.drawable.signe4h);
        }
        else if(rd.equals("Signe 4h45")){
            pic.setImageResource(R.drawable.signe4h45);
        }
        else if(rd.equals("Signe 9h")){
            pic.setImageResource(R.drawable.signe9h);
        }
        else if(rd.equals("Signe 20h")){
            pic.setImageResource(R.drawable.signe20h);
        }
        else if(rd.equals("Signe papa")){
            pic.setImageResource(R.drawable.signepapa);
        }
        else if(rd.equals("Signe maman")){
            pic.setImageResource(R.drawable.signemaman);
        }
        else if(rd.equals("Signe fils")){
            pic.setImageResource(R.drawable.signefils);
        }
        else if(rd.equals("Signe fille")){
            pic.setImageResource(R.drawable.signefille);
        }
        else if(rd.equals("Signe oncle")){
            pic.setImageResource(R.drawable.signeoncle);
        }
        else if(rd.equals("Signe tante")){
            pic.setImageResource(R.drawable.signetante);
        }
        else if(rd.equals("Signe grandpere")){
            pic.setImageResource(R.drawable.signegrandpere);
        }
        else if(rd.equals("Signe grandmere")){
            pic.setImageResource(R.drawable.signegrandmere);
        }
        else if(rd.equals("Signe famille")){
            pic.setImageResource(R.drawable.signefamille);
        }
        else if(rd.equals("Signe frere")){
            pic.setImageResource(R.drawable.signefrere);
        }
        else if(rd.equals("Signe soeur")){
            pic.setImageResource(R.drawable.signesoeur);
        }

    }
}

