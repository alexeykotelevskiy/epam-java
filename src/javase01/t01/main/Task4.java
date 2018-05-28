package javase01.t01.main;

import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("Input size of array:");
        n = in.nextInt();
        int[] a = getRandomArray(n);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int max = a[0] + a[a.length - 1];
        for (int i = 1; i < a.length / 2; i++) {
            if (a[i] + a[a.length - 1 - i] > max) {
                max = a[i] + a[a.length - 1 - i];
            }
        }
        System.out.println(max);
    }

    private static int[] getRandomArray(int n) {
        int[] a = new int[n];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(100);
        }
        return a;
    }
}