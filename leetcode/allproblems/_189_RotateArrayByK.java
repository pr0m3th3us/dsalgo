package leetcode.allproblems;

import org.apache.commons.lang3.ArrayUtils;

import common.InputReader;

public class _189_RotateArrayByK {

    public static void main(String[] args) {
        int[] nums = InputReader.readIntArray();
        new _189_RotateArrayByK().rotate(nums, 2);
        System.out.println(ArrayUtils.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        //
    }

    public void doubleSwap(int[] nums, int k) {
        //
    }

    public void doubleReverse(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        //reverse all
        reverse(0, n - 1, nums);

        //reverse k
        reverse(0, k - 1, nums);

        //reverse rest
        reverse(k, n - 1, nums);
    }

    private void reverse(int l, int r, int[] nums) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
