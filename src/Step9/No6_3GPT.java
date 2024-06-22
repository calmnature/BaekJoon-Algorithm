package Step9;

import java.util.Scanner;

public class No6_3GPT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.close();
        if (N > 1) {
            printPrimeFactors(N);
        }
    }

    private static void printPrimeFactors(int N) {
        // Print the number of 2s that divide N
        while (N % 2 == 0) {
            System.out.println(2);
            N /= 2;
        }

        // N must be odd at this point, so we can skip even numbers
        for (int i = 3; i <= Math.sqrt(N); i += 2) {
            // While i divides N, print i and divide N
            while (N % i == 0) {
                System.out.println(i);
                N /= i;
            }
        }

        // This condition is to check if N is a prime number greater than 2
        if (N > 2) {
            System.out.println(N);
        }
    }
}
