package com.example.vitaliy.deletedoto;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FormActivity extends AppCompatActivity {
    private int DIALOG_TIME = 1;
    private int DIALOG_DATE = 2;
    // private int myHour, myMinute;
    @BindView(R.id.DateTV)
    TextView date;
    @BindView(R.id.TimeTV)
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.Clock)
    public void PickTime() {
        showDialog(DIALOG_TIME);
    }

    @OnClick(R.id.Date)
    public void PickDate() {
        showDialog(DIALOG_DATE);
    }

    @OnClick(R.id.CurrentDT)
    public void current(){ CurrentDate();}

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_TIME) {
            TimePickerDialog tpd = new TimePickerDialog(this, myCallback, 00, 00, true);
            return tpd;
        } else if (id == DIALOG_DATE) {
            DatePickerDialog dpd = new DatePickerDialog(this, myCall, 2017, 01, 01);
            return dpd;
        }
        return super.onCreateDialog(id);
    }

    TimePickerDialog.OnTimeSetListener myCallback = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int min) {
            time.setText(String.format("%02d:%02d", hour, min));
        }
    };

    DatePickerDialog.OnDateSetListener myCall = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");

            String dateString = dateFormat.format(calendar.getTime());
            date.setText(dateString);
        }
    };

    private void CurrentDate(){
        DateFormat datef = new SimpleDateFormat("dd:MM:yyyy");
        DateFormat timef = new SimpleDateFormat("hh:mm");
        datef.setLenient(false);
        date.setText(datef.format(new Date()));
        time.setText(timef.format(new Date()));
    }
}
