package com.example.osamak.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SportsQuizActivity extends AppCompatActivity {

    private Button mSubmitScoreButton;

    private int mFinalQuizScore = 0;


    private RadioGroup mQuestionOneRadioGroup, mQuestionTwoRadioGroup, mQuestionThreeRadioGroup,
            mQuestionFourRadioGroup, mQuestionSixRadioGroup;

    private CheckBox mQuestionFiveOptionOne, mQuestionFiveOptionTwo,
            mQuestionFiveOptionThree, mQuestionFiveOptionFour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_quiz);


        initUI();
        mSubmitScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean mRadiosChecked = checkedRadioButtonsChecked();
                Boolean mCheckBoxChecked = checkBoxChecked();

                if (mRadiosChecked && mCheckBoxChecked) {
                    checkedAllAnswers();

                    Intent showScore = new Intent(SportsQuizActivity.this, GradeActivity.class);
                    showScore.putExtra("TotalScore", mFinalQuizScore);
                    startActivity(showScore);

                } else {
                    Toast.makeText(SportsQuizActivity.this, R.string.all_question_error, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    private void initUI() {

        mSubmitScoreButton = (Button) findViewById(R.id.submit_quiz);
        mQuestionOneRadioGroup = (RadioGroup) findViewById(R.id.sports_question_one);
        mQuestionTwoRadioGroup = (RadioGroup) findViewById(R.id.sports_question_two);
        mQuestionThreeRadioGroup = (RadioGroup) findViewById(R.id.sports_question_three);
        mQuestionFourRadioGroup = (RadioGroup) findViewById(R.id.sports_question_four);
        mQuestionSixRadioGroup = (RadioGroup) findViewById(R.id.sports_question_six);


        mQuestionFiveOptionOne = (CheckBox) findViewById(R.id.question_five_option_one);
        mQuestionFiveOptionTwo = (CheckBox) findViewById(R.id.question_five_option_two);
        mQuestionFiveOptionThree = (CheckBox) findViewById(R.id.question_five_option_three);
        mQuestionFiveOptionFour = (CheckBox) findViewById(R.id.question_five_option_four);

    }

    @NonNull
    private Boolean checkedRadioButtonsChecked() {

        if (mQuestionOneRadioGroup.getCheckedRadioButtonId() == -1 || mQuestionTwoRadioGroup.getCheckedRadioButtonId() == -1 ||
                mQuestionThreeRadioGroup.getCheckedRadioButtonId() == -1 || mQuestionFourRadioGroup.getCheckedRadioButtonId() == -1 ||
                mQuestionSixRadioGroup.getCheckedRadioButtonId() == -1) {

            return false;
        } else {
            return true;
        }
    }

    @NonNull
    private Boolean checkBoxChecked() {

        if (mQuestionFiveOptionOne.isChecked() || mQuestionFiveOptionTwo.isChecked() ||
                mQuestionFiveOptionThree.isChecked() || mQuestionFiveOptionFour.isChecked()) {
            return true;
        } else {
            return false;
        }
    }


    private void checkedAllAnswers() {
        if (mQuestionOneRadioGroup.getCheckedRadioButtonId() == R.id.question_one_option_three) {
            mFinalQuizScore++;
        }
        if (mQuestionTwoRadioGroup.getCheckedRadioButtonId() == R.id.question_two_option_two) {
            mFinalQuizScore++;
        }

        if (mQuestionThreeRadioGroup.getCheckedRadioButtonId() == R.id.question_three_option_four) {
            mFinalQuizScore++;
        }

        if (mQuestionFourRadioGroup.getCheckedRadioButtonId() == R.id.question_four_option_three) {
            mFinalQuizScore++;
        }

        if (mQuestionFiveOptionTwo.isChecked() && mQuestionFiveOptionFour.isChecked()) {
            mFinalQuizScore++;
        }

        if (mQuestionSixRadioGroup.getCheckedRadioButtonId() == R.id.question_six_option_one) {
            mFinalQuizScore++;
        }

    }



}
