package scaler;

import static common.InputReader.*;

import java.util.ArrayList;

public class PrintingPattern {
    public static void main(String[] args) {
        System.out.println(solve(readInt()));
    }
    public static ArrayList<ArrayList<Integer>> solve(Integer A) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 1; j <= i; j++) row.add(j);
            for (int k = i + 1; k <= A; k++) row.add(0);
            ret.add(row);
        }
        return ret;
    }

    
}
