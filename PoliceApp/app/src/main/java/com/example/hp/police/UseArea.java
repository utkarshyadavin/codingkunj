package com.example.hp.police;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by Hp on 02-12-2017.
 */

public class UseArea extends AppCompatActivity  {

    @Override
    public void onBackPressed(){
        moveTaskToBack(true);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_area);
        Bundle b = getIntent().getExtras();
        String Lat = b.getString("lat");
        String Long = b.getString("lon");
        EditText latitude = (EditText)findViewById(R.id.userarealatitude);
        EditText longitude = (EditText)findViewById(R.id.userarealongitude);
        TextView helpdestination = (TextView)findViewById(R.id.helpdestination);
        if(TextUtils.isEmpty(Lat)){
            helpdestination.setText("No Help Needed currently.But Stay Alert!");
            latitude.setText("000");
            longitude.setText("000");

        }
        else{
            helpdestination.setText("Help needed at following location");
            latitude.setText(Lat);
            longitude.setText(Long);

        }
    }}




