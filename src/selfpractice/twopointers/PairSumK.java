package selfpractice.twopointers;

public class PairSumK { //variation - diff k
    public static void main(String[] args) {
        //
    }

    int findPairsEqK(int[] arr, int k) {
        int i = 0;
        int j = arr.length - 1;
        int count = 0;
        while (i <= j) {
            int sum = arr[i] + arr[j];
            if (sum > k) j--;
            if (sum < k) i++;
            else {
                count++;
                //to do
            }
        }
        return count;
    }
}
