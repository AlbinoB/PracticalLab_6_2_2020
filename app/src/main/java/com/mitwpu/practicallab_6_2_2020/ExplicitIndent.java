package com.mitwpu.practicallab_6_2_2020;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ExplicitIndent extends AppCompatActivity {

    EditText num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_indent);
        num1=(EditText)findViewById(R.id.editTextNum1);
        num2=(EditText)findViewById(R.id.editTextNum2);

    }

    public void sum(View view){
        Intent intent=new Intent(ExplicitIndent.this,ExplicitIndentSecond.class);
        intent.putExtra("sum",""+(Integer.parseInt(num1.getText().toString())+Integer.parseInt(num2.getText().toString())));
        startActivity(intent);
    }
}
