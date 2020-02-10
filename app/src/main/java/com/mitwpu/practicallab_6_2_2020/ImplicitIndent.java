package com.mitwpu.practicallab_6_2_2020;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ImplicitIndent extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_indent);
        editText=(EditText)findViewById(R.id.editTextUrl);
    }

    public void goToNextActivity(View view){
        String url=editText.getText().toString();
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+url));


        Intent intent1=new Intent(Intent.ACTION_DIAL);
        intent1.setData(Uri.parse("tel:9850044032"));

        Intent intent2=new Intent(Intent.ACTION_CALL);
        intent2.setData(Uri.parse("tel:9850044032"));




        startActivity(intent1);
    }
}
