package com.example.kalkulator;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //list Semua Elemen Yang Ada
    EditText txtangka1, txtangka2;
    Button btntambah, btnkurang, btnkali, btnbagi, btnlogout;
    TextView tvhasil, tvuser;
    String emailextras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        txtangka1 = findViewById(R.id.txtangka1);
        txtangka2 = findViewById(R.id.txtangka2);
        btnkali = findViewById(R.id.btnkali);
        btnkurang = findViewById(R.id.btnkurang);
        btnbagi = findViewById(R.id.btnbagi);
        btntambah = findViewById(R.id.btntambah);
        btnlogout = findViewById(R.id.btnlogout);
        tvhasil = findViewById(R.id.tvhasil);
        tvuser = findViewById(R.id.tvuser);

        Bundle bd = getIntent().getExtras();
        if (bd == null) {
            emailextras = "Nama Tidak DI Temukan";
        } else {
            emailextras = bd.getString("email");
        }
        tvuser.setText("Username: "+emailextras);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                sharedPreferences.edit().clear().commit();
                Intent i = new Intent(MainActivity.this, login.class);
                startActivity(i);
                finish();


            }
        });


        btnkurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double hasil = 0;
                double angkasatu = Double.parseDouble(txtangka1.getText().toString());
                double angkadua = Double.parseDouble(txtangka2.getText().toString());

                hasil = angkasatu - angkadua;

                tvhasil.setText("Hasil Dari " + hasil);

            }
        });

        btnkali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double hasil = 0;
                double angkasatu = Double.parseDouble(txtangka1.getText().toString());
                double angkadua = Double.parseDouble(txtangka2.getText().toString());
                hasil = angkasatu * angkadua;
                tvhasil.setText("Hasil Dari  " + hasil);
            }
        });
        btnbagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ini adalah aksi Pembagian
                double hasil = 0;
                double angkasatu = Double.parseDouble(txtangka1.getText().toString());
                double angkadua = Double.parseDouble(txtangka2.getText().toString());

                hasil = angkasatu / angkadua;
                tvhasil.setText("Hasil Dari " + hasil);
            }
        });
        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double hasil = 0;
                double angkasatu = Double.parseDouble(txtangka1.getText().toString());
                double angkadua = Double.parseDouble(txtangka2.getText().toString());
                hasil = angkasatu + angkadua;
                tvhasil.setText("Hasil Dari  " + hasil);
            }
        });

    }
    @Override
    public void onBackPressed() {

    AlertDialog.Builder builder = new AlertDialog.Builder(this);

    builder.setMessage("Are You want To Exit ?")
            .setCancelable(false)
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {

                    MainActivity.super.onBackPressed();
                }
            })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i ) {
                    dialog.cancel();
                }
            });
    AlertDialog alertDialog = builder.create();
    alertDialog.show();

}
    }

