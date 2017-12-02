package com.example.android.mydost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ReportAnOrphanage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_an_orphanage);


        String orphanageName;
        EditText orphname = (EditText)findViewById(R.id.orphanagename);
        orphanageName = String.valueOf(orphname.getText());
        String city;
        EditText orphcity = (EditText)findViewById(R.id.orphanagecity);
        city = String.valueOf(orphcity.getText());
        String State;
        EditText orphstate = (EditText)findViewById(R.id.orphanagestate);
        State = String.valueOf(orphstate.getText());
    }
}
