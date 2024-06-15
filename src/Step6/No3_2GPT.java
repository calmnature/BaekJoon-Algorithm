package Step6;

import java.util.Scanner;

public class No3_2GPT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int repeat = 2 * N - 1;

        for (int i = 0; i < repeat; i++) {
            int numSpaces = Math.abs(N - 1 - i);
            int numStars = repeat - 2 * numSpaces;

            for (int j = 0; j < numSpaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < numStars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}