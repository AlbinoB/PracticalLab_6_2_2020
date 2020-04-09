package com.mitwpu.practicallab_6_2_2020;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class ReadWriteActivity extends AppCompatActivity {

    EditText editTextInsertData;
    Button buttonGetData;
    Button buttonSendData;

    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_write);

        editTextInsertData=findViewById(R.id.editTextInsertData);
        buttonGetData=findViewById(R.id.buttonGetData);
        buttonSendData=findViewById(R.id.buttonSendData);


        buttonSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editTextInsertData.getText().toString().isEmpty()){
                    Toast.makeText(ReadWriteActivity.this, "No Data inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    try {
                        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(getApplicationContext().openFileOutput("text.txt", Context.MODE_PRIVATE));
                        outputStreamWriter.write(editTextInsertData.getText().toString());
                        outputStreamWriter.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        buttonGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStreamReader inputStreamReader=new InputStreamReader(getApplicationContext().openFileInput("text.txt"));
                    BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                    String fetchedData="";
                    StringBuilder stringBuilder = new StringBuilder();

                    try {
                        while ((fetchedData=bufferedReader.readLine())!=null){
                            stringBuilder.append(fetchedData).append("\n");
                        }
                        System.out.println("Data fetched:"+fetchedData);

                    }catch (Exception e1){
                        Toast.makeText(ReadWriteActivity.this, "File is empty!", Toast.LENGTH_SHORT).show();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(ReadWriteActivity.this, "No file found!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
