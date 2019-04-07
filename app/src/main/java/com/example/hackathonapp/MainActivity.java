package com.example.hackathonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase mDatabase;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance();
        ref = mDatabase.getReference("server/saving-data/gameData");

        DatabaseReference ourDataRef = ref.child("savedData");

        Map<String, GameData> gameData = new HashMap<>();
        gameData.put("first", new GameData(1, "DO NOT CRY AND JUST SMILE \nMAKES LIFE BETTER JUST BY PASSING BY, \nPAINTS COLOR EVERYWHERE \nVOMITS RAINBOWS THAT YOU WOULD NOT BEAR", R.drawable.roxana, "1"));
        gameData.put("second", new GameData(2, "BOOKS AND CODE IS ALL HE WANTS \nWELL, THEY ARE HIS SPECIAL ARTS \nNEVERMIND IS ALL HE SAYS \n THAT IS HIS NORMAL STATE OF AFFAIRS.", R.drawable.david, "2"));
        gameData.put("third", new GameData(3, "RUNS, RUNS, RUNS WHILE BEING LATE, \nALWAYS CHAMPION AT MAFIA GAME. \nREDHOTCHILLIPEPPERS IS ALL SHE LISTENS \nGOES BY IT IS MY LIFE DEFINITIONS.", R.drawable.raluca, "3"));
        gameData.put("fourth", new GameData(4, "LOL, COUNTERSTRIKE AND ALL THAT JAZZ \nPLAYS THE KEYBOARD IN THE BIG CLASS. \nDO NOT PISS HIM OF, IT IS A WARNING! \nYOU DON'T KNOW WHAT BOMBS HE MIGHT BE STORMING.", R.drawable.marwan, "4"));
        gameData.put("fifth", new GameData(5, "GIVE ME COCO, COCO, COCO \n  SMILE AND LAUGH WHILE BEING LOCO \n LOOKS AT YOU WITH A BRIGHT SMILE \n  BEING CRAZY IS A STYLE.", R.drawable.dorcia, "5"));

        ourDataRef.setValue(gameData);
    }

    public void openActivityFindingGame(View view){
        Intent intent = new Intent(MainActivity.this, findingGameHome.class);
        startActivity(intent);
    }
}
