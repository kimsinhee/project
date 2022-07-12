package com.example.balancebag;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class FirebasePost {
    public String emailId;
    public String gender;
    public String idToken;
    public String password;
    public String weight;

    public FirebasePost(){

    }

    public FirebasePost(String emailId,String gender,String idToken,String password,String weight ) {
        this.emailId =emailId;
        this.gender =gender;
        this.idToken=idToken;
        this.password =password;
        this.weight =weight;
    }

    @Exclude

    public Map<String,Object> toMap() {
        HashMap<String,Object> result =new HashMap<>();
        result.put("emailId",emailId);
        result.put("gender",gender);
        result.put("idToken",idToken);
        result.put("password",password);
        result.put("weight",weight);
        return result;
    }
}
