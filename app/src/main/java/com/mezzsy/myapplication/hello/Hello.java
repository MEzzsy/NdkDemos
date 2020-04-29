package com.mezzsy.myapplication.hello;

public class Hello {
    static {
        System.loadLibrary("hello-lib");
    }

    public native String hello();
}
