package com.example.abhi.doctor;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hp on 03-12-2017.
 */

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "https://secret-meadow-16362.herokuapp.com/register";
    private Map<String, String> params;

    public RegisterRequest(String name, String username, String password,int expertise, int age, String deviceid, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("username", username);
        params.put("password", password);
        params.put("expertise", expertise + "");
        params.put("age", age + "");
        params.put("deviceid",deviceid);
    }
    @Override
    public Map<String, String> getParams(){
        return params;
    }

}
