package com.rahgozar.badbakhti_o_meter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class WritingActivity extends AppCompatActivity {
public static SQLiteDatabase sqLiteDatabase;
   public static MyDatabaseOpenHelper myDatabaseOpenHelper;

    @Override
   public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);
         myDatabaseOpenHelper=new MyDatabaseOpenHelper(this);
        sqLiteDatabase=myDatabaseOpenHelper.getWritableDatabase();

    }
    public void commit(View vieew){
        EditText editText=(EditText)findViewById(R.id.EditText);
        String finalText=editText.getText().toString();
        ContentValues content=new ContentValues();
        content.put("Message",finalText);
        sqLiteDatabase.insert("tb_name",null,content);





    }
    public static MyDatabaseOpenHelper getSqLiteDatabase(){

      return myDatabaseOpenHelper;

    }


}

