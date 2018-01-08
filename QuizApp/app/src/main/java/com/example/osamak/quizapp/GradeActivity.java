package com.example.osamak.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class GradeActivity extends AppCompatActivity {


    final int TOTAL_FINAL = 6;

    private TextView mMessageTextView;
    private TextView mTotalScoreTextView;
    private TextView mPercentageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);


        initUI();
        int score = getIntent().getIntExtra("TotalScore", 0);

        int value = score * 100;
        double percentage = value / TOTAL_FINAL;


        if (percentage >= 60) {
            mMessageTextView.setText(R.string.pass_message);
            mTotalScoreTextView.setText(String.valueOf(score));
            mPercentageTextView.setText(String.valueOf(percentage +"%"));
        } else {
            mMessageTextView.setText(R.string.fail_message);
            mTotalScoreTextView.setText(String.valueOf(score));
            mPercentageTextView.setText(String.valueOf(percentage +"%"));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Intent intent =  new Intent(GradeActivity.this,MainActivity.class);
        startActivity(intent);
    }

    private void initUI() {
        mMessageTextView = (TextView) findViewById(R.id.pass_or_fail);
        mPercentageTextView = (TextView) findViewById(R.id.percentage);
        mTotalScoreTextView = (TextView) findViewById(R.id.total_score);
    }
}
