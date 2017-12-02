package com.example.hp.police;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONException;
import org.json.JSONObject;

import static android.support.v4.os.LocaleListCompat.create;




/**
 * Created by Hp on 02-12-2017.
 */

public class Register extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText Name = (EditText) findViewById(R.id.stationname);
        final EditText Code = (EditText) findViewById(R.id.stationcode);
        final EditText Latitude = (EditText) findViewById(R.id.latitude);
        final EditText Longitude = (EditText) findViewById(R.id.longitude);
        final EditText Contact = (EditText) findViewById(R.id.contactnumber);
        final Button register = (Button) findViewById(R.id.register);
        final String recent_token = FirebaseInstanceId.getInstance().getToken();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = Name.getText().toString();
                final int code = Integer.parseInt(Code.getText().toString());
                final float lat = Float.parseFloat(Latitude.getText().toString());
                final float lon = Float.parseFloat(Longitude.getText().toString());
                final String contact = Contact.getText().toString();
                final String deviceid = recent_token;
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent i = new Intent(Register.this, LoginActivity.class);
                                Register.this.startActivity(i);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(name, code, lat, lon, contact, deviceid, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Register.this);
                queue.add(registerRequest);
            }
        });

    }
}
