//模块名是Unix.
%module Unix

%{
//包含POSIX操作系统API
#include <unistd.h>

%}

//inline是另一个常见的SWIG指示器，用来在接口文件中插入C/C++代码，并将代码中声明的内容输出到接口中。
%inline %{
//全局变量
int global_int;

//结构体
struct Point{
    int x;
    int y;
};
%}



//用define定义的常量
#define CONST_VALUE_1 100;
//用%constant指令定义的常量
%constant int CONST_VALUE_2 = 200;


// 告诉 SWIG uid_t.
typedef unsigned int uid_t;

//让 SWIG 包装 getuid 函数
extern uid_t getuid(void);