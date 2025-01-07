package com.example.testsimpleexternalservice.controller;


public class TestController {
    public void a(Integer n) {
        if (n % 2 == 0) {
            System.out.println("n is even");
        } else {
            System.out.println("n is odd");
        }

        System.out.println("last");
    }
}
