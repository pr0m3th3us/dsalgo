package scaler;

import java.util.ArrayList;

import common.InputReader;

public class MinimumPicks{
    public static void main(String[] args) {
        System.out.println(solve(InputReader.readIntArraylist()));
    }

    public static int solve(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE;
        int max = 1 << 31;
        for (int i : A) {
            if (Math.abs(i) % 2 == 1) {
                min = i < min ? i : min;
            } else {
                max = i > max ? i : max;
            }
        }
        return max - min;
    }
}