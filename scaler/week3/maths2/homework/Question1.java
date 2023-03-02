package scaler.week3.maths2.homework;

import common.InputReader;

/**
 * Find if two rectangles overlap
Problem Description

Given eight integers A, B, C, D, E, F, G and H which represent two rectangles in a 2D plane.
For the first rectangle it's bottom left corner is (A, B) and top right corner is (C, D) and for the second rectangle it's bottom left corner is (E, F) and top right corner is (G, H).

Find and return whether the two rectangles overlap or not.



Problem Constraints
-10000 <= A < C <= 10000

-10000 <= B < D <= 10000

-10000 <= E < G <= 10000

-10000 <= F < H <= 10000



Input Format
The eight arguments given are the integers A, B, C, D, E, F, G and H.


Output Format
Return 1 if the two rectangles overlap else return 0.


Example Input
Input 1:

A = 0   B = 0
C = 4   D = 4
E = 2   F = 2
G = 6   H = 6
Input 2:

A = 0   B = 0
C = 4   D = 4
E = 2   F = 2
G = 3   H = 3


Example Output
Ouput 1:
1
Output 2:

1


Example Explanation
Explanation 1:
rectangle with bottom left (2,2) and top right (4,4) is overlapping.
Explanation 2:

overlapping rectangles can be found
 */
public class Question1 {
    public static void main(String[] args) {
        int[] input = InputReader.readIntArray(8);
        System.out.println(solve(input[0], input[1], input[2], input[3], input[4], input[5], input[6], input[7]));
    }

    public static int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        return doOverlap(
            new Point(A, D),
            new Point(C, B),
            new Point(E, H),
            new Point(G, F)) ? 
            1 : 0;
        
    }

    static boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        if (l1.x == r1.x || l1.y == r1.y || l2.x == r2.x || l2.y == r2.y) {
            return false;
        }

        if (l1.x >= r2.x || l2.x >= r1.x) {
            return false;
        }

        "".hashCode();

        if (r1.y >= l2.y || r2.y >= l1.y) {
            return false;
        }

        return true;
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
