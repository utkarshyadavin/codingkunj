package com.example.android.mydost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ReportAHospital extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_ahospital);

        String hospitalName;
        EditText hosname = (EditText)findViewById(R.id.hospitalname);
        hospitalName = String.valueOf(hosname.getText());
        String city;
        EditText hoscity = (EditText)findViewById(R.id.hospitalcity);
        city = String.valueOf(hoscity.getText());
        String State;
        EditText hosstate = (EditText)findViewById(R.id.hospitastate);
        State = String.valueOf(hosstate.getText());
    }
}
