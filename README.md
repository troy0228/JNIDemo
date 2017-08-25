# JNIDemo
Java JNI方式调用c++类库的例子

JNI，是Java Native Interface的简称，中文是“Java本地调用”。

通过Java语言来调用Native语言的功能模块，避免重复制作

     1.首先在Java类中声明一个native的方法；  
     
     2.使用Javah命令生成native方法的声明的C/C++头文件；
     
     3.按照生成的C/C++头文件来编写C/C++源文件；
     
     4.将C/C++源文件编译成动态链接库（DLL)；
     
     5.将DLL文件加入到PATH环境变量下；
     
     6.Java类中加载DLL，然后调用声明方法    
         
其调用的例子是nativeDLL
