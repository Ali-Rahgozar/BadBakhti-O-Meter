package com.rahgozar.badbakhti_o_meter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyDatabaseOpenHelper extends SQLiteOpenHelper {
    public static int VERSION=9;
    public MyDatabaseOpenHelper(@Nullable Context context) {
        super(context, "DB_NAME", null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("Database CREATED ","DATABASE IS CREATED");

        db.execSQL("CREATE TABLE IF NOT EXISTS tb_name ('Message' text , 'Date' text ) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("Database Upgraded ",String.valueOf(oldVersion)+"/"+String.valueOf(newVersion));
    }


    public String toString22(){
     return "Psgol in database";

}
    }

