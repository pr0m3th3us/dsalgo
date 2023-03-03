package scaler;

import common.InputReader;

/**
 * NumberOf1Bits
 */
public class NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(numSetBits(InputReader.readInt()));
    }

    public static int numSetBits(int A) {
        int count = 0;
        for (char c : toBinary(A).toCharArray()) {
            if (c == '1') count++;
        }
        return count;
    }

    private static String toBinary(int a) {
        StringBuilder sb = new StringBuilder();
        if (a == 0) return "0";
        while(a > 0) {
            int rem = a % 2;
            if (rem == 1) {
                sb.append("1");
            }
            a /= 2;
        }
        return sb.toString();
    }
}