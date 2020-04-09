package com.mitwpu.practicallab_6_2_2020;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Bluetooth_WiFi_Activity extends AppCompatActivity {

    boolean bluetoothAdapterDisable = true;
    Button bluetoothbtn, wifibtn;
    TextView textViewWifiScan;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_wifi);
        bluetoothbtn = findViewById(R.id.buttonCheckBluetooth);
        wifibtn = findViewById(R.id.buttonCheckWiFi);
        textViewWifiScan=findViewById(R.id.textViewDisplayAvailableWifi);

    }

    public void buttonCheckBluetoothFunction(View view) {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


        if (bluetoothAdapter == null) {
            Toast.makeText(this, "No bluetooth hardware found!!!", Toast.LENGTH_SHORT).show();
        } else {
            if (bluetoothAdapterDisable) {
                startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), 1);
                bluetoothAdapterDisable = false;
                bluetoothAdapter.disable();
            }

            if (bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.disable();
                bluetoothbtn.setText("Enable bluetooth");
                Toast.makeText(this, "Bluetooth disabled", Toast.LENGTH_SHORT).show();
                view.setBackgroundColor(getResources().getColor(R.color.btn_off));
            } else {
                bluetoothAdapter.enable();
                bluetoothbtn.setText("Disable bluetooth");
                view.setBackgroundColor(getResources().getColor(R.color.btn_on));
                Toast.makeText(this, "Bluetooth enabled", Toast.LENGTH_SHORT).show();
            }


        }
    }

    public void buttonCheckWiFiFunction(View view) {
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(true);
        if (wifiManager.isWifiEnabled()) {
            String toastMessage = "WiFi enabled";
            view.setBackgroundColor(getResources().getColor(R.color.btn_on));
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
        } else {
            String toastMessage = "Couldn't turn on WiFi";
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }

    public void buttonCheckInternetFunction(View view) {
        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        String toastMessage = "";
        try {
            boolean connected = (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) || (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE);
            if (connected) {
                toastMessage = "Connected to Wifi";
            } else {
                toastMessage = "Connected to Mobile Network";
            }


            if (networkInfo.isConnected()) {
                toastMessage = toastMessage + " and has internet access";
            } else {
                toastMessage = toastMessage + " but not internet access";
            }


        } catch (Exception e) {
            toastMessage = "Wifi and mobile net is off";
        }

        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }

    public void buttonGetAvailableWifiFunction(View view) {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(true);
        if (!wifiManager.isWifiEnabled()) {
            String toastMessage = "Turn on wifi";
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
        } else {
            wifiManager.startScan();
        }
    }

    public void onReceive(Context context, Intent intent) {
        Log.i("sssaa", "onReceive: called");
        String action = intent.getAction();
        if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION.equals(action)) {
            StringBuilder sb = new StringBuilder();
            List<ScanResult> wifiList = wifiManager.getScanResults();
            ArrayList<String> deviceList = new ArrayList<>();
            for (ScanResult scanResult : wifiList) {
                sb.append("\n").append(scanResult.SSID).append(" - ").append(scanResult.capabilities);
                deviceList.add(scanResult.SSID + " - " + scanResult.capabilities);
            }

            Log.i("ssss", "onReceive:"+sb);
            textViewWifiScan.setText(sb);

        }
    }
}
