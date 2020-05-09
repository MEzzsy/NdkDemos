package com.mezzsy.ndkdemos.hello;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.mezzsy.ndkdemos.R;
import com.mezzsy.ndkdemos.zcommon.BaseActivity;
import com.mezzsy.swig.Unix;

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

        Unix.setGlobal_int(123);
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
        appendText(sb, String.valueOf(Unix.getuid()));
        appendText(sb, "全局变量 = " + Unix.getGlobal_int());
        appendText(sb, "设置全局变量值为456");
        Unix.setGlobal_int(456);
        appendText(sb, "此时，全局变量 = " + Unix.getGlobal_int());
        appendText(sb, "从文件读取的内容：" + mHello.nativeIODemo());

        mTvLog.setText(sb.toString());
    }

    private void appendText(StringBuilder sb, String content) {
        sb.append(LOG_PREFIX).append(content).append("\n");
    }
}
