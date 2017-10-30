package com.example.vitaliy.deletedoto;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.id;

public class FormActivity extends AppCompatActivity {
    private int DIALOG_TIME=1;
    private int DIALOG_DATE=2;
   // private int myHour, myMinute;
    @BindView(R.id.DateTV)TextView date;
    @BindView(R.id.TimeTV)TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.Clock)
    public void PickTime(){
        showDialog(DIALOG_TIME);
    }

    @OnClick(R.id.Date)
    public void PickDate(){
        showDialog(DIALOG_DATE);
    }

    protected Dialog onCreateDialog(int id){
        if(id == DIALOG_TIME){
            TimePickerDialog tpd = new TimePickerDialog(this, myCallback, 00, 00, true);
            return tpd;
        }
        else if(id == DIALOG_DATE){
            DatePickerDialog dpd = new DatePickerDialog(this, myCall,2017,01,01);
            return dpd;
        }
        return super.onCreateDialog(id);
    }

    TimePickerDialog.OnTimeSetListener myCallback = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int min) {
            time.setText(hour +":"+min);
        }
    };

    DatePickerDialog.OnDateSetListener myCall = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            date.setText(day+"/"+month+"/"+year);
        }
    };
}
