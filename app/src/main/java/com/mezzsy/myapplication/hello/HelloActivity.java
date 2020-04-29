package com.mezzsy.myapplication.hello;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mezzsy.myapplication.R;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        TextView textView = findViewById(R.id.tv_text);
        Hello hello = new Hello();
        textView.setText(hello.hello());
    }
}
