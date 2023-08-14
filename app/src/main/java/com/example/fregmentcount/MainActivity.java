package com.example.fregmentcount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator{
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // create an object from dynamicFragment class
        dynamicFragment DynamicFragment = new dynamicFragment();
        //create fragmentManager
        manager = getSupportFragmentManager();
        //make transaction
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.dynamic_fragment,DynamicFragment,"dynamic");
        transaction.commit();
    }

    @Override
    public void sendData(int number) {
        dynamicFragment dynamicFg = (dynamicFragment)manager.findFragmentById(R.id.dynamic_fragment);
        dynamicFg.changeData(number);
    }
}