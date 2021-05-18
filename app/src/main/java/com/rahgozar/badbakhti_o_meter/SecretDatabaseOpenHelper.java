package com.rahgozar.badbakhti_o_meter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SecretDatabaseOpenHelper extends SQLiteOpenHelper {
    public static int VERSION=9;

    public SecretDatabaseOpenHelper(@Nullable Context context) {
        super(context, "secretDatabse", null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS secret ('Message' text , 'Date' text ) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
