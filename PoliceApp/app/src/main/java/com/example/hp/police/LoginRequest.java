package com.example.hp.police;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;




/**
 * Created by Hp on 02-12-2017.
 */

public class LoginRequest extends StringRequest{

    private static final String REGISTER_REQUEST_URL="https://calm-atoll-61539.herokuapp.com/login";
    private Map<String, String> params;
    public LoginRequest(String name,int code,Response.Listener<String>listener){
        super(Request.Method.POST,REGISTER_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("name",name);
        params.put("code",code +"");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }




}
