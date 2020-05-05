#此变量表示源文件在开发树中的位置。
#在这行代码中，编译系统提供的宏函数 my-dir 将返回当前目录（Android.mk 文件本身所在的目录）的路径。
LOCAL_PATH := $(call my-dir)

#CLEAR_VARS 变量指向一个特殊的 GNU Makefile，
#后者会清除许多 LOCAL_XXX 变量，例如 LOCAL_MODULE、LOCAL_SRC_FILES 和 LOCAL_STATIC_LIBRARIES。
#请注意，GNU Makefile 不会清除 LOCAL_PATH。
#此变量必须保留其值，因为系统在单一 GNU Make 执行环境（其中的所有变量都是全局变量）中解析所有编译控制文件。
#在描述每个模块之前，必须声明（重新声明）此变量。
include $(CLEAR_VARS)
#接下来，LOCAL_MODULE 变量存储您要编译的模块的名称。
LOCAL_MODULE := native
#列举源文件，以空格分隔多个文件
LOCAL_SRC_FILES := native-lib.cpp
#最后一行帮助系统将所有内容连接到一起
include $(BUILD_SHARED_LIBRARY)

## NDK 支持同时编译多个Module。
## 在配置的时候，每个Module需要 以 include $(CLEAR_VARS)开头 、 include $(BUILD_SHARED_LIBRARY)结尾
include $(CLEAR_VARS)
LOCAL_MODULE := hello
LOCAL_SRC_FILES := hello-lib.cpp
LOCAL_LDLIBS += -llog	#增加这行代码  -l<log库文件>

MY_SWIG_PACKAGE:=com.mezzsy.swig
MY_SWIG_INTERFACES:=Unix.i
MY_SWIG_TYPE:=cxx

include $(LOCAL_PATH)/my-swig-generate.mk


include $(BUILD_SHARED_LIBRARY)