package com.mezzsy.myapplication.zcommon;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author mezzsy
 * @date 2019-07-28
 */
public class MyTestFragment extends Fragment {
    private static final String TAG = "MyTestFragment";
    private TextView mTextView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: " + this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: " + this);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint: " + isVisibleToUser + ", " + this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: " + this);
        if (mTextView == null) {
            mTextView = new TextView(inflater.getContext());
            mTextView.setTextColor(Color.BLACK);
            mTextView.setTextSize(25);
            mTextView.setGravity(Gravity.CENTER);
        }
        return mTextView;
    }

    public void setText(String text) {
        if (mTextView != null)
            mTextView.setText(text);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: " + this);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: " + this);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: " + this);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: " + this);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: " + this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: " + this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: " + this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: " + this);
    }
}
