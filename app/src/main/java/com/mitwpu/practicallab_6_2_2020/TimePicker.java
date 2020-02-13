package com.mitwpu.practicallab_6_2_2020;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class TimePicker extends AppCompatActivity {

    EditText editTextTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        editTextTimer = (EditText) findViewById(R.id.editTextTimer);

        editTextTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                final int min = c.get(Calendar.MINUTE);
                final int hour = c.get(Calendar.HOUR_OF_DAY);

                TimePickerDialog timePickerDialog = new TimePickerDialog(TimePicker.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {

                        editTextTimer.setText(hour+":"+min);

                    }
                }, hour, min, true);
                timePickerDialog.show();
            }
        });


    }
}
