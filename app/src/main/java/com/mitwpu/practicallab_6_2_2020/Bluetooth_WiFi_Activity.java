package com.mitwpu.practicallab_6_2_2020;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Bluetooth_WiFi_Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_wifi);

    }

    public void buttonCheckBluetoothFunction(View view) {
        BluetoothAdapter bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter==null){
            Toast.makeText(this, "No bluetooth hardware found!!!", Toast.LENGTH_SHORT).show();

        }
        else {
            if(bluetoothAdapter.isEnabled())
            {
                view.setBackgroundColor(getResources().getColor(R.color.btn_on));

            }
            else
            {
                view.setBackgroundColor(getResources().getColor(R.color.btn_off));
            }
            
            Toast.makeText(this, "Bluetooth hardware found and enabled", Toast.LENGTH_SHORT).show();
            startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE),1);
        }
    }

    public void buttonCheckWiFiFunction(View view) {
        WifiManager wifiManager=(WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(true);
        if(wifiManager.isWifiEnabled()){
            String toastMessage="WiFi enabled";
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
        }
        else
        {
            String toastMessage="Couldn't turn on WiFi";
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }

    public void buttonCheckInternetFunction(View view) {
        ConnectivityManager cm=(ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=cm.getActiveNetworkInfo();

        String toastMessage="";
        try{
            boolean connected =(networkInfo.getType()==ConnectivityManager.TYPE_WIFI) ||(networkInfo.getType()==ConnectivityManager.TYPE_MOBILE) ;
            if(connected){
                toastMessage="Connected to Wifi";
            }
            else
            {
                toastMessage="Connected to Mobile Network";
            }



            if(networkInfo.isConnected()){
                toastMessage=toastMessage+" and has internet access";
            }
            else
            {
                toastMessage=toastMessage+" but not internet access";
            }


        }catch (Exception e){
            toastMessage="Wifi and mobile net is off";
        }

        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }
}
