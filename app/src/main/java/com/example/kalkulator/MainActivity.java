package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //list Semua Elemen Yang Ada
    EditText txtangka1, txtangka2;
    Button btntambah, btnkurang, btnkali, btnbagi;
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
        tvhasil = findViewById(R.id.tvhasil);
        tvuser = findViewById(R.id.tvuser);

        Bundle bd = getIntent().getExtras();
        if(bd == null){
            emailextras = "null";
        }else{
            emailextras = bd.getString("email");
        }tvuser.setText(emailextras);

        btnkurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double hasil=0;
                double angkasatu = Double.parseDouble(txtangka1.getText().toString());
                double angkadua = Double.parseDouble(txtangka2.getText().toString());

                hasil = angkasatu-angkadua;

                tvhasil.setText("Hasil Dari "+hasil);

            }
        });

        btnkali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double hasil=0;
                double angkasatu = Double.parseDouble(txtangka1.getText().toString());
                double angkadua = Double.parseDouble(txtangka2.getText().toString());
                hasil = angkasatu*angkadua;
                tvhasil.setText("Hasil Dari  "+hasil);
            }
        });
        btnbagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ini adalah aksi Pembagian
                double hasil=0;
                double angkasatu = Double.parseDouble(txtangka1.getText().toString());
                double angkadua = Double.parseDouble(txtangka2.getText().toString());

                hasil = angkasatu/angkadua;
                tvhasil.setText("Hasil Dari "+hasil);
            }
        });
        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double hasil=0;
                double angkasatu = Double.parseDouble(txtangka1.getText().toString());
                double angkadua = Double.parseDouble(txtangka2.getText().toString());
                hasil = angkasatu+angkadua;
                tvhasil.setText("Hasil Dari  "+hasil);
            }
        });

    }

}