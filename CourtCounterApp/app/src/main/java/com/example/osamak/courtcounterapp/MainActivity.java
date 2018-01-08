package com.example.osamak.courtcounterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    /*
    * These variables are declared of button type.
    * */
    Button mThreePointATeamButton,mTwoPointATeamButton,mFreethrowATeamButton;
    Button mThreePointBTeamButton,mTwoPointBTeamButton,mFreethrowBTeamButton;
    Button mResetScoreButton;

    /*
    * These variable are used to record a score of both team
    */
    int teamAScore = 0;
    int teamBScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Instantiating the varibables with refernce of xml views

        mThreePointATeamButton = (Button) findViewById(R.id.team_a_three_points);
        mTwoPointATeamButton = (Button) findViewById(R.id.team_a_two_points);
        mFreethrowATeamButton = (Button) findViewById(R.id.team_a_free_throw);

        mThreePointBTeamButton = (Button) findViewById(R.id.team_b_three_points);
        mTwoPointBTeamButton = (Button) findViewById(R.id.team_b_two_points);
        mFreethrowBTeamButton = (Button) findViewById(R.id.team_b_free_throw);


        mResetScoreButton = (Button) findViewById(R.id.reset_score_button);

        //Set up a onclick listeners to handle a click event of button


        mResetScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetBothTeamScore(view);
            }
        });


        mThreePointATeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addThreeForTeamA(view);
            }
        });

        mTwoPointATeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTwoForTeamA(view);
            }
        });

        mFreethrowATeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFreeThrowForTeamA(view);
            }
        });


        mThreePointBTeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addThreeForTeamB(view);
            }
        });

        mTwoPointBTeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTwoForTeamB(view);
            }
        });

        mFreethrowBTeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFreeThrowForTeamB(view);
            }
        });

    }


    //This method make increment of 1 in Team A

    public void addFreeThrowForTeamA(View view){
        teamAScore++;
        displayForTeamA(teamAScore);
    }


    //This method make increment of 2 in Team A

    public void addTwoForTeamA(View view){
        teamAScore = teamAScore +2;
        displayForTeamA(teamAScore);
    }

    //This method make increment of 3 in Team A

    public void addThreeForTeamA(View view){
        teamAScore = teamAScore +3;
        displayForTeamA(teamAScore);

    }

    //This method make increment of 1 in Team B

    public void addFreeThrowForTeamB(View view){
        teamBScore++;
        displayForTeamB(teamBScore);
    }

    //This method make increment of 2 in Team B

    public void addTwoForTeamB(View view){
        teamBScore = teamBScore +2;
        displayForTeamB(teamBScore);
    }

    //This method make increment of 3 in Team B

    public void addThreeForTeamB(View view){
        teamBScore = teamBScore +3;
        displayForTeamB(teamBScore);

    }

    //This method reset both team score's

    public void resetBothTeamScore(View view){
        teamAScore = 0;
        teamBScore = 0;
        displayForTeamA(teamAScore);
        displayForTeamB(teamBScore);
    }

    //This Method used to display score of Team A
    public void displayForTeamA(int score){
        TextView mDisplayScoreTeamATextView = (TextView) findViewById(R.id.team_a_score);
        mDisplayScoreTeamATextView.setText(String.valueOf(score));
    }

    //This Method used to display score of Team B

    public void displayForTeamB(int score){
        TextView mDisplayScoreTeamBTextView = (TextView) findViewById(R.id.team_b_score);
        mDisplayScoreTeamBTextView.setText(String.valueOf(score));
    }

}
