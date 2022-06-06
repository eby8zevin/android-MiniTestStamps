package com.ahmadabuhasan.interview;

public class ApaBole {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                System.out.println("ApaBole");
            } else if (i % 3 == 0) {
                System.out.println("Apa");
            } else if (i % 5 == 0) {
                System.out.println("Bole");
            } else {
                System.out.println(i);
            }
        }
    }
}