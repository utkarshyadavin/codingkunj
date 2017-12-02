package com.example.abhi.doctor;

import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by abhi on 2/12/17.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService{
    private static final String REG_TOKEN = "REG_TOKEN" ;
    @Override
    public void onTokenRefresh(){
        String recent_token = FirebaseInstanceId.getInstance().getToken() ;


    }
}