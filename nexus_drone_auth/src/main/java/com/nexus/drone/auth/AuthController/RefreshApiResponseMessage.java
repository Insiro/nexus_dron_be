package com.nexus.drone.auth.AuthController;

import java.util.Map;

import org.json.simple.JSONObject;

public class RefreshApiResponseMessage {

    Map<String,String> data;

    public RefreshApiResponseMessage(Map<String,String> input){
        this.data = input;
    }

    @Override
    public String toString(){

        JSONObject jsonObject = new JSONObject(data);

        return jsonObject.toString();
    }
}
