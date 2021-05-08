package com.rahgozar.badbakhti_o_meter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WritingActivity extends AppCompatActivity {


    @Override
   public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);
        setTitle("Add new Item");


    }
    public void commit(View vieew){
        EditText editText=(EditText)findViewById(R.id.EditText);
        String finalText=editText.getText().toString();
        ContentValues content=new ContentValues();
        MyDatabaseOpenHelper myDatabaseOpenHelper=MainActivity.myDatabaseOpenHelper;
        SQLiteDatabase sqLiteDatabase=myDatabaseOpenHelper.getWritableDatabase();
       if(!finalText.isEmpty()) {
            content.put("Message", finalText);
            sqLiteDatabase.insert("tb_name", null, content);
           Toast.makeText(this, "Your message has been saved to your List", Toast.LENGTH_SHORT).show();

       }else{
           Toast.makeText(this, "If you don't write anything, nothing would be added to the List", Toast.LENGTH_SHORT).show();
       }
        Intent intent=new Intent(WritingActivity.this,MainActivity.class);
        startActivity(intent);





    }


}

