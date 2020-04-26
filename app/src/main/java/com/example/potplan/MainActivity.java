package com.example.potplan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.DatePickerDialog;
//*-import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    private TextView dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateText = findViewById(R.id.date_text);

        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

    }

    public void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String jesus="";
        switch(month){
            case 0: jesus = "January"; break;
            case 1: jesus = "February"; break;
            case 2: jesus = "March"; break;
            case 3: jesus = "April"; break;
            case 4: jesus = "May"; break;
            case 5: jesus = "June"; break;
            case 6: jesus = "July"; break;
            case 7: jesus = "August"; break;
            case 8: jesus = "September"; break;
            case 9: jesus = "October"; break;
            case 10: jesus = "November"; break;
            case 11: jesus = "December"; break;
        }
        String post = "th";
        if(dayOfMonth==2)
            post = "nd";
        if(dayOfMonth==1)
            post = "st";
        if(dayOfMonth==3)
            post = "rd";

        String date = dayOfMonth + post + " of "+jesus+", "+ year;
        dateText.setText(date);
    }
}

