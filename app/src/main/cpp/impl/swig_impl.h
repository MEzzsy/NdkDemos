//
// Created by Mezzsy on 2020/12/6.
//

#ifndef NDKDEMOS_SWIG_IMPL_H
#define NDKDEMOS_SWIG_IMPL_H

#include "android/log.h"

#define LOG_TAG "HelloNDK"
#define LOGI(...)  __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

void helloFromNative();


#endif //NDKDEMOS_SWIG_IMPL_H
