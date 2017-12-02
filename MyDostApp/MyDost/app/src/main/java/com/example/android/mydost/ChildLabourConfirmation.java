package com.example.android.mydost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ChildLabourConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_labour_confirmation);

        Bundle b = getIntent().getExtras();
        Double Lat = b.getDouble("mylatitude");
        Double Long = b.getDouble("mylongtude");
        EditText name = (EditText)findViewById(R.id.labourYourname);
        EditText organisationname = (EditText)findViewById(R.id.labourorganisationname);
        String childname = String.valueOf(name.getText());
        String orgname = String.valueOf(organisationname.getText());
    }
}
