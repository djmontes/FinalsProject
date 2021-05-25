package com.example.finalsproject;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainMenu extends AppCompatActivity
{
    Button btnEasy, btnMedium, btnHard;
    String difficulty;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnEasy = findViewById(R.id.EASY);
        btnEasy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                difficulty = "EASY";
                playGame(difficulty);
            }
        });

        btnMedium = findViewById(R.id.MEDIUM);
        btnMedium.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                difficulty = "MEDIUM";
                playGame(difficulty);
            }
        });

        btnHard = findViewById(R.id.HARD);
        btnHard.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                difficulty = "HARD";
                playGame(difficulty);
            }
        });
    }

    public void playGame(String emh)
    {
        Intent intent = new Intent(this, PlayCodename.class);
        intent.putExtra("difficulty", difficulty);
        startActivity(intent);
    }
}