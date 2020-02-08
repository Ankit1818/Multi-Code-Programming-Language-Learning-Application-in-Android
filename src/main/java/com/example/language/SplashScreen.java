package com.example.language;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.openclass.Background;

public class SplashScreen extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Background bb=new Background(getApplicationContext());
                if (bb.getName()!="")
                {
                    Intent intent1=new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent1);

                }
                else
                {
                    Intent intent = new Intent(SplashScreen.this,Loginscreen.class);
                    startActivity(intent);
                }

            }
        },3000);
    }
}
