package leetcode.allproblems;

import common.InputReader;

public class _278_BadVersion {
    public static void main(String[] args) {
        System.out.println(
            new _278_BadVersion().firstBadVersion(
                InputReader.readInt()
            )
            );
    }
    public int firstBadVersion(int n) {
        int i = 1;
        int j = n;
        while(i <= j) {
            int mid = (i + j) / 2;
            if (isBadVersion(mid) && j != mid) {
                j = mid;
            } else if (i != mid) {
                i = mid;
            } else break;
        }

        return j;
    }

    boolean isBadVersion(int version) {
        int max = 1702766719;
        return version >= max;
    }
}
