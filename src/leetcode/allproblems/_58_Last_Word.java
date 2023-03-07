package leetcode.allproblems;

public class _58_Last_Word {
    public int lengthOfLastWord(String s) {
        char[] arr = s.toCharArray();
        int i = arr.length - 1;
        int cnt = 0;
        while(i >= 0 && arr[i] == ' ') {
            i--;
        }
        while(i >= 0 && arr[i] != ' ') {
            cnt++;
            i--;
        }
        return cnt;
    }
}
