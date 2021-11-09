package com.example.makharij_al_huruf;

import static android.graphics.Color.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    int c = 0;
    int t = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        double totalQuestion = intent.getIntExtra("total", 0);
        double correctAnswer = intent.getIntExtra("correct", 0);

        double wrongAnswer = totalQuestion-correctAnswer;
        double num = (correctAnswer/totalQuestion)*100;

        c=(int)correctAnswer;
        t=(int)totalQuestion;

        TextView txt6 = findViewById(R.id.textView6);
        TextView txt7 = findViewById(R.id.textView7);
        TextView txt8 = findViewById(R.id.textView8);

        txt6.setTextColor(Color.parseColor("#1ac447"));
        txt7.setTextColor(Color.parseColor("#c4201a"));

        txt6.setText("Correct Answer: "+(int)correctAnswer);
        txt7.setText("Wrong Answer: "+(int)wrongAnswer);
        txt8.setText(String.valueOf((int)correctAnswer)+"/"+String.valueOf((int)totalQuestion));

        ProgressBar pb1 = findViewById(R.id.progressBar);
        pb1.setProgress((int)num);

    }

    public void mainMenuBtnOnClick(View view)
    {
        Intent intents = new Intent(this, MainActivity.class);
        startActivity(intents);
        finish();
        return;
    }
    public void shareBtnOnClick(View view)
    {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Your Score: "+c+"/"+t);
        sendIntent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(sendIntent,null);
        startActivity(shareIntent);
    }


}