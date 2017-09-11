package com.example.edgar.optotypeaplicationv2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Edgar on 11/09/2017.
 */

public class HttpHandlerPatient {

    private String request;
    private Context context;
    ServerPath serverPath = new ServerPath();

    public HttpHandlerPatient(String request, Context context) {
        this.request = request;
        this.context = context;
    }

    public String sendRequestGet (){

        URL url = null;
        String line = "";
        int responseCode;
        StringBuilder result = null;
        String path = serverPath.getHttp() + serverPath.getIpAdddress() + serverPath.getPathAddress()+ this.request;
        String retunrValue = "";

        try{
            Log.d("path: ", path);

            url = new URL (path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            responseCode = connection.getResponseCode();// en caso de que halla respuesta el valor es 200

            Log.d("code paciente: ", Integer.toString(responseCode));
            // equivalente a preguntar si la respuesta es igual a 200
            if (responseCode == HttpURLConnection.HTTP_OK){

                result = new StringBuilder();
                InputStream input = new BufferedInputStream(connection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                while ((line = reader.readLine()) !=null ){
                    result.append(line);
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        if (result == null)
            retunrValue = "[{}]";
        else
            retunrValue = result.toString();

        Log.d("result : ",retunrValue);

        return result.toString();
    }


    public boolean verifyRespondeServer (String result){

        boolean value = false;

        try{

            JSONArray json = new JSONArray(result);
            if (json.length() > 0)
                value = true;

        }catch (Exception e){}

        return value;
    }

    public void connectToResource (final DashBoardActivity ctx){

        Thread tr = new Thread(){
            @Override
            public void run() {

                final String result= sendRequestGet();
                ctx.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (verifyRespondeServer(result)){
                            Toast.makeText(ctx.getApplicationContext(),"Conexion con patients", Toast.LENGTH_SHORT).show();
                            procesingJson(result);
                        } else
                            Toast.makeText(ctx.getApplicationContext(),"Conexion No patients", Toast.LENGTH_SHORT).show();
                        interrupt();
                    }
                });

            }
        };
        tr.start();

    }

    public void procesingJson (String result){

        JSONArray array = null;
        ContentValues values = new ContentValues();

        Log.d("JSON: ", result.toString());

        try {

            Log.d("trabajando: ", "SQLite");

            array = new JSONArray(result);

            PatientDbHelper PatientDb = new PatientDbHelper(this.context);
            SQLiteDatabase db = PatientDb.getWritableDatabase();

            for(int i=0; i<array.length(); i++){

                JSONObject jsonObj  = array.getJSONObject(i);

                values.put(PatientDbContract.PatientEntry.ID, jsonObj.getString("idpatient"));
                values.put(PatientDbContract.PatientEntry.NAME, jsonObj.getString("firstname"));
                values.put(PatientDbContract.PatientEntry.MIDDLENAME, jsonObj.getString("middlename"));
                values.put(PatientDbContract.PatientEntry.LASTNAME, jsonObj.getString("lastname"));
                values.put(PatientDbContract.PatientEntry.MAIDENNAME, jsonObj.getString("maidenname"));
                values.put(PatientDbContract.PatientEntry.YEARSOLD, jsonObj.getString("yearsold"));
                values.put(PatientDbContract.PatientEntry.FKUSER, jsonObj.getString("fkuser"));
                values.put(PatientDbContract.PatientEntry.PHOTO, Integer.toString(R.drawable.usuario_icon));

                db.insert(PatientDbContract.PatientEntry.TABLE_NAME, null, values);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("json: ", "No hay valor para procesar");
        }

    }

}
