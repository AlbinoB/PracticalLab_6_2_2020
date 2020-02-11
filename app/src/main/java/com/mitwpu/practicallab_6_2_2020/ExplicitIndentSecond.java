package com.mitwpu.practicallab_6_2_2020;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ExplicitIndentSecond extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_indent_second);

        textView=(TextView)findViewById(R.id.textViewDisplaySum);

        Intent intent = getIntent();

        String sum = intent.getStringExtra("sum");

        textView.setText(sum);

    }
}
