package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    Button playBtn;
    Button tutorialBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        playBtn = findViewById(R.id.playBtn);
        tutorialBtn = findViewById(R.id.torurialBtn);


        playBtn.setOnClickListener(view -> {
            Intent playIntent = new Intent(this, MainActivity.class);
            startActivity(playIntent);
        });
        tutorialBtn.setOnClickListener(view -> {
            Intent playIntent = new Intent(this, IntroActivity.class);
            playIntent.putExtra("isFromMenu",true);
            startActivity(playIntent);
        });



    }
}