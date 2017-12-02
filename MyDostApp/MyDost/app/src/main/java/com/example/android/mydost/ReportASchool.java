package com.example.android.mydost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ReportASchool extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_aschool);

        String schoolName;
        EditText schname = (EditText)findViewById(R.id.schoolname);
        schoolName = String.valueOf(schname.getText());
        String city;
        EditText schcity = (EditText)findViewById(R.id.schoolcity);
        city = String.valueOf(schcity.getText());
        String State;
        EditText schstate = (EditText)findViewById(R.id.schoolstate);
        State = String.valueOf(schstate.getText());
    }
}
