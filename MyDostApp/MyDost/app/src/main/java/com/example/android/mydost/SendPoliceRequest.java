package com.example.android.mydost;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SendPoliceRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL="https://calm-atoll-61539.herokuapp.com/send_alert";
    private Map<String, String> params;
    public SendPoliceRequest(Float lat_usr, Float lon_usr, Float lat_pol, Float lon_pol, com.android.volley.Response.Listener<String> listener){
        super(Request.Method.POST,REGISTER_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("lat_usr",lat_usr +"");
        params.put("lon_usr",lon_usr +"");
        params.put("lat_pol",lat_pol +"");
        params.put("lon_pol",lon_pol +"");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
