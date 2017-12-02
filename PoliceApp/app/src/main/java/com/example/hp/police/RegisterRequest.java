package com.example.hp.police;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hp on 02-12-2017.
 */

public class RegisterRequest extends StringRequest{

    private static final String REGISTER_REQUEST_URL="https://calm-atoll-61539.herokuapp.com/register";
    private Map<String, String> params;
    public RegisterRequest(String name,int code,float lat,float lon,String contact,String deviceid,Response.Listener<String>listener){
        super(Request.Method.POST,REGISTER_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("name",name);
        params.put("code",code +"");
        params.put("lat",lat +"");
        params.put("lon",lon +"");
        params.put("contact",contact);
        params.put("deviceid",deviceid);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }


}
