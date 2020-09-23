package com.example.networkcheckaop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.networkcheckaop.aop.anotation.NetworkCheck;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void load1(View view) {
        loadData();

    }
    @NetworkCheck
    private void loadData() {
        Log.d("MainActivity", "执行了");
    }
}
