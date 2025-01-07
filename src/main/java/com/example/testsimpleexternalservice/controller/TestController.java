package com.example.testsimpleexternalservice.controller;


public class TestController {
    public void a(Integer n) {
        System.out.println(n);
        if (n % 15 == 0) {
            System.out.println("n is even");
            System.out.println("n is odd");
        }
        System.out.println("last 2 ");
    }

    public void a2(Integer abs) {
        System.out.println("abs");
    }


}
