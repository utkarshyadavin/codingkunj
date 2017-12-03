package com.example.abhi.doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText Name = (EditText)findViewById(R.id.name);
        final EditText UserName = (EditText)findViewById(R.id.username);
        final EditText Password=(EditText)findViewById(R.id.password);
        final EditText Expertise = (EditText)findViewById(R.id.expertise);
        final EditText Age =(EditText)findViewById(R.id.age);
        final TextView register = (TextView) findViewById(R.id.register);
        final String recent_token = FirebaseInstanceId.getInstance().getToken() ;
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name=Name.getText().toString();
                final String  username = UserName.getText().toString();
                final String password = Password.getText().toString();
                final int expertise =  Integer.parseInt(Expertise.getText().toString());
                final int age = Integer.parseInt(Age.getText().toString());
                final String deviceid = recent_token;
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success =jsonResponse.getBoolean("success");
                            if(success){
                                Intent i =new Intent(RegisterActivity.this,LoginActivity.class);
                                RegisterActivity.this.startActivity(i);
                            }
                            else{
                                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(name,username,password,expertise,age,deviceid,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}

