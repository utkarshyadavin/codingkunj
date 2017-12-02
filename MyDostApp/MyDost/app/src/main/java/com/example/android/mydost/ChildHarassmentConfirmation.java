package com.example.android.mydost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ChildHarassmentConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_harassment_confirmation);
        Bundle b = getIntent().getExtras();
        Double Lat = b.getDouble("mylatitude");
        Double Long = b.getDouble("mylongitude");
        EditText name = (EditText)findViewById(R.id.harassyourname);
        String childname = String.valueOf(name.getText());
    }
}
