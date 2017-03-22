package com.example.android.greekislandsquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

    /* Fetch data from main activity */
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("result");
        int score = bundle.getInt("f_Score");

    /* create quiz report withh right and wrong answers */
        TextView SummaryTextView = (TextView) findViewById(R.id.QuizSummary2);
        SummaryTextView.setText(message);

    /* create rating bar with stars */
        RatingBar Star = (RatingBar) findViewById(R.id.rating_bar);
        Star.setRating(score);
    }
}
