package com.example.osamak.scorekeeper_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int DEFAULT_SCORES = 0;
    int teamAGoals = 0;
    int teamBGoals = 0;
    int teamAFouls = 0;
    int teamBFouls = 0;
    int teamAOffsides = 0;
    int teamBOffsides = 0;
    int teamACorner = 0;
    int teamBCorner = 0;
    int teamAPenalties = 0;
    int teamBPenalties = 0;

    private TextView mTeamAFoulsTextView;
    private TextView mTeamBFoulsTextView;
    private TextView mTeamAPenaltiesTextView;
    private TextView mTeamBPenaltiesTextView;
    private TextView mTeamAOffsideTextView;
    private TextView mTeamBOffsideTextView;
    private TextView mTeamACornerTextView;
    private TextView mTeamBCornerTextView;
    private TextView mTeamAGoalsTextView;
    private TextView mTeamBGoalsTextView;

    private Button mResetTeamAcccountButton;
    private Button mGoalTeamA_Button;
    private Button mGoalTeamB_Button;
    private Button mFoulTeamA_Button;
    private Button mFoulTeamB_Button;
    private Button mOffsideTeamA_Button;
    private Button mOffsideTeamB_Button;
    private Button mCornerTeamA_Button;
    private Button mCornerTeamB_Button;
    private Button mPenaltyTeamA_Button;
    private Button mPenaltyTeamB_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        mResetTeamAcccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAll();
            }
        });

        mGoalTeamA_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementGoals(view);
            }
        });

        mGoalTeamB_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementGoals(view);
            }
        });

        mOffsideTeamA_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementOffSides(view);

            }
        });

        mOffsideTeamB_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementOffSides(view);
            }
        });

        mCornerTeamA_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementCorners(view);
            }
        });

        mCornerTeamB_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementCorners(view);
            }
        });

        mFoulTeamA_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementFouls(view);
            }
        });

        mFoulTeamB_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                incrementFouls(view);
            }
        });


        mPenaltyTeamA_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementPenalties(view);
            }
        });

        mPenaltyTeamB_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementPenalties(view);
            }
        });
    }


    /*
     This Method is used to wire up the xml Elements with activity objects
    */
    private void initUI() {

        mTeamAGoalsTextView = (TextView) findViewById(R.id.teamA_goal);
        mTeamAFoulsTextView = (TextView) findViewById(R.id.teamA_foul);
        mTeamAOffsideTextView = (TextView) findViewById(R.id.teamA_offside);
        mTeamACornerTextView = (TextView) findViewById(R.id.teamA_corner);
        mTeamAPenaltiesTextView = (TextView) findViewById(R.id.teamA_penalties);

        mGoalTeamA_Button = (Button) findViewById(R.id.teamA_goal_increment);
        mFoulTeamA_Button = (Button) findViewById(R.id.teamA_foul_increment);
        mCornerTeamA_Button = (Button) findViewById(R.id.teamA_corner_increment);
        mOffsideTeamA_Button = (Button) findViewById(R.id.teamA_offside_increment);
        mPenaltyTeamA_Button = (Button) findViewById(R.id.teamA_penalties_increment);

        mResetTeamAcccountButton = (Button) findViewById(R.id.reset_button);

        mTeamBGoalsTextView = (TextView) findViewById(R.id.teamB_goal);
        mTeamBCornerTextView = (TextView) findViewById(R.id.teamB_corner);
        mTeamBFoulsTextView = (TextView) findViewById(R.id.teamB_foul);
        mTeamBOffsideTextView = (TextView) findViewById(R.id.teamB_offside);
        mTeamBPenaltiesTextView = (TextView) findViewById(R.id.teamB_penalties);

        mGoalTeamB_Button = (Button) findViewById(R.id.teamB_goal_increment);
        mFoulTeamB_Button = (Button) findViewById(R.id.teamB_foul_increment);
        mCornerTeamB_Button = (Button) findViewById(R.id.teamB_corner_increment);
        mOffsideTeamB_Button = (Button) findViewById(R.id.teamB_offside_increment);
        mPenaltyTeamB_Button = (Button) findViewById(R.id.teamB_penalties_increment);

    }

    /*
     This Method is Used To increment Goals of Both Team on the Basis of which team button clicked
    */
    public void incrementGoals(View view) {
        switch (view.getId()) {
            case R.id.teamA_goal_increment:
                teamAGoals++;
                mTeamAGoalsTextView.setText(String.valueOf(teamAGoals));
                break;
            case R.id.teamB_goal_increment:
                teamBGoals++;
                mTeamBGoalsTextView.setText(String.valueOf(teamBGoals));
                break;
        }

    }

    /*
    This Method is Used To increment Corners of Both Team on the Basis of which team button clicked
    */
    public void incrementCorners(View view) {
        switch (view.getId()) {
            case R.id.teamA_corner_increment:
                teamACorner++;
                mTeamACornerTextView.setText(String.valueOf(teamACorner));
                break;
            case R.id.teamB_corner_increment:
                teamBCorner++;
                mTeamBCornerTextView.setText(String.valueOf(teamBCorner));
                break;
        }

    }


    /*
     This Method is Used To increment Fouls of Both Team on the Basis of which team button clicked
    */
    public void incrementFouls(View view) {

        switch (view.getId()) {
            case R.id.teamA_foul_increment:
                teamAFouls++;
                mTeamAFoulsTextView.setText(String.valueOf(teamAFouls));
                break;
            case R.id.teamB_foul_increment:
                teamBFouls++;
                mTeamBFoulsTextView.setText(String.valueOf(teamBFouls));
                break;
        }

    }

    /*
     This Method is Used To increment OffSides of Both Team on the Basis of which team button clicked
    */
    public void incrementOffSides(View view) {

        switch (view.getId()) {
            case R.id.teamA_offside_increment:
                teamAOffsides++;
                mTeamAOffsideTextView.setText(String.valueOf(teamAOffsides));
                break;
            case R.id.teamB_offside_increment:
                teamBOffsides++;
                mTeamBOffsideTextView.setText(String.valueOf(teamBOffsides));
                break;
        }

    }

    /*
     This Method is Used To increment Penalties of Both Team on the Basis of which team button clicked
    */
    public void incrementPenalties(View view) {
        switch (view.getId()) {

            case R.id.teamA_penalties_increment:
                teamAPenalties++;
                mTeamAPenaltiesTextView.setText(String.valueOf(teamAPenalties));
                break;
            case R.id.teamB_penalties_increment:
                teamBPenalties++;
                mTeamBPenaltiesTextView.setText(String.valueOf(teamBPenalties));
                break;
        }

    }


    /*
    This Method is used Reset all the Goals And Metrics of both Team
     */
    public void resetAll() {

        mTeamAGoalsTextView.setText(String.valueOf(DEFAULT_SCORES));
        mTeamAPenaltiesTextView.setText(String.valueOf(DEFAULT_SCORES));
        mTeamACornerTextView.setText(String.valueOf(DEFAULT_SCORES));
        mTeamAOffsideTextView.setText(String.valueOf(DEFAULT_SCORES));
        mTeamAFoulsTextView.setText(String.valueOf(DEFAULT_SCORES));


        mTeamBGoalsTextView.setText(String.valueOf(DEFAULT_SCORES));
        mTeamBPenaltiesTextView.setText(String.valueOf(DEFAULT_SCORES));
        mTeamBCornerTextView.setText(String.valueOf(DEFAULT_SCORES));
        mTeamBOffsideTextView.setText(String.valueOf(DEFAULT_SCORES));
        mTeamBFoulsTextView.setText(String.valueOf(DEFAULT_SCORES));
    }

}
