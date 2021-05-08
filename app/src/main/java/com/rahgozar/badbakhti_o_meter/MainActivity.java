package com.rahgozar.badbakhti_o_meter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
    public void DayCounter(View view){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpledateformatYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat simpledateformatMonth = new SimpleDateFormat("MM");
        SimpleDateFormat simpledateformatDay = new SimpleDateFormat("dd");
        int CURRENT_YEAR=Integer.parseInt(simpledateformatYear.format(calendar.getTime()));
        int CURRENT_MONTH=Integer.parseInt(simpledateformatMonth.format(calendar.getTime()));
        int CURRENT_DAY=Integer.parseInt(simpledateformatDay.format(calendar.getTime()));
        int KonKour_DAY=30;
        int KonKour_YEAR=2022;
        int KonKour_MONTH=6;
        String finalDateDayFormat=String.valueOf((KonKour_YEAR-CURRENT_YEAR)*365+(KonKour_MONTH-CURRENT_MONTH)*30+(KonKour_DAY-CURRENT_DAY));
        TextView SHOWER=(TextView)findViewById(R.id.konkourDayShower);
        int date=Integer.parseInt(finalDateDayFormat);

        SHOWER.setText(finalDateDayFormat+" DAYS until Konkour \n"+String.valueOf(date/7)+" WEEKS" +" and "+ date%7+" days "+" until Konkour");

    }


}