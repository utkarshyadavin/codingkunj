package com.example.android.mydost;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class PoliceHelplineConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_helpline_confirmation);
        Bundle b = getIntent().getExtras();
        Double Lat = b.getDouble("mylatitude");
        Double Long = b.getDouble("mylongitude");
        final TextView mylatitude = (TextView) findViewById(R.id.mylatitude);
        final TextView mylongitude = (TextView) findViewById(R.id.mylongitude);
        final TextView policelatitude = (TextView) findViewById(R.id.policelatitude);
        final TextView policelongitude =(TextView) findViewById(R.id.policelongitude);
        final TextView sendpolicerequest = (TextView) findViewById(R.id.sendpolicerequest);
        Log.d("txt", String.valueOf(Lat));
        mylatitude.setText(String.valueOf(Lat));
        mylongitude.setText(String.valueOf(Long));
        policelatitude.setText("100.000");
        policelongitude.setText("100.000");
        sendpolicerequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Float lat_usr = Float.parseFloat(mylatitude.getText().toString());
                final Float lon_usr= Float.parseFloat(mylongitude.getText().toString());
                final Float lat_pol = Float.parseFloat(policelatitude.getText().toString());
                final Float lon_pol = Float.parseFloat(policelongitude.getText().toString());

                com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            String contact = jsonResponse.getString("contact");
                            if (success) {
                                Bundle b= new Bundle();
                                b.putString("contact",contact);
                                Intent i = new Intent(PoliceHelplineConfirmation.this, PoliceResponse.class);
                                i.putExtras(b);
                                startActivity(i);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(PoliceHelplineConfirmation.this);
                                builder.setMessage("Request Not Sent")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                };

                SendPoliceRequest registerRequest = new SendPoliceRequest(lat_usr,lon_usr,lat_pol,lon_pol,responseListener);
                RequestQueue queue = Volley.newRequestQueue(PoliceHelplineConfirmation.this);
                queue.add(registerRequest);

            }
        });

    }
}
