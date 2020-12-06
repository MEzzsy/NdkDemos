#include <jni.h>
#include <string>
#include "android/log.h"

#define LOG_TAG "HelloNDK"
#define LOGI(...)  __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

jint JNI_OnLoad(JavaVM *vm, void *) {
    LOGI("JNI_OnLoad");

    JNIEnv *env = nullptr;
    //动态注册JNI方法
    vm->GetEnv((void **)&env, JNI_VERSION_1_6);
    if (env==nullptr){
        return JNI_VERSION_1_6;
    }
//    env->RegisterNatives();

    return JNI_VERSION_1_6;
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_mezzsy_myapplication_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

void helloDynamicInNative() {
    LOGI("helloDynamicInNative");
}

static const JNINativeMethod gMethods[] =
        {
                {"helloDynamic", "()V", (void *) helloDynamicInNative}
        };

