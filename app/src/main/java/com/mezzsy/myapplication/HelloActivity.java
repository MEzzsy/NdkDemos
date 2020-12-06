package com.mezzsy.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mezzsy.myapplication.hello.Hello;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        testHello();
        testSwig();
    }

    private void testHello() {
        Hello hello = new Hello();
        hello.hello();
    }

    private void testSwig() {
        SwigTester tester = new SwigTester();
        tester.test();
    }
}
