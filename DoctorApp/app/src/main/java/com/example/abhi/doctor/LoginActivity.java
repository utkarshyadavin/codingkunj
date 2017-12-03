package com.example.abhi.doctor;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    TextView UserName,ChatRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        UserName =(TextView)findViewById(R.id.username);
        ChatRoom=(TextView)findViewById(R.id.chatroom);
        if(getIntent().getExtras()!=null)
        {
            for(String key : getIntent().getExtras().keySet()){
                if(key.equals("username"))
                    UserName.setText(getIntent().getExtras().getString(key));
                else if(key.equals("room"))
                    ChatRoom.setText(getIntent().getExtras().getString(key));
            }
        }
        final EditText loginusername=(EditText)findViewById(R.id.loginusername);
        final EditText loginpassword=(EditText)findViewById(R.id.loginpassword);

        TextView loginregisterhere= (TextView)findViewById(R.id.loginregisterhere);
        loginregisterhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
        Button login =(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = loginusername.getText().toString();
                final String password = loginpassword.getText().toString();
                Log.d("username",username);
                Log.d("password",password);
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success=jsonResponse.getBoolean("success");
                            if(success){
                                Bundle b = new Bundle();
                                String username=UserName.getText().toString();
                                String chatroom = ChatRoom.getText().toString();
                                Intent i = new Intent(LoginActivity.this,ChatArea.class);
                                b.putString("username",username);
                                b.putString("room",chatroom);
                                i.putExtras(b);
                                startActivity(i);

                                LoginActivity.this.startActivity(i);
                            }
                            else{
                                AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                };

                LoginRequest loginRequest = new LoginRequest(username,password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}
