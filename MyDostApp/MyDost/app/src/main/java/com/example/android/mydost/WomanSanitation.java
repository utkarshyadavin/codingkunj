package com.example.android.mydost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WomanSanitation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woman_sanitation);
        final Button doc1 =(Button)findViewById(R.id.doc1);
        Button doc2 =(Button)findViewById(R.id.doc2);
        Button doc3 =(Button)findViewById(R.id.doc3);
        final Button chattingdocname=(Button)findViewById(R.id.chattingdocname);
        doc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(WomanSanitation.this,ChatWindow.class);
                startActivity(i);
            }
        });
        doc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WomanSanitation.this,ChatWindow.class);
                startActivity(i);
            }
        });

        doc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WomanSanitation.this,ChatWindow.class);
                startActivity(i);
            }
        });
    }
}
