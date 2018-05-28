package javase01.t01.main;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double eps;
        System.out.println("Input eps:");
        eps = in.nextDouble();
        double a;
        int i = 0;
        do {
            i++;
            a = 1.0 / ((i + 1.0) * (i + 1.0));
            System.out.println("index = " + i + " a = " + a);
        } while (a >= eps);
        System.out.println("------------");
        System.out.println("Index = " + i);
    }
}