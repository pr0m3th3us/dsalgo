package leetcode.allproblems;

import common.InputReader;

public class _035_SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(new _035_SearchInsertPosition().searchInsert(
            InputReader.readIntArray(), 7));
    }
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while(i < j) {
            int mid = (i + j)/2;
            int val = nums[mid];
            if (val == target) return mid;
            else if (target < val) j = mid;
            else i = mid + 1;
        }
        return target > nums[j] ? j + 1 : j;
    }
}
