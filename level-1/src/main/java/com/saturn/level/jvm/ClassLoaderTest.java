package com.saturn.level.jvm;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

    public static void main(String [] args) throws Exception
    {
        ClassLoader myLoader=new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                //return super.loadClass(name);

                try {
                    String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
                    System.out.println("class load fileName:"+fileName);
                    InputStream is=getClass().getResourceAsStream(fileName);
                    if(is==null)
                    {
                       // resolveClass(super.loadClass(name));
                        return  super.loadClass(name);
                    }

                    byte[] b=new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }


            }
        };

        Object objDefault=Class.forName("com.saturn.level.jvm.ClassLoaderTest").newInstance();
                //=ClassLoaderTest.class.getClass().getClassLoader().loadClass("com.saturn.level.jvm.ClassLoaderTest").newInstance();

        System.out.println("Are same instance?:"+( objDefault instanceof com.saturn.level.jvm.ClassLoaderTest));

        Object obj=myLoader.loadClass("com.saturn.level.jvm.ClassLoaderTest").newInstance();

        System.out.println("obj class:"+obj.getClass());
        System.out.println("Are same instance?:"+(obj instanceof com.saturn.level.jvm.ClassLoaderTest));



    }
}
