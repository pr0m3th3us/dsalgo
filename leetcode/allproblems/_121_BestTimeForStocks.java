package leetcode.allproblems;

import common.InputReader;

public class _121_BestTimeForStocks {
    public static void main(String[] args) {
        System.out.println(new _121_BestTimeForStocks().solve(InputReader.readIntArray(" ")));
    }

    private int solve(int[] stocks) {
        int left = 0;
        int right = 1;
        int max = 0;
        while (right < stocks.length) {
            if (stocks[left] < stocks[right]) {
                max = Math.max(stocks[right] - stocks[left], max);
            } else {
                left = right;
            }
            right++;
        }
        return max;
    }
}
