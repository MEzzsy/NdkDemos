package com.mezzsy.myapplication;

import com.mezzsy.myapplication.swig.SwigDemo;

public class SwigTester {

    public void test(){
        testHello();
    }

    private void testHello(){
        SwigDemo.helloFromNative();
    }
}
