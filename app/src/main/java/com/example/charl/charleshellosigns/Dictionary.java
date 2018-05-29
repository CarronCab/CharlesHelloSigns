package com.example.charl.charleshellosigns;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Dictionary extends AppCompatActivity {

    ImageView picture;
    EditText textEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        picture = (ImageView)findViewById(R.id.pictureDict);
        picture.setImageResource(0);
        textEdit = (EditText)findViewById(R.id.inputDict);

    }

    public void research(View view){
        setPictures(textEdit.getText().toString(), picture);
    }

    private void setPictures(String rd, ImageView pic){
        if(rd.equalsIgnoreCase("1")){
            pic.setImageResource(R.drawable.signe1);
        }
        else if(rd.equalsIgnoreCase("2")){
            pic.setImageResource(R.drawable.signe2);
        }
        else if(rd.equalsIgnoreCase("3")){
            pic.setImageResource(R.drawable.signe3);
        }
        else if(rd.equalsIgnoreCase("4")){
            pic.setImageResource(R.drawable.signe4);
        }
        else if(rd.equalsIgnoreCase("5")){
            pic.setImageResource(R.drawable.signe5);
        }
        else if(rd.equalsIgnoreCase("6")){
            pic.setImageResource(R.drawable.signe6);
        }
        else if(rd.equalsIgnoreCase("7")){
            pic.setImageResource(R.drawable.signe7);
        }
        else if(rd.equalsIgnoreCase("8")){
            pic.setImageResource(R.drawable.signe8);
        }
        else if(rd.equalsIgnoreCase("9")){
            pic.setImageResource(R.drawable.signe9);
        }
        else if(rd.equalsIgnoreCase("10")){
            pic.setImageResource(R.drawable.signe10);
        }
        else if(rd.equalsIgnoreCase("11")){
            pic.setImageResource(R.drawable.signe11);
        }
        else if(rd.equalsIgnoreCase("12")){
            pic.setImageResource(R.drawable.signe12);
        }
        else if(rd.equalsIgnoreCase("13")){
            pic.setImageResource(R.drawable.signe13);
        }
        else if(rd.equalsIgnoreCase("14")){
            pic.setImageResource(R.drawable.signe14);
        }
        else if(rd.equalsIgnoreCase("15")){
            pic.setImageResource(R.drawable.signe15);
        }
        else if(rd.equalsIgnoreCase("16")){
            pic.setImageResource(R.drawable.signe16);
        }
        else if(rd.equalsIgnoreCase("17")){
            pic.setImageResource(R.drawable.signe17);
        }
        else if(rd.equalsIgnoreCase("18")){
            pic.setImageResource(R.drawable.signe18);
        }
        else if(rd.equalsIgnoreCase("19")){
            pic.setImageResource(R.drawable.signe19);
        }
        else if(rd.equalsIgnoreCase("20")){
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

    }
}
