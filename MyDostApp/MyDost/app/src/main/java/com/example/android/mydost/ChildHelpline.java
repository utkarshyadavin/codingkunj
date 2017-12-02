package com.example.android.mydost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChildHelpline extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_helpline);

        Button childLabour = (Button)findViewById(R.id.childlabour);
        final Button childHarassment = (Button)findViewById(R.id.childharassment);
        Button reportaSchool = (Button)findViewById(R.id.reportaschool);
        Button reportaHospital = (Button)findViewById(R.id.reportahospital);
        Button reportanOrphanage = (Button)findViewById(R.id.reportanorphanage);

        reportaSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChildHelpline.this, ReportASchool.class);
                startActivity(i);
            }
        });

        reportaHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChildHelpline.this, ReportAHospital.class);
                startActivity(i);
            }
        });

        reportanOrphanage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChildHelpline.this, ReportAnOrphanage.class);
                startActivity(i);
            }
        });

        childLabour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChildHelpline.this, ChildLabour.class);
                startActivity(i);
            }
        });
        childHarassment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(ChildHelpline.this, ChildHarassment.class);
                startActivity(i);
            }
        });
    }
}
