package com.example.edgar.optotypeaplicationv2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Edgar on 10/09/2017.
 */

public class RequestPatient {

    private String request;
    private Context context;

    public RequestPatient(String request, Context context) {
        this.request = request;
        this.context = context;
    }

    public void findPatientsToDay(){


        PatientDbHelper PatientDb = new PatientDbHelper(this.context);
        SQLiteDatabase db = PatientDb.getReadableDatabase();

        Log.d(".....","Consultar");
        Cursor cursor = db.rawQuery("SELECT name FROM patient_db_app", null);

        if (cursor.moveToFirst()){
            Log.d("ss: ","existen datos en la tabla local");
        }else{
            Log.d("nn: ","NO existen datos en la tabla local");
            HttpHandlerPatient httpRequestPatient = new HttpHandlerPatient(request, context);
            httpRequestPatient.connectToResource((DashBoardActivity) context);
        }

    }


}
