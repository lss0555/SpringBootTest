package com.example.jvm.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

@BTrace(trusted = true)
public class PrintBtraceTest {
    @OnMethod(clazz = "com.example.jvm.btrace.btraceController",method = "getName",location=@Location(Kind.ENTRY))
    public static void getName(@ProbeClassName String className, @ProbeMethodName String methodName, AnyType[] anyTypes, @Duration long duration){
        BTraceUtils.print("className:"+className);
        BTraceUtils.print("methodName:"+methodName);
        BTraceUtils.print("args:"+anyTypes);
        BTraceUtils.print("duration:"+duration);
        BTraceUtils.print("");
    }
}
