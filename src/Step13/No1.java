package Step13;

import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = scan.nextInt();
        }
        scan.close();
        insertion_sort(A);
        for (int i : A) {
            System.out.println(i);
        }
    }

    private static void insertion_sort(int[] A) {
        for(int i = 1; i < A.length; i++){
            int tmp = A[i];
            for(int j = i-1; j >= 0; j--){
                if(A[j] > tmp){
                    A[j+1] = A[j];
                    A[j] = tmp;
                }
            }
        }
    }
}
