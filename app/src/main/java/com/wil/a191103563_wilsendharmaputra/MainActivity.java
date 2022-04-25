package com.wil.a191103563_wilsendharmaputra;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username,password;
    Button buttonLogin,buttonRegist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.editUsername);
        password = (EditText) findViewById(R.id.editPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonRegist = (Button) findViewById(R.id.buttonRegist);

        buttonLogin.setOnClickListener(this);
        buttonRegist.setOnClickListener(this);
    }
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.buttonLogin:
                    String usernameKey = username.getText().toString();
                    String passwordeKey = password.getText().toString();

                    if(usernameKey.equals("root") && passwordeKey.equals("password")){
                        //jika login berhasil
                        Toast.makeText(getApplicationContext(), "login Suksess",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                        MainActivity.this.startActivity(intent);
                        finish();
                    }
                    else{
                        //jika login gagal
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Username atau Password salah!")
                                .setNegativeButton("Retry",null).create().show();
                    }
                    break;
                case R.id.buttonRegist:
                    Intent intent = new Intent(MainActivity.this, RegistActivity.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                    break;
            }

        }
    }