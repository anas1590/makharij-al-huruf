package com.example.makharij_al_huruf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void practiceBtnOnClick(View view)
    {
        openPracticeMcqsActivity(view);
    }
    public void quizBtnOnClick(View view)
    {
        openQuizMcqsActivity(view);
    }
    public void openRepositoryBtnOnClick(View view)
    {
        openRepository(view);
    }

    public void openPracticeMcqsActivity(View view)
    {
        Intent intent = new Intent(this, McqsActivity.class);
        intent.putExtra("page", 1);
        startActivity(intent);
    }

    public void openQuizMcqsActivity(View view)
    {
        Intent intent = new Intent(this, McqsActivity.class);
        intent.putExtra("page", 2);
        startActivity(intent);
    }

    public void openRepository(View view)
    {
        String url = "https://github.com/";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}