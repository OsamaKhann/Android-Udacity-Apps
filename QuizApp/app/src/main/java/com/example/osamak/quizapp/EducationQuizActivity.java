package com.example.osamak.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EducationQuizActivity extends AppCompatActivity {

    private int mFinalQuizScore = 0;

    private EditText mQuestionFourEditText, mQuestionSixEditText;

    private CheckBox mQuestionFiveOptionOne, mQuestionFiveOptionTwo,
            mQuestionFiveOptionThree, mQuestionFiveOptionFour;

    private RadioGroup mQuestionOneRadioGroup, mQuestionTwoRadioGroup,
            mQuestionThreeRadioGroup;

    private Button mSubmitScoreButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_quiz);

        initUI();

       mSubmitScoreButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if (isRadioButtonsChecked() && isCheckBoxChecked() && isEditTextNotEmpty()){
                   checkedAllAnswers();

                   Intent showScore = new Intent(EducationQuizActivity.this, GradeActivity.class);
                   showScore.putExtra("TotalScore", mFinalQuizScore);
                   startActivity(showScore);
               }
               else {
                   Toast.makeText(EducationQuizActivity.this,R.string.all_question_error,Toast.LENGTH_SHORT).show();
               }
           }
       });

    }


    private void initUI() {

        mSubmitScoreButton = (Button) findViewById(R.id.submit_quiz);

        mQuestionOneRadioGroup = (RadioGroup) findViewById(R.id.education_question_one);
        mQuestionTwoRadioGroup = (RadioGroup) findViewById(R.id.education_question_two);
        mQuestionThreeRadioGroup = (RadioGroup) findViewById(R.id.education_question_three);


        mQuestionFiveOptionOne = (CheckBox) findViewById(R.id.question_five_option_one);
        mQuestionFiveOptionTwo = (CheckBox) findViewById(R.id.question_five_option_two);
        mQuestionFiveOptionThree = (CheckBox) findViewById(R.id.question_five_option_three);
        mQuestionFiveOptionFour = (CheckBox) findViewById(R.id.question_five_option_four);

        mQuestionFourEditText =  (EditText) findViewById(R.id.question_four);
        mQuestionSixEditText = (EditText) findViewById(R.id.question_six);
    }

    @NonNull
    private Boolean isRadioButtonsChecked() {

        if (mQuestionOneRadioGroup.getCheckedRadioButtonId() == -1 || mQuestionTwoRadioGroup.getCheckedRadioButtonId() == -1 ||
                mQuestionThreeRadioGroup.getCheckedRadioButtonId() == -1)
            return false;
        else{
            return true;
        }
    }

    @NonNull
    private Boolean isCheckBoxChecked() {

        if (mQuestionFiveOptionOne.isChecked() || mQuestionFiveOptionTwo.isChecked() ||
                mQuestionFiveOptionThree.isChecked() || mQuestionFiveOptionFour.isChecked())
            return true;
        else {
            return false;
        }
    }

    @NonNull
    private Boolean isEditTextNotEmpty(){

        if (mQuestionFourEditText.getText().toString().isEmpty() || mQuestionSixEditText.getText().toString().isEmpty())
            return false;
        else {
            return true;
        }
    }

    private void checkedAllAnswers() {

        if (mQuestionOneRadioGroup.getCheckedRadioButtonId() == R.id.question_one_option_three) {
            mFinalQuizScore++;
        }
        if (mQuestionTwoRadioGroup.getCheckedRadioButtonId() == R.id.question_two_option_one) {
            mFinalQuizScore++;
        }

        if (mQuestionThreeRadioGroup.getCheckedRadioButtonId() == R.id.question_three_option_four) {
            mFinalQuizScore++;
        }

        if (mQuestionFourEditText.getText().toString().equals(getString(R.string.education_question_four_correct_anwser))) {
            mFinalQuizScore++;
        }

        if (mQuestionFiveOptionOne.isChecked() && mQuestionFiveOptionFour.isChecked()) {
            mFinalQuizScore++;

        }

        String six = mQuestionSixEditText.getText().toString().toLowerCase();
        String sixAns = getString(R.string.education_question_six_correct_anwser).toLowerCase();

        if (six.equals(sixAns)) {
            mFinalQuizScore++;
        }

    }

}