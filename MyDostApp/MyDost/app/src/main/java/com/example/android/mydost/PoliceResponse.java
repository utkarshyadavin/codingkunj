package com.example.android.mydost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PoliceResponse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_response);
        Bundle b = getIntent().getExtras();
        String contact = b.getString("contact");
        TextView contactdisplay=(TextView)findViewById(R.id.contactdisplay);
        contactdisplay.setText(contact);
    }
}
