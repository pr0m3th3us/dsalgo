package selfpractice.twopointers;

import common.InputReader;

public class RainwaterTrapping {
    public static void main(String[] args) {
        System.out.println(new RainwaterTrapping().trap(
            InputReader.readIntArray()
        ));
    }

    public int trap(int[] array) {
        int n = array.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        int max = 0;
        for (int i = 0 ; i < n - 1; i++) {
            max = Math.max(max, array[i]); 
            leftMax[i] = max;
        }
        max = 0;
        for (int i = n - 1 ; i >= 0; i--) {
            max = Math.max(max, array[i]); 
            rightMax[i] = max;
        }
        max = 0;
        for (int i = 0 ; i < n - 1; i++) {
            max += Math.min(leftMax[i], rightMax[i]) - array[i];
        }
        return max;
    }
}
