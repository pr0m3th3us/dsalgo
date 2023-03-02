package leetcode.allproblems;

public class _704_BinarySearch {
    public static void main(String[] args) {
        System.out.println(new _704_BinarySearch().search(
            new int[] {
                2, 5
            }, 
            -5)
        );
    }

    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while(i <= j) {
            int mid = (i + j)/2;
            int val = nums[mid];
            if (target < val && j != mid) {
                j = mid;
            } else if (target > val && i != mid) {
                i = mid;
            } else if (target == val) {
                return mid;
            } else {
                break;
            }
        }
        if (nums[j] == target) return j;
        return -1;
    }
}
