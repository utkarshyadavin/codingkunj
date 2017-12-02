package com.example.android.mydost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HealthCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_category);

        Button gynachologist=(Button)findViewById(R.id.gynachologist);
        gynachologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HealthCategory.this,Gynachologist.class);
                startActivity(i);
            }
        });
        Button pregnancy=(Button)findViewById(R.id.pregnancy);
        pregnancy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HealthCategory.this,Pregnancy.class);
                startActivity(i);
            }
        });
        Button womansanitation=(Button)findViewById(R.id.womansanitation);
        womansanitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HealthCategory.this,WomanSanitation.class);
                startActivity(i);
            }
        });
        Button generalhealth=(Button)findViewById(R.id.generalhealth);
        generalhealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HealthCategory.this,GeneralHealth.class);
                startActivity(i);
            }
        });
    }
}
