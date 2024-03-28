package com.garisas.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tampilTelepon(View view) {
        Intent aplikasi = new Intent(Intent.ACTION_DIAL);
        startActivity(aplikasi);
    }

    public void TampilSMS(View view) {
        Intent aplikasi = new Intent(Intent.ACTION_MAIN);
        aplikasi.addCategory(Intent.CATEGORY_APP_MESSAGING);
        startActivity(aplikasi);
    }

    public void tampilKalender(View view) {
        Intent aplikasi = new Intent(Intent.ACTION_MAIN);
        aplikasi.addCategory(Intent.CATEGORY_APP_CALENDAR);
        startActivity(aplikasi);
    }

    public void tampilBrowser(View view) {
        Intent aplikasi = new Intent(Intent.ACTION_MAIN);
        aplikasi.addCategory(Intent.CATEGORY_APP_BROWSER);
        startActivity(aplikasi);
    }

    public void tampilKontak(View view) {
        Intent aplikasi = new Intent(Intent.ACTION_MAIN);
        aplikasi.addCategory(Intent.CATEGORY_APP_CONTACTS);
        startActivity(aplikasi);
    }

    public void tampilGaleri(View view) {
        Intent aplikasi = new Intent(Intent.ACTION_MAIN);
        aplikasi.addCategory(Intent.CATEGORY_APP_GALLERY);
        startActivity(aplikasi);
    }

    public void tampilWifi(View view) {
        Intent aplikasi = new Intent(Settings.ACTION_WIFI_SETTINGS);
        startActivity(aplikasi);
    }

    public void tampilSound(View view) {
        Intent aplikasi = new Intent(Settings.ACTION_SOUND_SETTINGS);
        startActivity(aplikasi);
    }

    public void tampilAirplaneMode(View view) {
        Intent aplikasi = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
        startActivity(aplikasi);
    }

    public void tampilAplikasi(View view) {
        Intent aplikasi = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
        startActivity(aplikasi);
    }

    public void tampilBluetooth(View view) {
        Intent aplikasi = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
        startActivity(aplikasi);
    }

    public void tampilKalkulator(View view) {
        ArrayList<HashMap<String, Object>> items = new ArrayList<HashMap<String,Object>>();
        final PackageManager pm = getPackageManager();

        List<PackageInfo> packs = pm.getInstalledPackages(0);

        for(PackageInfo pi: packs){
            String packageName = pi.packageName.toString();
            String packageName_LowerCase = packageName.toLowerCase();

            if(packageName_LowerCase.contains("calcul")){
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("appName", pi.applicationInfo.loadLabel(pm));
                map.put("packageName", pi.packageName);
                items.add(map);
            }
        }

        int item_size = items.size();

        if(item_size >= 1){
            String packageName = (String) items.get(0).get("packageName");
            Intent i = pm.getLaunchIntentForPackage(packageName);

            if(i != null){
                startActivity(i);
            }
            else{
                Toast.makeText(getApplicationContext(), "Tidak Ditemukan App Kalkulator", Toast.LENGTH_LONG).show();
            }
        }
    }
}