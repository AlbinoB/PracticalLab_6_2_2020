package com.mitwpu.practicallab_6_2_2020;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class StudentRegisteration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registeration);

    }

//options menu global
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.studentmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.name:
                Toast.makeText(getApplicationContext(),item.getTitle().toString(), Toast.LENGTH_LONG).show();
                return true;
            case R.id.rollno:
                Toast.makeText(getApplicationContext(),item.getTitle().toString(),Toast.LENGTH_LONG).show();
                return true;
            case R.id.address:
                Toast.makeText(getApplicationContext(),item.getTitle().toString(),Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
