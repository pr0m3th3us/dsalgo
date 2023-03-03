package scaler;

import common.InputReader;

public class TotalSetBits {
    public static void main(String[] args) {
        System.out.println(solve(InputReader.readInt()));
    }

    public static int solve(int A) {
        int res = solveR(A);
        return res % (1000000007);
    }

    private static int solveR(int n) {
        if (n == 0) return 0;
        int x = lastPower(n);
        return (x * (1 << (x - 1))) + (n + 1 - (1 << x)) + solveR(n - (1 << x));
    }

    private static int lastPower(int n) {
        int pow = 1;
        while(n >= (1 << pow)) pow++;
        return pow - 1;
    }
}
