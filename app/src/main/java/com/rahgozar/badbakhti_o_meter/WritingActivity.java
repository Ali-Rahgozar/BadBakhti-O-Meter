package com.rahgozar.badbakhti_o_meter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WritingActivity extends AppCompatActivity {
    Button addTolList;


    @Override
   public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);
        MainActivity.onKonkourTextClickCounter=0;
        setTitle("Add new Item");
        addTolList=(Button)findViewById(R.id.addToListButton);
        addTolList.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                EditText editText=(EditText)findViewById(R.id.EditText);
                String finalText=editText.getText().toString();
                ContentValues content=new ContentValues();
                SecretDatabaseOpenHelper myDatabaseOpenHelper=MainActivity.secretDatabaseOpenHelper;
                SQLiteDatabase sqLiteDatabase=myDatabaseOpenHelper.getWritableDatabase();
                if(!finalText.isEmpty()) {
                    //Date
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat simpledateformatYear = new SimpleDateFormat("yyyy.MM.dd");
                    String Current_Date=simpledateformatYear.format(calendar.getTime());
                    //Date
                    content.put("Message", finalText);
                    content.put("Date", Current_Date);
                    sqLiteDatabase.insert("secret", null, content);
                    Toast.makeText(WritingActivity.this, "Your message has been saved to your Secret List", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(WritingActivity.this, "If you don't write anything, nothing would be added to the List", Toast.LENGTH_SHORT).show();
                }
                Intent intent=new Intent(WritingActivity.this,MainActivity.class);
                startActivity(intent);
                return false;
            }
        });








    }
    public void commit(View vieew){
        EditText editText=(EditText)findViewById(R.id.EditText);
        String finalText=editText.getText().toString();
        ContentValues content=new ContentValues();
        MyDatabaseOpenHelper myDatabaseOpenHelper=MainActivity.myDatabaseOpenHelper;
        SQLiteDatabase sqLiteDatabase=myDatabaseOpenHelper.getWritableDatabase();
       if(!finalText.isEmpty()) {
           //Date
           Calendar calendar = Calendar.getInstance();
           SimpleDateFormat simpledateformatYear = new SimpleDateFormat("yyyy.MM.dd");
           String Current_Date=simpledateformatYear.format(calendar.getTime());
           //Date
            content.put("Message", finalText);
           content.put("Date", Current_Date);
           sqLiteDatabase.insert("tb_name", null, content);
           Toast.makeText(this, "Your message has been saved to your List", Toast.LENGTH_SHORT).show();

       }else{
           Toast.makeText(this, "If you don't write anything, nothing would be added to the List", Toast.LENGTH_SHORT).show();
       }
        Intent intent=new Intent(WritingActivity.this,MainActivity.class);
        startActivity(intent);





    }


}

