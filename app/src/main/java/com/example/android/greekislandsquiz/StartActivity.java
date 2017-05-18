package com.example.android.greekislandsquiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button StartQuiz = (Button) findViewById(R.id.startButton);

        // Set a click listener on that View
        StartQuiz.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the start quiz button is clicked on.
            @Override
            public void onClick(View view) {
                Intent startQuizIntent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(startQuizIntent);
            }
        });

    }
}
