package org.example;

import java.util.Random;

public class HW1 {

    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(2001);
        System.out.println("Случайное число i = " + i);

        int n = Integer.toBinaryString(i).length() - 1;
        System.out.println("Номер старшего бита n = " + n);

        int count = 0;
        for (int l = i; l <= Short.MAX_VALUE; l++) {
            if (l % n == 0) {
                count++;
            }
        }
        System.out.println("m1 count = " + count);
        int[] m1 = new int[count];
        count = 0;

        for (int l = i; l <= Short.MAX_VALUE; l++) {
            if (l % n == 0) {
                m1[count++] = l;
            }
        }

        count = 0;
        for (int l = Short.MIN_VALUE; l < i; l++) {
            if (l % n != 0) {
                count++;
            }
        }
        System.out.println("m2 count = " + count);
        int[] m2 = new int[count];
        count = 0;

        for (int l = Short.MIN_VALUE; l < i; l++) {
            if (l % n != 0) {
                m2[count++] = l;
            }
        }
    }
}
