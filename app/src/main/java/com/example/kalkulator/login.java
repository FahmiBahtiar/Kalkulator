package com.example.kalkulator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    //list element Yang Ada
    EditText txt1,txt2;
    TextView tv1, tv2, tv3, tv4;
    Button btn1;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txt1 = findViewById(R.id.txtemail);
        txt2 = findViewById(R.id.txtpassword);
        tv1 = findViewById(R.id.tvnamapengguna);
        tv2 = findViewById(R.id.tvkatasandi);
        tv3 = findViewById(R.id.tvlupasandi);
        btn1 = findViewById(R.id.btnmasuk);
        pref = getSharedPreferences("login", MODE_PRIVATE);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txt1.getText().toString().equals("hambaallah@gmail.com") && txt2.getText().toString().equals("hambaallah")) {
                    Toast.makeText(login.this, "Login Success", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(login.this, MainActivity.class);
                    intent.putExtra("email", txt1.getText().toString());
                    startActivity(intent);
                    editor = pref.edit();
                    editor.putString("userid", txt1.getText().toString());
                    editor.apply();
                    finish();
                } else {
                    txt2.setError("Invalid Password");
                }

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

                        login.super.onBackPressed();
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
