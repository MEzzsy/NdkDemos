package com.mezzsy.myapplication.hello;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mezzsy.myapplication.R;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        testHello();
    }

    private void testHello() {
        Hello hello = new Hello();
        hello.hello();
    }
}
