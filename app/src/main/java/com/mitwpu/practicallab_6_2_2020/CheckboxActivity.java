package com.mitwpu.practicallab_6_2_2020;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CheckboxActivity extends AppCompatActivity {

    CheckBox c1,c2,c3;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        c1=(CheckBox)findViewById(R.id.checkBox1);
        c2=(CheckBox)findViewById(R.id.checkBox2);
        c3=(CheckBox)findViewById(R.id.checkBox3);

        t1=(TextView) findViewById(R.id.textView);
        Intent intent=new Intent(CheckboxActivity.this,ContextMenuJava.class);
        startActivity(intent);



        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    c2.setChecked(false);
                    c3.setChecked(false);
                    t1.setText(c1.getText().toString());
                    Toast.makeText(CheckboxActivity.this, ""+c1.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    c1.setChecked(false);
                    c3.setChecked(false);
                    t1.setText(c2.getText().toString());
                    Toast.makeText(CheckboxActivity.this, ""+c2.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    c1.setChecked(false);
                    c2.setChecked(false);
                    t1.setText(c3.getText().toString());
                    Toast.makeText(CheckboxActivity.this, ""+c3.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
