package com.mezzsy.ndkdemos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.mezzsy.ndkdemos.zcommon.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ListView mListView;
    private List<String> mTitleList;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.list_view);

        mTitleList = new ArrayList<>(ActivityConfig.ACTIVITY_MAP.keySet());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_expandable_list_item_1, mTitleList);

        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener((parent, view, position, id) -> {
            String title = mTitleList.get(position);
            Class<? extends BaseActivity> activityClass = ActivityConfig.ACTIVITY_MAP.get(title);
            Intent intent = new Intent(MainActivity.this, activityClass);
            startActivity(intent);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: NDK test: " + stringFromJNI());
        mListView.setSelection(mTitleList.size() - 1);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
