package com.example.junli.reminderapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.app.ActionBar;
import android.text.format.DateFormat;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CreateActivity extends AppCompatActivity {

    @BindView(R.id.create_coordinator)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.notification_title)
    EditText titleEditText;
    @BindView(R.id.notification_content) EditText contentEditText;
    @BindView(R.id.time)
    TextView timeText;
    @BindView(R.id.date) TextView dateText;
    @BindView(R.id.show_times_number) EditText timesEditText;

    @BindView(R.id.bottom_row) LinearLayout bottomRow;
    @BindView(R.id.show) TextView showText;
    @BindView(R.id.times) TextView timesText;
    @BindView(R.id.error_time) ImageView imageWarningTime;
    @BindView(R.id.error_date) ImageView imageWarningDate;
    @BindView(R.id.error_show) ImageView imageWarningShow;
    @BindView(R.id.toolbar) Toolbar toolbar;

    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        ButterKnife.bind(this);

/*
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_cancel);
        if (getActionBar() != null) getActionBar().setDisplayHomeAsUpEnabled(true);
        if (getSupportActionBar() != null) getSupportActionBar().setTitle(null);
*/
    }



    @OnClick(R.id.time_row)
    public void timePicker() {
        TimePickerDialog TimePicker = new TimePickerDialog(CreateActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(android.widget.TimePicker timePicker, int hour, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY, hour);
                calendar.set(Calendar.MINUTE, minute);
                timeText.setText(DateAndTimeUtil.toStringReadableTime(calendar, getApplicationContext()));
            }
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), DateFormat.is24HourFormat(this));
        TimePicker.show();
    }

    @OnClick(R.id.date_row)
    public void datePicker(View view) {
        DatePickerDialog DatePicker = new DatePickerDialog(CreateActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(android.widget.DatePicker DatePicker, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                dateText.setText(DateAndTimeUtil.toStringReadableDate(calendar));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        DatePicker.show();
    }



}
