package scaler.week3.primeNosAndPrimeFactorization.assignment;

import java.util.ArrayList;

import common.InputReader;

/**
 * Prime Factors
Problem Description

You are given a Task as described below :
You are given A queries. For each query (1<=i<=A) you are given a prime number B[i], you need to give the count of all numbers in range 1 to 10^6 inclusive which have minimum prime factor B[i] for each query.



Problem Constraints
1 <= A <= 105
1 <= B[i] <= 106



Input Format
The first argument consists of an integer A, the number of queries.
The second argument consists of an array B of size A.



Output Format
Return an array which contains the count of all numbers in range 1 to 106 (inclusive), which have minimum prime factor B[i] for each query.



Example Input
 A = 1
 B = [11]


Example Output
 20779


Example Explanation
 The numbers with minimum prime factor as 11 are: 11, 121, 143, ...
 */
public class Question3 {
    private static final int MAX = 1000000;
    private static final boolean[] isPrime = new boolean[MAX + 1];
    private static final int[] count = new int[MAX + 1];

    static {
        fill();
    }

    private static final void fill() {
        for (int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
            count[i] = 0;
        }
        
        isPrime[2] = true;

        for (int i = 2; i <= MAX; i++) {
            for (int j = 2; i * j <= MAX; j++) {
                int index = i * j;
                if (isPrime[index]) {
                    isPrime[index] = false;
                    count[i]++;
                }
            }
        }

        for (int i = 0; i <= MAX; i++) {
            if (isPrime[i]) {
                count[i]++;
            }
        }
    }

    public static void main(String[] args) {
        InputReader file = InputReader.open();
        int A = file.nextInt();
        ArrayList<Integer> B = file.nextIntArraylist();
        file.close();
        System.out.println(new Question3().solve(A, B));
    }
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i : B) {
            ret.add(count[i]);
        }
        return ret;
    }
}
