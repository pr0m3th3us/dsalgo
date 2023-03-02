package scaler.week3.primeNosAndPrimeFactorization.assignment;

public class Question2 {

    public static void main(String[] args) {
        System.out.println(new Question2().solve(40));
    }

    public int solve(int A) {
        int count = 0;
        for (int i = 1; i <= A; i++) {
            if (isLucky(i)) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println();
        return count;
    }

    private static boolean isLucky(int n) {
        if (n <= 3) return false;

        int i = 2;
        int prevDivisor = -1;
        int count = 0;

        while (n > 1 && count <= 2) {
            if (n % i == 0) {
                n /= i;
                if (prevDivisor != i) {
                    count++;
                }
                prevDivisor = i;
            } else {
                i++;
            }
        }
        return n == 1 && count == 2;
    }
}
