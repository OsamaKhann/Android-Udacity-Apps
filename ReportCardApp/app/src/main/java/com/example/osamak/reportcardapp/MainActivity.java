package com.example.osamak.reportcardapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ReportCard> reportCards = new ArrayList<>();
        reportCards.add(new ReportCard("Osama Khan","A","B+","B+","B"));
        reportCards.add(new ReportCard("Abdul Moiz","B","C+","B+","A"));
        reportCards.add(new ReportCard("Faizan Javed","A","B","B+","C+"));
        reportCards.add(new ReportCard("Zawar Ali","A","B","B+","C"));
        reportCards.add(new ReportCard("Hamza Khan","A","B+","C","B"));

        TextView textView = (TextView) findViewById(R.id.text_one);

        for (int i=0;i<reportCards.size();i++){
            ReportCard reportCard = reportCards.get(i);
            textView.append(reportCard+"\n\n");
        }
    }
}
