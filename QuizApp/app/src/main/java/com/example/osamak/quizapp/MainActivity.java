package com.example.osamak.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup mQuizCategory;
    private RadioButton mSelectedCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectQuizCategory();
    }


    public void selectQuizCategory(){
        Button mStartQuizButton = (Button) findViewById(R.id.start_quiz_button);
        mQuizCategory = (RadioGroup) findViewById(R.id.quiz_category);

        mStartQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedCategory =  mQuizCategory.getCheckedRadioButtonId();
                mSelectedCategory = (RadioButton) findViewById(selectedCategory);

                if (mSelectedCategory.getText().toString().equals("Sports")) {
                    Intent sportsCategory = new Intent(MainActivity.this,SportsQuizActivity.class);
                    startActivity(sportsCategory);
                }
                else {
                    Intent educationCategory = new Intent(MainActivity.this,EducationQuizActivity.class);
                    startActivity(educationCategory);
                }
            }
        });
    }
}
