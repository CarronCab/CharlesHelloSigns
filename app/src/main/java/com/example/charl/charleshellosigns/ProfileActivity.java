package com.example.charl.charleshellosigns;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    TextView name,prenom,job,pays,description;
    String st1,st2,st3,st4,st5;
    ImageView imageView;
    Button button_edit, button_ami ,btn_choose;
    List<DataItem> lstData;

    private int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        button_edit = findViewById(R.id.handle);
        button_ami = findViewById(R.id.btn_ami);
        name = findViewById(R.id.name);
        prenom = findViewById(R.id.prenom);
        job = findViewById(R.id.job);
        pays = findViewById(R.id.pays);
        description=findViewById(R.id.content);
        imageView = findViewById(R.id.avatar);
        btn_choose = findViewById(R.id.btn_choose);
        ListView listview = findViewById(R.id.listview);


        st1 = getIntent().getStringExtra("NAME");
        st2 = getIntent().getStringExtra("JOB");
        st3 = getIntent().getStringExtra("PRENOM");
        st4 = getIntent().getStringExtra("PAYS");
        st5 = getIntent().getStringExtra("DESCRIPTION");

        if(st1 != null) {
            name.setText(st1);
        }

        if (st2 != null) {
            job.setText(st2);
        }

        if(st3 != null) {
            prenom.setText(st3);
        }

        if (st4 != null) {
            pays.setText(st4);
        }

        if(st5 != null) {
            description.setText(st5);
        }




        button_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent handle = new Intent(getApplicationContext(), HandleActivity.class);
                startActivity(handle);
            }
        });

        button_ami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Demande d'amis envoyée", Toast.LENGTH_LONG).show();
            }
        });

        btn_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("/image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),REQUEST_CODE);
            }
        });

        lstData = new ArrayList<>();
        lstData.add(new DataItem(R.drawable.suc1));
        lstData.add(new DataItem(R.drawable.suc2));
        lstData.add(new DataItem(R.drawable.suc3));
        lstData.add(new DataItem(R.drawable.suc4));
        lstData.add(new DataItem(R.drawable.suc5));

        Adapter adapter = new Adapter(this, R.layout.layout_listitem,lstData);
        listview.setAdapter(adapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == REQUEST_CODE &&  resultCode ==  RESULT_OK && data != null && data.getData() !=null){

            Uri uri = data.getData();

             try {
                 Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                 imageView.setImageBitmap(bitmap);


             }catch (IOException e){
                 e.printStackTrace();
             }
        }

    }

}