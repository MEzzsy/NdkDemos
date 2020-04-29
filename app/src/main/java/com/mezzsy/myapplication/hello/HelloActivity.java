package com.mezzsy.myapplication.hello;

import android.os.Bundle;
import android.widget.TextView;

import com.mezzsy.myapplication.R;
import com.mezzsy.myapplication.zcommon.BaseActivity;

public class HelloActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        TextView textView = findViewById(R.id.tv_text);
        Hello hello = new Hello();
        textView.setText(hello.hello());
    }
}
