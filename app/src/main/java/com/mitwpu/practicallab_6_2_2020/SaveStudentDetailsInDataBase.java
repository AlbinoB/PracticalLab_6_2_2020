package com.mitwpu.practicallab_6_2_2020;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SaveStudentDetailsInDataBase extends AppCompatActivity {
    public static final String DATABASE_NAME="student.db";
    DataBaseClass studentDB;


    EditText editTextName,editTextSurname,editTextMarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_student_details_in_data_base);

        editTextName=findViewById(R.id.editTextName);

        editTextSurname=findViewById(R.id.editTextSurname);

        editTextMarks=findViewById(R.id.editTextMarks);

        studentDB = new DataBaseClass(this,DATABASE_NAME);




        //create new table if doesn't exist
        String createTableSql="CREATE TABLE IF NOT EXISTS student123(ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT,SURNAME TEXT,MARKS INTEGER)";
        studentDB.createTable(createTableSql);


        Cursor cursor=studentDB.display("select ID,NAME,SURNAME,MARKS from student123");

        while (cursor.moveToNext()){
            Log.i("ID",cursor.getString(0));
            Log.i("Name",cursor.getString(1));
            Log.i("Surname",cursor.getString(2));
            Log.i("Marks",cursor.getString(3));
            Log.i("_____________","");
        }

        

    }

    public void btnSaveData(View view){
        if(studentDB.insertData("insert into student123(NAME,SURNAME,MARKS) values('"+editTextName.getText().toString()+"','"+editTextSurname.getText().toString()+"',"+Integer.parseInt(editTextMarks.getText().toString())+")"))
        {
            Toast.makeText(this, "Inserted sucessfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Insert failed", Toast.LENGTH_SHORT).show();
        }
    }

}
