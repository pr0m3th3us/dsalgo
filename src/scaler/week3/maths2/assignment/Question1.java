package scaler.week3.maths2.assignment;

import java.util.ArrayList;

import common.InputReader;

public class Question1 {
    public static void main(String[] args) {
        ArrayList<Integer> input = InputReader.readIntArraylist();
        System.out.println(gcd(input.get(0), input.get(1)));
    }

    public static int gcd(int A, int B) {
        int i = Math.max(A, B);
        int j = Math.min(A, B);
        if (j == 0) return i;
        return gcd(i % j, j);
    }
}
