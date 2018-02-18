package com.example.android.muhammadkevindefianto_1202150080_modul2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class TakeAway extends AppCompatActivity {

    private EditText time;
    private EditText date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_away);
        time = (EditText) findViewById(R.id.time);
        date = (EditText) findViewById(R.id.date);
        Intent i = getIntent();
        Toast.makeText(getApplicationContext() , i.getStringExtra("toast"), Toast.LENGTH_SHORT).show();
        //menunjukkan fragmen saat edittext di klik.
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view);
            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(view);
            }
        });
    }

    //    2 method dibawah untuk membuka fragmen dan mendapatkan tanggal dari fragmen
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DateTimePickers();
        newFragment.show(getSupportFragmentManager(),"date Picker");
    }
    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        // Assign the concatenated strings to dateMessage.
        String dateMessage = (month_string + "/" +
                day_string + "/" + year_string);
        date.setText(dateMessage);
    }

    //    2 method dibawah untuk membuka fragmen dan mendapatkan waktu dari fragmen
    public void showTimePickerDialog(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(),"time picker");
    }
    public void processTimePickerResult(int hourOfDay, int minute) {
        // Convert time elements into strings.
        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
        // Assign the concatenated strings to timeMessage.
        String timeMessage = (hour_string + ":" + minute_string);
        time.setText(timeMessage);
    }

    //membuka aktivitas pilih Menu makan malam
    public void pilihPesan(View view) {
        Intent intent = new Intent(this, MenuMakanMalam.class);
        startActivity(intent);
    }

}
