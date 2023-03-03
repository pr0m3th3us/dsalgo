package scaler;

import static common.InputReader.readIntArraylist;

import java.util.ArrayList;
import java.util.Collections;

public class SmallerOrGreater {
    public static void main(String[] args) {
        System.out.println(solve(readIntArraylist()));
    }

    public static int solve(ArrayList<Integer> A) {
        if (A.size() < 3) return 0;
        Collections.sort(A);
        int i = 0, j = 1, k = 2;
        
        int counter = 0;
        do {
            int prev = A.get(i);
            int curr = A.get(j);
            int next = A.get(k);
            if (prev < curr && curr < next) {
                counter++;
                i++;
                j++;
                k++;
                continue;
            } 
            if (prev == curr) {
                i++;
                j++;
                k++;
                continue;
            }
            if (curr == next) {
                j++;
                k++;
                if (k < A.size()) counter++;
                continue;
            }
        } while(k < A.size());
        return counter;
    }
}