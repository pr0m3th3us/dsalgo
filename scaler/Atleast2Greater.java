package scaler;

import static common.InputReader.readIntArraylist;

import java.util.ArrayList;

public class Atleast2Greater {
    public static void main(String[] args) {
        System.out.println(solve(readIntArraylist()));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        if (A.size() < 3) {
            return new ArrayList<>();
        }

        //smallest and count
        int largest = Integer.MIN_VALUE;
        for (int i : A) {
            largest = i > largest ? i : largest;
        }
        int largest2 = Integer.MIN_VALUE;
        for (int i : A) {
            if (i < largest && i > largest2) largest2 = i;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i : A) {
            if (i < largest2) ret.add(i);
        }
        return ret;
    }
}
