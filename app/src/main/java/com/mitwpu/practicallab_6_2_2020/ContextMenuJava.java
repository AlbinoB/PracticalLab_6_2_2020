package com.mitwpu.practicallab_6_2_2020;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.ContextMenu.*;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ContextMenuJava extends AppCompatActivity {

    ListView listView;
    String names[]={"Albino","Ali","Ram"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        listView=(ListView)findViewById(R.id.listView);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,names);
        listView.setAdapter(arrayAdapter);
        registerForContextMenu((listView));

    }

    @Override
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("select the action");

    }

    public boolean onContextItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        switch (id){
            case R.id.call:
                Toast.makeText(getApplicationContext(),item.getTitle().toString(), Toast.LENGTH_LONG).show();
                return true;
            case R.id.sms:
                Intent intent=new Intent(Intent.ACTION_DIAL);
                Toast.makeText(getApplicationContext(),item.getTitle().toString(),Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }


}
