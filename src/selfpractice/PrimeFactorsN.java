package selfpractice;

public class PrimeFactorsN {
    public static void main(String[] args) {
        printPrimeFactors(315);
    }

    public static void printPrimeFactors(int n) {
        int x = n;
        for(int i = 2; i < Math.sqrt(x); i++) {
            while(x % i == 0) {
                System.out.print(i + " ");
                x /= i;
            }
        }
        if (x > 2) {
            System.out.println(x);
        }
    }
}
