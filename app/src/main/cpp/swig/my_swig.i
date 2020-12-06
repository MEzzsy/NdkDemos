/**
 * 生成文件的名字
 * 每次调用SWIG都需要指定一个模块名，模块名用于给生成的封装文件命名，
 * 用SWIG特定的预处理指令%module指定模块名，该指令放在每个接口文件的开头。
 *
 * 生成回调时会用到
 * 重要：(directors="1")使能够使用%feature("director")
 */
%module(directors="1") SwigDemo

/**
 * 在生成的JNI文件中插入代码
 */
%pragma(java) jniclasscode=%{
    static {
        try {
            System.loadLibrary("my-swig");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
%}

/**
 * %{%} 块中的内容会被复制到生成文件中
 */
%{
#include "../impl/swig_impl.h"
//#include "../impl/hello_swig_type.h"
//#include "../impl/hello_swig_callback.h"

%};

//swig将C的int指针转为Java的数组
//%include "carrays.i"
//%include "cpointer.i"
//%array_functions(int, int_array);
//%array_class(NativeAnotherStruct, NativeAnotherStructArray);

//%feature("director") hello_swig_callback;

/**
 * 忽略此常量，否则会生成常量
 */
%ignore LOG_TAG;
//%ignore MAX_STRING_SIZE;

/**
 * inclde头文件，会将头文件里的内容生成对应的Java代码
 */
%include "../impl/swig_impl.h"
//%include "../impl/hello_swig_type.h"
//%include "../impl/hello_swig_callback.h"

//hello_swig_impl.h 里已经声明了，不需要再写
//void swig_hello();
//
//void swig_object_from_java(NativeStruct *nativeStruct);
//
//void swig_hello_with_callback(hello_swig_callback *callback);