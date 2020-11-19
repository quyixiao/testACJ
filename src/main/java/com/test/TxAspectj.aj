package com.test;

public aspect TxAspectj {


    //切入点
    pointcut mypointcut():call(* com.test.Hello.*(..));


    //前置增强
    before(): mypointcut(){
        System.out.println("前置增强");
    }

    //最终增强
    after():mypointcut(){
        System.out.println("后置增强");
    }


    Object around():mypointcut(){
        System.out.println("around start...");
        Object o = proceed();
        System.out.println("around end...");
        return o ;
    }



    //异常增强
    after() throwing(Exception e): mypointcut(){
        System.out.println("异常增强了");
        e.printStackTrace();
    }

    //异常增强
    after() returning(Object o): mypointcut(){
        System.out.println("返回" + o);
    }


}
