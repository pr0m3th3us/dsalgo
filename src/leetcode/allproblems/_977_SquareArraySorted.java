package leetcode.allproblems;

import common.InputReader;
import org.apache.commons.lang3.ArrayUtils;

public class _977_SquareArraySorted {

    public static void main(String[] args) {
        System.out.println(ArrayUtils.toString(
                new _977_SquareArraySorted().sortedSquares(InputReader.readIntArray())
                )
        );
    }
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int l = 0;
        int r = n - 1;
        int i = n - 1;
        while (l <= r) {
            int left = nums[l] * nums[l];
            int right = nums[r] * nums[r];
            if (left > right) {
                result[i--] = left;
                l++;
            } else {
                result[i--] = right;
                r--;
            }
        }
        return result;
    }
}
