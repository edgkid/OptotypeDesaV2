package com.example.edgar.optotypeaplicationv2;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Edgar on 10/09/2017.
 */

public class RequestUser {

    private String request;
    private Context context;

    public RequestUser(String request, Context context) {
        this.request = request;
        this.context = context;
    }

    /**
     * This method generate a request to find  user data  for access the app
     * @return boolean
     */
    public boolean findUserOnSystem (){

        boolean value = false;
        String password = "";
        String user = "";
        String roll = "";

        HttpHandlerUser httpRequestUser = new HttpHandlerUser(request, context);
        httpRequestUser.connectToResource((LoginActivity) context);

        SharedPreferences loginPreferences = context.getSharedPreferences("LoginPreferences", Context.MODE_PRIVATE);

        Log.d("Datos: ",  loginPreferences.getString("user", "defaultUser"));
        Log.d("Datos: ", loginPreferences.getString("password", "defaultUser"));

        user = loginPreferences.getString("user", "defaultUser");
        password = loginPreferences.getString("password", "defaultUser");

        if (!user.equals("defaultUser") && !password.equals("defaultUser")){
            value = true;
        }

        return value;
    }
}
