package com.example.android.mydost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class WomanHelplineConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woman_helpline_confirmation);

        Bundle b = getIntent().getExtras();
        Double Lat = b.getDouble("mylatitude");
        Double Long = b.getDouble("mylongitude");
        final EditText name = (EditText)findViewById(R.id.womanname);
        final EditText problem = (EditText)findViewById(R.id.womanproblem);
        final EditText mobilenumber = (EditText)findViewById(R.id.womanmobile);
        String womanName = String.valueOf(name.getText());
        String womanProblem = String.valueOf(problem.getText());
        String womanMobileNumber = String.valueOf(mobilenumber.getText());
    }
}
