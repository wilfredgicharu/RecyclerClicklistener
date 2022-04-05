package com.example.magicinsole;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Bluetooth extends AppCompatActivity implements DeviceListFragment.OnFragmentInteractionListener {

    private DeviceListFragment mDeviceListFragment;
    private BluetoothAdapter BTAdapter;


    public static int REQUEST_BLUETOOTH = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_deviceitem_list);

        FragmentManager fragmentManager = getSupportFragmentManager();

        mDeviceListFragment = DeviceListFragment.newInstance(BTAdapter);
        fragmentManager.beginTransaction().replace(R.id.container, mDeviceListFragment).commit();
    }

    @Override
    public void onFragmentInteraction(String id) {

    }
}