package com.ahmadabuhasan.interview;

public class CodingTest {

    public static void main(String[] args) {

        ganjilGenap();
        prima();
        fibonacci();
    }

    private static void ganjilGenap() {
        System.out.print("Ganjil: ");
        for (int i = 0; i <= 10; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.print("\n");
        System.out.print("Genap: ");
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.print("\n");
    }

    private static void prima() {
        System.out.print("Prima: ");
        for (int i = 1; i <= 50; i++) {
            int bil = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    bil = bil + 1;
                }
            }
            if (bil == 2) {
                System.out.print(i + " ");
            }
        }
        System.out.print("\n");
    }

    private static void fibonacci() {
        System.out.print("Fibonacci: ");
        int a = 0;
        int b = 1;
        System.out.print(a + " " + b);
        for (int i = 2; i < 10; i++) {
            int total = a + b;
            System.out.print(" " + total);
            a = b;
            b = total;
        }
    }
}