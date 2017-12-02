package com.example.hp.police;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.Attributes;

public class LoginActivity extends AppCompatActivity {
    TextView Latitude,Longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Latitude =(TextView)findViewById(R.id.latitude);
        Longitude=(TextView)findViewById(R.id.longitude);
        if(getIntent().getExtras()!=null)
        {
            for(String key : getIntent().getExtras().keySet()){
                if(key.equals("lat"))
                    Latitude.setText(getIntent().getExtras().getString(key));
                else if(key.equals("lon"))
                    Longitude.setText(getIntent().getExtras().getString(key));
            }
        }




        final EditText Name = (EditText)findViewById(R.id.stationname);
        final EditText Code = (EditText)findViewById(R.id.stationcode);
        Button login =(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name= Name.getText().toString();
                final int  code = Integer.parseInt(Code.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Bundle b = new Bundle();
                                String Lat=Latitude.getText().toString();
                                Bundle c = new Bundle();
                                String Long = Longitude.getText().toString();
                                b.putString("lat",Lat);
                                b.putString("lon",Long);
                                Intent i = new Intent(LoginActivity.this, UseArea.class);
                                i.putExtras(b);
                                startActivity(i);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                };
                LoginRequest registerRequest = new LoginRequest(name,code,responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(registerRequest);
            }
        });



        Button loginregister =(Button)findViewById(R.id.loginregister);
        loginregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,Register.class);
                startActivity(i);
            }
        });




    }
}
