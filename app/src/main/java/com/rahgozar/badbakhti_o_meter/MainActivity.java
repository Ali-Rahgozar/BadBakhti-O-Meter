package com.rahgozar.badbakhti_o_meter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
public class MainActivity extends AppCompatActivity {
    ArrayList<CharSequence> arrayListCollection;
    ArrayAdapter<CharSequence> adapter;
    EditText txt;
    public static int onKonkourTextClickCounter;
    public static SQLiteDatabase sqLiteDatabase;
    public static MyDatabaseOpenHelper myDatabaseOpenHelper;
    public static SQLiteDatabase secretSqLiteDatabase;
    public static SecretDatabaseOpenHelper secretDatabaseOpenHelper;
    public TextView KONKOUR_DAY_SHOWER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onKonkourTextClickCounter=0;
        setTitle("Home");
        myDatabaseOpenHelper=new MyDatabaseOpenHelper(this);
        sqLiteDatabase=myDatabaseOpenHelper.getWritableDatabase();

        secretDatabaseOpenHelper=new SecretDatabaseOpenHelper(this);
        secretSqLiteDatabase=secretDatabaseOpenHelper.getWritableDatabase();
KONKOUR_DAY_SHOWER=(TextView)findViewById(R.id.konkourDayShower);
KONKOUR_DAY_SHOWER.animate().alpha(0f);
KONKOUR_DAY_SHOWER.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
Intent intent=new Intent(MainActivity.this,SecretOutpot.class);
onKonkourTextClickCounter++;
if(onKonkourTextClickCounter==2){
    //Here change the Alert dialog the that it accepts a number as an input and check whether it is right as a password
    AlertDialog.Builder alertName = new AlertDialog.Builder(MainActivity.this);
    final EditText editTextName1 = new EditText(MainActivity.this);
    alertName.setTitle(" Enter your password");
// titles can be used regardless of a custom layout or not
    alertName.setView(editTextName1);
    LinearLayout layoutName = new LinearLayout(MainActivity.this);
    layoutName.setOrientation(LinearLayout.VERTICAL);
    layoutName.addView(editTextName1); // displays the user input bar
    alertName.setView(layoutName).setNegativeButton("yes", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
if(editTextName1.getText().toString().equals("8486")){
  startActivity(intent);

}
        }
    }).show();
onKonkourTextClickCounter=0;
}
    }
});

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

        SHOWER.setText(finalDateDayFormat+" DAYS until Konkour \n\n"+String.valueOf(date/7)+" WEEKS" +" and "+ date%7+" days "+" until Konkour");
    SHOWER.animate().alpha(1f).setDuration(1000);
    }
    public void showDatabaseContent(View view){

        Intent intent=new Intent(MainActivity.this,Outpot.class);
        startActivity(intent);



    }
    public void launcher(View view){

      Intent intent=new Intent(MainActivity.this,WritingActivity.class);
      startActivity(intent);

    }




}//End of class