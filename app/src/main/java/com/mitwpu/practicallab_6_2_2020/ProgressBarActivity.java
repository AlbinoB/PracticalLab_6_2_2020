package com.mitwpu.practicallab_6_2_2020;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class ProgressBarActivity extends AppCompatActivity {
    ProgressDialog progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
    }


    public void popUpProgressBar(View view){
        progressBar=new ProgressDialog(this);
        progressBar.setIndeterminate(true);
        progressBar.setCancelable(false);
        progressBar.show();


    }
}
