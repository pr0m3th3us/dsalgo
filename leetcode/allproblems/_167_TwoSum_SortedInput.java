package leetcode.allproblems;

import common.InputReader;
import org.apache.commons.lang3.ArrayUtils;

public class _167_TwoSum_SortedInput {
    public static void main(String[] args) {
        int[] nums = InputReader.readIntArray();
        int[] result = new _167_TwoSum_SortedInput().twoSum(nums, 2);
        System.out.println(ArrayUtils.toString(result));
    }
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n - 1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) return new int[] {left + 1, right + 1};
            else if (sum < target) left++;
            else right--;
        }
        return  new int[] {-1, -1};
    }
}
