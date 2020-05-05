package com.mezzsy.myapplication.hello;

public class Hello {
    static {
        System.loadLibrary("hello");
    }

    private int mHelloInt = 1234;

    private static String sHelloString = "zzsy nb";

    private int getHelloInt() {
        return mHelloInt;
    }

    private static String getHelloString() {
        return sHelloString;
    }

    public native String hello();

    /**
     * 从Cpp创建字符串
     *
     * @return
     */
    public native String getCppString();

    /**
     * 把Java字符串转换成Cpp字符串
     *
     * @param javaString
     */
    public native void setJavaString(String javaString);

    /**
     * 从Cpp创建int数组
     *
     * @param size
     * @return
     */
    public native int[] getCppIntArray(int size);

    /**
     * 将Java int数组转为Cpp数组
     *
     * @param javaIntArray
     */
    public native void setJavaIntArray(int[] javaIntArray, int size);

    public void throwableMethod() throws NullPointerException{
        throw new NullPointerException("null pointer");
    }

    /**
     * 处理异常情况
     */
    public native void handleThrowable();

}
