#检查MY_SWIG_PACKAGE变量是否定义
ifndef MY_SWIG_PACKAGE
	$(error MY_SWIG_PACKAGE is not defined)
endif

#NDK_PROJECT_PATH:= .

#用斜线替换Java目录下的圆点
MY_SWIG_OUTDIR:=$(NDK_PROJECT_PATH)/java/$(subst .,/,$(MY_SWIG_PACKAGE))

#SWIG的默认类型是C++
ifndef MY_SWIG_TYPE
	MY_SWIG_TYPE:= cxx
endif

#设置SWIG的模式
ifeq ($(MY_SWIG_TYPE) , cxx)
	MY_SWIG_MODE:= -c++
else
	MY_SWIG_MODE :=
endif

#追加SWIG封装源文件
LOCAL_SRC_FILES+= $(foreach MY_SWIG_INTERFACE, \
	$(MY_SWIG_INTERFACES),\
	$(basename $(MY_SWIG_INTERFACE))_wrap.$(MY_SWIG_TYPE))

#添加.cxx作为C++扩展名
LOCAL_CРP_EXTENSION+= .cxx

#生成SWIG封闭代码
%_wrap.$(MY_SWIG_TYPE) : %.i
	$(call host-mkdir,$(MY_SWIG_OUTDIR))
	swig -java \
	$(MY_SWIG_MODE) \
	-package $(MY_SWIG_PACKAGE) \
	-outdir $(MY_SWIG_OUTDIR) \
	$<
