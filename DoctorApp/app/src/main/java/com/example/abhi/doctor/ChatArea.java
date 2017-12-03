package com.example.abhi.doctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

public class ChatArea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_area);
        Bundle b = getIntent().getExtras();
        String UserName = b.getString("username");
        String ChatRoom = b.getString("room");
        EditText chattingpatientname = (EditText)findViewById(R.id.chattingpatientname);
        TextView helpdestination =(TextView)findViewById(R.id.helpdestination);
        if(TextUtils.isEmpty(UserName)){
            helpdestination.setText("No Request Right Now!But Stay Alert!");
            chattingpatientname.setText("000");

        }
        else{
            helpdestination.setText("");
            chattingpatientname.setText(UserName);

        }
    }
}
