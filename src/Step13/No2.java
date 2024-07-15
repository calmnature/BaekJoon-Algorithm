package Step13;

import java.util.Arrays;
import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] A = new int[5];
        for(int i = 0; i < A.length; i++){
            A[i] = scan.nextInt();
        }
        scan.close();
        Arrays.sort(A);
        int avg = Arrays.stream(A).sum() / 5;
        System.out.println(avg);
        System.out.println(A[2]);
    }
}
