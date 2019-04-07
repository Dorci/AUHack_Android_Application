package com.example.hackathonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CongratulationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulation);
    }

    public void goToMain(View view){
        Intent intent = new Intent(CongratulationActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
