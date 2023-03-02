package interviewbit.arrays;

import java.util.ArrayList;

import org.apache.commons.lang3.tuple.Pair;

import common.InputReader;

public class MaxMin {

    public static void main(String[] args) {
        System.out.println(solve(InputReader.readIntArraylist()));
    }

    public static int solve(ArrayList<Integer> A) {
        return binarySplit(A);
    }

    public static int loop(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : A) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return min + max;
    }

    public static int binarySplit(ArrayList<Integer> A) {
        Pair<Integer, Integer> pair = rBinarySplit(A, 0, A.size() - 1);
        return pair.getLeft() + pair.getRight();
    }

    public static Pair<Integer, Integer> rBinarySplit(ArrayList<Integer> A, int i, int j) {
        if (i == j) return Pair.of(A.get(i), A.get(j));
        if (j - i == 1) return Pair.of(Math.min(A.get(i), A.get(j)), Math.max(A.get(i), A.get(j)));

        Pair<Integer, Integer> left = rBinarySplit(A, i, j/2);
        Pair<Integer, Integer> right = rBinarySplit(A, j/2 + 1, j);
        return Pair.of(Math.min(left.getLeft(), right.getLeft()), Math.max(left.getRight(), right.getRight()));
    }
}
