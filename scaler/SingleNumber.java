package scaler;

import java.util.List;

import common.InputReader;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(InputReader.readIntArraylist()));
    }

    public static int singleNumber(final List<Integer> A) {
        int ret = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            ret = ret ^ A.get(i);
        }
        return ret;
    }
}
