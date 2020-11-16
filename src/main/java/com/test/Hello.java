package com.test;


//https://blog.csdn.net/gavin_john/article/details/80156963
public class Hello {
    public String sayHello() {
        System.out.println("Hello, AspectJ!");
        return "xiaoming";
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.sayHello();
    }
}