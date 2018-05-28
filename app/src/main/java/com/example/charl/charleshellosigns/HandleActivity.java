package com.example.charl.charleshellosigns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HandleActivity extends AppCompatActivity {

    TextView editTextName,editTextJob,editTextPrenom,editTextPays,editContent;
    Button btnSave , btnAccount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle);

        addKeyListener();

    }

    public void addKeyListener(){
        editTextName = findViewById(R.id.editTextName);
        editTextJob = findViewById(R.id.editTextJob);
        editTextPrenom = findViewById(R.id.editTextPrenom);
        editTextPays = findViewById(R.id.editTextPays);
        editContent = findViewById(R.id.resume);

        btnSave = findViewById(R.id.btn_save);
        btnAccount = findViewById(R.id.btn_account);


        editTextName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextName.setText("");
            }
        });

        editTextPrenom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextPrenom.setText("");
            }
        });

        editTextPays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextPays.setText("");
            }
        });

        editContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editContent.setText("");
            }
        });

        editTextJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextJob.setText("");
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(HandleActivity.this, ProfileActivity.class);
                String nomsaisi = editTextName.getText().toString();
                String jobsaisi = editTextJob.getText().toString();
                String prenomsaisi = editTextPrenom.getText().toString();
                String payssaisi = editTextPays.getText().toString();
                String contentdes = editContent.getText().toString();

                i.putExtra("NAME", nomsaisi);
                i.putExtra("JOB", jobsaisi);
                i.putExtra("PRENOM", prenomsaisi);
                i.putExtra("PAYS", payssaisi);
                i.putExtra("DESCRIPTION", contentdes);

                startActivity(i);
                finish();
            }
        });

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent handle = new Intent(HandleActivity.this, MainActivity.class);
                startActivity(handle);
            }
        });

    }
}
