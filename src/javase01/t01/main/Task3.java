package javase01.t01.main;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a;
        double b;
        double h;
        System.out.println("Enter a and b via a space:");
        a = in.nextDouble();
        b = in.nextDouble();
        System.out.println("Enter h:");
        h = in.nextDouble();
        while (a <= b) {
            System.out.format("%8.3f %8.3f\n", a, f(a));
            a += h;
        }
    }

    private static double f(double x) {
        return Math.tan(2 * x) - 3;
    }
}