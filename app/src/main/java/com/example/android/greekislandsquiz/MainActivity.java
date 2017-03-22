package com.example.android.greekislandsquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.server.converter.StringToIntConverter;

import static android.R.attr.button;
import static android.R.attr.name;
import static android.R.id.message;
import static com.example.android.greekislandsquiz.R.id.Rb2;
import static com.example.android.greekislandsquiz.R.id.visitCrete;

public class MainActivity extends AppCompatActivity {

    RadioButton AnswerQuestion1, AnswerQuestion2, AnswerQuestion3, AnswerQuestion4, AnswerQuestion5;
    CheckBox AnswerQuestion6a, AnswerQuestion6b, AnswerQuestion6c, AnswerQuestion6d, AnswerQuestion6e, AnswerQuestion6f, AnswerQuestion6g, AnswerQuestion6h;
    EditText yourName, AnswerQuestion7;
    /**
     * TextView
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        AnswerQuestion1 = (RadioButton) findViewById(Rb2);
        AnswerQuestion2 = (RadioButton) findViewById(R.id.Rb7);
        AnswerQuestion3 = (RadioButton) findViewById(R.id.Rb9);
        AnswerQuestion4 = (RadioButton) findViewById(R.id.Rb14);
        AnswerQuestion5 = (RadioButton) findViewById(R.id.Rb20);
        AnswerQuestion6a = (CheckBox) findViewById(R.id.visitCorfu);
        AnswerQuestion6b = (CheckBox) findViewById(R.id.visitZakinthos);
        AnswerQuestion6c = (CheckBox) findViewById(R.id.visitCrete);
        AnswerQuestion6d = (CheckBox) findViewById(R.id.visitMilos);
        AnswerQuestion6e = (CheckBox) findViewById(R.id.visitMykonos);
        AnswerQuestion6f = (CheckBox) findViewById(R.id.visitSantorini);
        AnswerQuestion6g = (CheckBox) findViewById(R.id.visitSiros);
        AnswerQuestion6h = (CheckBox) findViewById(R.id.visitSkiathos);
        yourName = (EditText) findViewById(R.id.yourName);
        AnswerQuestion7 = (EditText) findViewById(R.id.yourAnswer);


    }


    /**
     * This method fetches the right answer for every question returning true for right and false for wrong .
     *
     * @param questionNumber is the number of question (1-7)
     */
    public boolean getRightAnswer(int questionNumber) {

    /* check if right radiobutton is checked for questions 1-5 */
        boolean Rb2Status = AnswerQuestion1.isChecked();
        boolean Rb7Status = AnswerQuestion2.isChecked();
        boolean Rb9Status = AnswerQuestion3.isChecked();
        boolean Rb14Status = AnswerQuestion4.isChecked();
        boolean Rb20Status = AnswerQuestion5.isChecked();
        /* check answer for question 6, only two must be checked */
        boolean visitCorfuStatus = AnswerQuestion6a.isChecked();
        boolean visitZakinthosStatus = AnswerQuestion6b.isChecked();
        boolean visitCreteStatus = AnswerQuestion6c.isChecked();
        boolean visitMilosStatus = AnswerQuestion6d.isChecked();
        boolean visitMykonosStatus = AnswerQuestion6e.isChecked();
        boolean visitSantoriniStatus = AnswerQuestion6f.isChecked();
        boolean visitSirosStatus = AnswerQuestion6g.isChecked();
        boolean visitSkiathosStatus = AnswerQuestion6h.isChecked();
         /* gets answer for question 7 */
        String Answer7 = AnswerQuestion7.getText().toString();

/*      /*check answers */
        boolean rightAnswer = false;
        if (questionNumber == 1 && Rb2Status) {
            rightAnswer = true;
        } else if (questionNumber == 2 && Rb7Status) {
            rightAnswer = true;

        } else if (questionNumber == 3 && Rb9Status) {
            rightAnswer = true;

        } else if (questionNumber == 4 && Rb14Status) {
            rightAnswer = true;

        } else if (questionNumber == 5 && Rb20Status) {
            rightAnswer = true;

        } else if (questionNumber == 6 && visitCorfuStatus && visitZakinthosStatus && !visitCreteStatus && !visitMilosStatus && !visitMykonosStatus && !visitSantoriniStatus && !visitSkiathosStatus && !visitSirosStatus) {
            rightAnswer = true;

        } else if (questionNumber == 7 && (Answer7.equals("Crete") || Answer7.equals("Κρήτη"))) {
            rightAnswer = true;
        }
        return rightAnswer;
    }

    /**
     * This method calculates the points for every question. 1 point for right, 0 for wrong
     *
     * @param questionNumber is the number of question (1-6)
     * @param rightAnswer    true if the answer is right , false if it is wrong
     */
    public int QuestionScore(int questionNumber, boolean rightAnswer) {

        int score = 0;
        if (rightAnswer) {
            score = 1;
        }
        return score;
    }

    /**
     * This method calculates the final score and and is triggered when submit button is pressed
     */
    public void submitAnswers(View view) {


        String name = yourName.getText().toString();

        int final_score = 0;
        String toPrint = "";

        for (int i = 1; i <= 7; i++) {
            String answer = getResources().getString(R.string.Wrong);
            final_score += QuestionScore(i, getRightAnswer(i));
            if (getRightAnswer(i)) answer = getResources().getString(R.string.Right);
            toPrint = toPrint + getResources().getString(R.string.Question) + " " + i + " = " + answer + "\n";
        }
        /* toast message */
        if (final_score == 7) {
            Toast.makeText(this, name + " " + getResources().getString(R.string.ToastMsg1) + " " + final_score + "/7", Toast.LENGTH_SHORT).show();
        } else if (final_score <= 3) {
            Toast.makeText(this, name + " " + getResources().getString(R.string.ToastMsg2) + " " + final_score + "/7", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, name + " " + getResources().getString(R.string.ToastMsg3) + " " + final_score + "/7", Toast.LENGTH_SHORT).show();
        }

        /**
         * sends the report with the right and wrong answers and the score to results activity
         */
        Intent buttonIntent = new Intent(MainActivity.this, ResultsActivity.class);
        buttonIntent.putExtra("result", toPrint);
        buttonIntent.putExtra("f_Score", final_score);
        startActivity(buttonIntent);


    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}