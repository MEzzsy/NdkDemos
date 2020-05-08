//
// Created by Mezzsy on 2020/4/29.
//
#include <jni.h>
#include <string>
//NDK日志库
#include <android/log.h>
#include "fstream"

#define LOG_TAG "Hello"
#define LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)

using namespace std;

/**
 * @param env 指向可用JNI函数表的接口指针，原生代码通过JNIEnv接口指针提供的各种函数来使用虚拟机的功能
 * @param thiz 类实例的Java对象引用
 * @return
 */
extern "C"
JNIEXPORT jstring JNICALL
Java_com_mezzsy_ndkdemos_hello_Hello_hello(JNIEnv *env, jobject thiz) {
    //访问Java域
    //1。获取class对象
    jclass clazz = env->GetObjectClass(thiz);
    //2。获取域Id
    jfieldID instanceFieldId = env->GetFieldID(clazz, "mHelloInt", "I");
    jfieldID staticFieldId = env->GetStaticFieldID(clazz, "sHelloString", "Ljava/lang/String;");
    //3。根据域ID获取值
    jint mHelloInt = env->GetIntField(thiz, instanceFieldId);
    jstring sHelloString = static_cast<jstring>(env->GetStaticObjectField(clazz, staticFieldId));

    LOGI("%d", mHelloInt);
    jboolean isCopy = JNI_FALSE;
    const char *cppHelloString = env->GetStringUTFChars(sHelloString, &isCopy);
    LOGI("%s", cppHelloString);
    env->ReleaseStringUTFChars(sHelloString, cppHelloString);

    //访问Java方法
    //1.先获取class对象，这里复用上面的class对象
    //2.获取方法Id
    jmethodID instanceMethodId = env->GetMethodID(clazz, "getHelloInt", "()I");
    jmethodID staticMethodId = env->GetStaticMethodID(clazz, "getHelloString",
                                                      "()Ljava/lang/String;");
    //3.根据Id调用方法
    jint intResult = env->CallIntMethod(thiz, instanceMethodId);
    jstring stringResult = static_cast<jstring>(env->CallStaticObjectMethod(clazz, staticMethodId));
    LOGI("%d", intResult);
    const char *cppResultString = env->GetStringUTFChars(stringResult, &isCopy);
    LOGI("%s", cppResultString);
    env->ReleaseStringUTFChars(stringResult, cppResultString);

    string hello = "hello";
    return env->NewStringUTF(hello.c_str());
}

/**
 * 从Cpp创建字符串
 */
extern "C"
JNIEXPORT jstring JNICALL
Java_com_mezzsy_ndkdemos_hello_Hello_getCppString(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("hello from cpp!");
}

/**
 * 把Java字符串转换成C字符串
 */
extern "C"
JNIEXPORT void JNICALL
Java_com_mezzsy_ndkdemos_hello_Hello_setJavaString(JNIEnv *env, jobject thiz,
                                                        jstring java_string) {
    jboolean is_copy = JNI_FALSE;//返回的C字符串地址是指向副本还是指向堆中的固定对象
    const char *cpp_string = env->GetStringUTFChars(java_string, &is_copy);
    LOGI("%s", cpp_string);
    env->ReleaseStringUTFChars(java_string, cpp_string);//释放字符串，否则会内存泄漏。
}

/**
 * 从Cpp创建int数组
 */
extern "C"
JNIEXPORT jintArray JNICALL
Java_com_mezzsy_ndkdemos_hello_Hello_getCppIntArray(JNIEnv *env,
                                                         jobject thiz, jint size) {
    jintArray java_int_array = env->NewIntArray(size);
    return java_int_array;//暂未了解能不能对jintArray进行操作。
}

/**
 * 将Java int数组转为Cpp数组
 */
extern "C"
JNIEXPORT void JNICALL
Java_com_mezzsy_ndkdemos_hello_Hello_setJavaIntArray(JNIEnv *env, jobject thiz,
                                                          jintArray java_int_array, jint size) {
    //创建Java数组的副本
    jint cpp_int_array_copy[size];
    env->GetIntArrayRegion(java_int_array, 0, size, cpp_int_array_copy);
    for (int i = 0; i < size; ++i) {
        LOGI("%d", cpp_int_array_copy[i]);
    }

    //创建Java数组的指针
    jboolean is_copy = JNI_TRUE;
    jint *cpp_int_array_original = env->GetIntArrayElements(java_int_array, &is_copy);
    for (int i = 0; i < size; ++i) {
        (*(cpp_int_array_original + i))++;
    }
    env->ReleaseIntArrayElements(java_int_array, cpp_int_array_original, 0);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_mezzsy_ndkdemos_hello_Hello_handleThrowable(JNIEnv *env, jobject thiz) {

    jclass clazz = env->GetObjectClass(thiz);
    jmethodID throwableMethodId = env->GetMethodID(clazz, "throwableMethod", "()V");
    env->CallVoidMethod(thiz, throwableMethodId);
    jthrowable e = env->ExceptionOccurred();
    if (e != 0) {
        LOGI("异常出现");
        env->ExceptionClear();//显式地清除异常
    }
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_mezzsy_ndkdemos_hello_Hello_nativeIODemo(JNIEnv *env, jobject thiz) {
//    ofstream fout("/data/data/com.mezzsy.ndj");
    return 1;
}

