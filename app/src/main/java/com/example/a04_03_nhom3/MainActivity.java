package com.example.a04_03_nhom3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
   implements View.OnClickListener{
    private EditText eDate,eTime;
    private Button btDate,btTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btDate.setOnClickListener(this);
        btTime.setOnClickListener(this);
    }

    private void initView() {
        eDate=findViewById(R.id.editText);
        eTime=findViewById(R.id.editText2);
        btDate=findViewById(R.id.button);
        btTime=findViewById(R.id.button2);
    }

    @Override
    public void onClick(View v) {
        if(v==btDate){
            Calendar c=Calendar.getInstance();
            int y=c.get(Calendar.YEAR);
            int m=c.get(Calendar.MONTH);
            int d=c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog=new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view,
                                              int year, int month,
                                              int day) {
                              eDate.setText(day+"/"+(month+1)+"/"+year);
                        }
                    },y,m,d);
            dialog.show();
        }
        if(v==btTime){
            Calendar c=Calendar.getInstance();
            int h=c.get(Calendar.HOUR);
            int m=c.get(Calendar.MINUTE);
            TimePickerDialog dialog=new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view,
                                              int hour, int minute) {
                            eTime.setText(hour+":"+minute);
                        }
                    },h,m,false);
            dialog.show();
        }
    }
}
