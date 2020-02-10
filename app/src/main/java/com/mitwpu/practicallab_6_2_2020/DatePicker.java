package com.mitwpu.practicallab_6_2_2020;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class DatePicker extends AppCompatActivity {

    DatePickerDialog dialog;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        editText=(EditText)findViewById(R.id.editTextDOB);
        textView=(TextView)findViewById(R.id.displayAge);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                final int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(DatePicker.this,new DatePickerDialog.OnDateSetListener() {


                    @Override
                    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                        editText.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                        textView.setText("Your age is:"+(mYear-year));
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });
    }
}





