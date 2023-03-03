package leetcode.allproblems;

import common.InputReader;
import org.apache.commons.lang3.ArrayUtils;

public class _283_MoveZeroes {
    public static void main(String[] args) {
        int[] nums = InputReader.readIntArray();
        new _283_MoveZeroes().moveZeroes(nums);
        System.out.println(ArrayUtils.toString(nums));
    }
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        while(j < n) {
            while (i < n && nums[i] != 0) i++;
            j = i + 1;
            while (j < n && nums[j] == 0) j++;
            if (i < n && j < n) {
                swap(nums, i, j);
            }
            i++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
