package com.example.android.mydost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Emergency extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        final Button policehelpline = (Button)findViewById(R.id.policehelpline);
        Button womanhelpline = (Button)findViewById(R.id.womanhelpline);
        Button childhelpline = (Button)findViewById(R.id.chilehelpline);

        policehelpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Emergency.this, PoliceHelpline.class);
                startActivity(i);
            }
        });

        
        womanhelpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Emergency.this, WomanHelpline.class);
                startActivity(i);
            }
        });



        childhelpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Emergency.this, ChildHelpline.class);
                startActivity(i);
            }
        });
    }
}
