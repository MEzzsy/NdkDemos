package com.mezzsy.myapplication.hello;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.mezzsy.myapplication.R;
import com.mezzsy.myapplication.zcommon.BaseActivity;

import java.util.Arrays;

public class HelloActivity extends BaseActivity {
    private static final String TAG = "HelloActivity";
    private static final String LOG_PREFIX = TAG + " : ";
    private TextView mTvLog;
    private Hello mHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        mTvLog = findViewById(R.id.tv_log);
        mHello = new Hello();
    }

    @Override
    protected void onResume() {
        super.onResume();
        testHelloJni();
    }

    @SuppressLint("SetTextI18n")
    private void testHelloJni() {
        StringBuilder sb = new StringBuilder();

        appendText(sb, mHello.hello());

        appendText(sb, mHello.getCppString());
        mHello.setJavaString("String from Java");

        int size = 3;
        int[] javaIntArray = mHello.getCppIntArray(size);
        for (int i = 0; i < size; i++) {
            javaIntArray[i] = i;
        }
        mHello.setJavaIntArray(javaIntArray, size);
        appendText(sb, Arrays.toString(javaIntArray));

        mHello.handleThrowable();

        mTvLog.setText(sb.toString());
    }

    private void appendText(StringBuilder sb, String content) {
        sb.append(LOG_PREFIX).append(content).append("\n");
    }
}
