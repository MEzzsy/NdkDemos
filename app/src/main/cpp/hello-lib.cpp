//
// Created by Mezzsy on 2020/4/29.
//
#include <jni.h>
#include <string>

using namespace std;

extern "C"
JNIEXPORT jstring JNICALL
Java_com_mezzsy_myapplication_hello_Hello_hello(JNIEnv *env, jobject thiz) {
    string hello = "hello";
    return env->NewStringUTF(hello.c_str());
}