package leetcode.allproblems;

public class _1299_ReplaceElementsWithGreatestRightSide {
    public int[] replaceElements(int[] arr) {
        int[] ret = new int[arr.length];
        ret[arr.length - 1] = -1;
        for (int i = arr.length - 1; i > 0; i--) {
            ret[i - 1] = Math.max(ret[i], arr[i]);
        }
        return ret;
    }
}
