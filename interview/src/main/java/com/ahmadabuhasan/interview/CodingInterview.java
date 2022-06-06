package com.ahmadabuhasan.interview;

public class CodingInterview {

    public static void main(String[] args) {

        int[] array_1 = new int[]{1, 2, 3, 4, 10, 20, 30, 100, 200, 300, 400, 1000, 2000, 3000};
        int[] array_2 = new int[]{3, 15, 5, 6, 8, 9, 11, 12, 13, 4};

        System.out.print("Array 1: ");
        for (int i = 0; i < array_1.length; i++) {
            System.out.print(array_1[i] + " ");
        }

        System.out.print("\nArray 2: ");
        for (int j = 0; j < array_2.length; j++) {
            System.out.print(array_2[j] + " ");
        }

        System.out.print("\nSame value: ");
        for (int i = 0; i < array_1.length; i++) {
            for (int j = 0; j < array_2.length; j++) {
                if (array_1[i] == array_2[j]) {
                    System.out.print(array_1[i] + " ");
                }
            }
        }

        // Result:
        /*Array 1: 1 2 3 4 10 20 30 100 200 300 400 1000 2000 3000
        Array 2: 3 15 5 6 8 9 11 12 13 4
        Same value: 3 4*/
    }
}