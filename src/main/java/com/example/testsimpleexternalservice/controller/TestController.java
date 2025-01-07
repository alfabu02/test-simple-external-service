package com.example.testsimpleexternalservice.controller;


public class TestController {
    public void a(Integer n) {
        System.out.println(n);
        for (int i = 0; i < 15; i++) {
            System.out.println("a");
        }
        System.out.println("last 2 ");
    }

    public void a2(Integer abs) {
        System.out.println("abs");
    }


}
