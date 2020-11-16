package com.test;

import org.aspectj.apache.bcel.classfile.*;
import org.aspectj.weaver.AjAttribute;
import org.aspectj.weaver.VersionedDataInputStream;
import org.aspectj.weaver.bcel.BcelConstantPoolReader;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Test3 {

    //https://blog.csdn.net/gavin_john/article/details/80156963
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/quyixiao/git/testACJ/target/classes/com/test/Hello.class");
        InputStream inputStream = new FileInputStream(file);
        ClassParser parser = new ClassParser(inputStream, file.getPath());
        JavaClass jc = parser.parse();
        Method[] methods = jc.getMethods();
        for (Method method : methods) {
            Attribute[] attributes = method.getAttributes();
            for (Attribute attribute : attributes) {
                System.out.println(method.getName() + "==========" + attribute.getName());
                if (attribute.getName().contains("MethodDeclarationLineNumber")) {
                    Unknown u = (Unknown) attribute;
                    BcelConstantPoolReader dataDecompressor = new BcelConstantPoolReader(method.getConstantPool());
                    VersionedDataInputStream s = new VersionedDataInputStream(new ByteArrayInputStream(u.getBytes()), dataDecompressor);
                    AjAttribute.MethodDeclarationLineNumberAttribute methodDeclarationLineNumberAttribute =  AjAttribute.MethodDeclarationLineNumberAttribute.read(s);
                    System.out.println(methodDeclarationLineNumberAttribute.getLineNumber());
                }
            }
        }
    }
}
