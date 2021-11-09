package com.example.makharij_al_huruf;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class McqsActivity extends AppCompatActivity {

    int pgFlag = 0;
    int totalQuestion = 4;
    int currentQuestion = 1;
    int correctQuestion = 0;

    String[] mcqs={"Ghunna", "Lahatiyah", "Nit-eeyah", "Shajariyah-Haafiyah"};
    String[] correct={"A","B","C","D"};

    String[] question={
            "  ن a is ______",
            "  ق a is______",
            "  د a is______",
            "  ج a is ______"
    };

    String[] explanation={
            "Rounded tip of the tongue touching the base of the frontal 6 teeth",
            "Base of Tongue which is near Uvula touching the mouth roof",
            "NTip of the tongue touching the base of the front 2 teeth",
            "Tongue touching the center of the mouth roof"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcqsactivity);

        Intent intent = getIntent();
        int pageFlag = intent.getIntExtra("page", 0);
        pgFlag = pageFlag;
        if (pgFlag == 1)
        {
            initializeMcqs();
        }
        else
        {
            initializeMcqs();
            Button b8 = findViewById(R.id.button8);
            b8.setVisibility(View.GONE);
        }

    }

    public void initializeMcqs()
    {
        TextView txt1 = findViewById(R.id.textView);
        TextView txt5 = findViewById(R.id.textView5);

        txt1.setText(question[0]);
        txt5.setText(String.valueOf(currentQuestion)+"/"+String.valueOf(totalQuestion));

        RadioButton r2 = findViewById(R.id.radioButton2);
        RadioButton r3 = findViewById(R.id.radioButton3);
        RadioButton r4 = findViewById(R.id.radioButton4);
        RadioButton r7 = findViewById(R.id.radioButton7);

        r2.setText("A) "+mcqs[0]);
        r3.setText("B) "+mcqs[1]);
        r4.setText("C) "+mcqs[2]);
        r7.setText("D) "+mcqs[3]);
    }

    public void nextBtnOnClick(View view)
    {
        int n = currentQuestion;

        if (currentQuestion==totalQuestion && pgFlag==1)
        {
            Intent intents = new Intent(this, MainActivity.class);
            startActivity(intents);
            finish();
            return;
        }
        currentQuestion++;

        RadioButton r2 = findViewById(R.id.radioButton2);
        RadioButton r3 = findViewById(R.id.radioButton3);
        RadioButton r4 = findViewById(R.id.radioButton4);
        RadioButton r7 = findViewById(R.id.radioButton7);


        if (r2.isChecked()==true && n==1)
        {
            correctQuestion++;
        }
        if (r3.isChecked()==true && n==2)
        {
            correctQuestion++;
        }
        if (r4.isChecked()==true && n==3)
        {
            correctQuestion++;
        }
        if (r7.isChecked()==true && n==4)
        {
            correctQuestion++;
        }

        if (currentQuestion>totalQuestion)
        {
            openResultActivity(view);
        }

        if (currentQuestion == totalQuestion)
        {
            Button b9 = findViewById(R.id.button9);
            b9.setText("Finish");
        }
        TextView txt1 = findViewById(R.id.textView);
        TextView txt3 = findViewById(R.id.textView3);
        TextView txt4 = findViewById(R.id.textView4);
        TextView txt5 = findViewById(R.id.textView5);

        txt1.setText(question[n]);
        txt3.setText(null);
        txt4.setText(null);
        txt5.setText(String.valueOf(currentQuestion)+"/"+String.valueOf(totalQuestion));

        r2.setChecked(false);
        r3.setChecked(false);
        r4.setChecked(false);
        r7.setChecked(false);

        r2.setText("A) "+mcqs[0]);
        r3.setText("B) "+mcqs[1]);
        r4.setText("C) "+mcqs[2]);
        r7.setText("D) "+mcqs[3]);


        ImageView iv3 = findViewById(R.id.imageView3);
        iv3.setImageBitmap(null);

    }

    public void openResultActivity(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("correct", correctQuestion);
        intent.putExtra("total", totalQuestion);
        startActivity(intent);
    }

    public void viewAnswerBtnOnClick(View view)
    {
        int n = currentQuestion-1;

        TextView txt3 = findViewById(R.id.textView3);
        TextView txt4 = findViewById(R.id.textView4);

        txt3.setText("Correct Answer: "+correct[n]);
        txt4.setText("Explanation: "+explanation[n]);

        ImageView iv3 = findViewById(R.id.imageView3);

        if (currentQuestion==1)
            iv3.setImageResource(R.drawable.a);
        else if(currentQuestion==2)
            iv3.setImageResource(R.drawable.b);
        else if(currentQuestion==3)
            iv3.setImageResource(R.drawable.c);
        else if(currentQuestion==4)
            iv3.setImageResource(R.drawable.d);
    }

}