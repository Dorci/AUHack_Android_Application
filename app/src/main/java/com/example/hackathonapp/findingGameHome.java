package com.example.hackathonapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;

public class findingGameHome extends AppCompatActivity {


    private AutoCompleteTextView inputText;

    private ImageView emoji;
    private TextView riddle;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finding_game_home);

        inputText = (AutoCompleteTextView) findViewById(R.id.inputText);
        emoji = (ImageView) findViewById(R.id.emoji);
        riddle = (TextView) findViewById(R.id.riddle);

        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference ref = mDatabase.getReference("server/saving-data/gameData");

        DatabaseReference ourDataRef = ref.child("savedData");


        ourDataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String[] myRandomString = new String[5];
                myRandomString[0] = "first";
                myRandomString[1] = "second";
                myRandomString[2] = "third";
                myRandomString[3] = "fourth";
                myRandomString[4] = "fifth";

                String random = myRandomString[(int) (Math.floor(Math.random() * 5))];
                Log.w("debug:", random);

                GameData myData = dataSnapshot.child(random).getValue(GameData.class);


                emoji.setImageResource(myData.getImgSrc());

                riddle.setText(myData.getRiddle());

                code = myData.getCode();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("hi");
            }
        });

    }

    public void okButtonClicked(View view) {
        if (codeAccepted(inputText.getText().toString())) {
            Intent intent = new Intent(findingGameHome.this, CongratulationActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(findingGameHome.this, "Wrong code.", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean codeAccepted(String code) {
        return code.equals(this.code);
    }
}
