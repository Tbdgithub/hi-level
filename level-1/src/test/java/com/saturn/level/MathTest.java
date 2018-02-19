package com.saturn.level;

import org.junit.Test;

public class MathTest {


    @Test
    public  void floor_test()
    {
        System.out.println("ceil(1.0) :"+Math.ceil(1.0));
        System.out.println("ceil(1) :"+Math.ceil(1));
        System.out.println("ceil(1.1) :"+Math.ceil(1.1));
        System.out.println("ceil(1.5) :"+Math.ceil(1.5));
        System.out.println("ceil(1.9) :"+Math.ceil(1.9));

        System.out.println("ceil(0) :"+Math.ceil(0));
        System.out.println("ceil(-1.1) :"+Math.ceil(-1.1));
        System.out.println("ceil(-1.5) :"+Math.ceil(-1.5));
        System.out.println("ceil(-1.9) :"+Math.ceil(-1.9));
    }
}
