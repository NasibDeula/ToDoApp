package com.tbcmad.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText txtUser, txtPassword;
    Button btnLogin ,btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.login_activity_btn_login);
        txtUser = findViewById(R.id.txt_name_user);
        txtPassword =findViewById(R.id.txt_user_password);
        btnCancel= findViewById(R.id.activity_btn_cancel);



        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    SharedPreferences preference = getApplicationContext().getSharedPreferences("todo_pref", 0);
                    SharedPreferences.Editor editor = preference.edit();
                    editor.putBoolean("authentication", true);
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

            }
        });
    }
}