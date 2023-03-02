package scaler;

import common.InputReader;

public class AddBinaryStrings {
    public static void main(String[] args) {
        String[] lines = InputReader.readStringArray(2);
        System.out.println(addBinary(lines[0], lines[1]));
    }
    public static String addBinary(String A, String B) {
        char[] cA = A.toCharArray();
        char[] cB = B.toCharArray();
        int len = Math.max(cA.length, cB.length);
        boolean[] a = toBoolean(cA, len);
        boolean[] b = toBoolean(cB, len);
        boolean[] sum = new boolean[len];
        boolean carry = false;
        for (int i = len - 1; i >= 0; i--) {
            if (!carry) {
                if (a[i] ^ b[i]) sum[i] = true;
                else if (a[i] && b[i]) carry = true;
            } else {
                if (a[i] && b[i]) {
                    sum[i] = true;
                } else if (!(a[i] || b[i])) {
                    sum[i] = true;
                    carry = false;
                }
                
            }
        }
        String ret = toString(sum);
        
        return carry ? 1 + ret : ret;
    }

    private static boolean[] toBoolean(char[] arr, int len) {
        boolean[] ret = new boolean[len];
        for (int i = arr.length - 1, j = len - 1; i >= 0; i--, j--) {
            ret[j] = arr[i] == '1';
        }
        return ret;
    }

    private static String toString(boolean[] arr) {
        String ret = "";
        for(boolean b : arr) {
            ret += b ? "1" : "0";
        }
        return ret;
    }
}
