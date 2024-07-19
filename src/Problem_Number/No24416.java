package Problem_Number;

import java.util.Scanner;

public class No24416 {
    static int recursionFiboCnt = 0;
    static int dpFiboCnt = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        recursionFibo(N);
        dpFibo(N);
        System.out.println(recursionFiboCnt + " " + dpFiboCnt);
    }
    private static int recursionFibo(int n) {
        if(n == 1 || n == 2){
            recursionFiboCnt++;
            return 1;
        }
        return recursionFibo(n-1) + recursionFibo(n - 2);
    }

    private static int dpFibo(int n) {
        int[] f = new int[n+1];
        f[1] = 1; f[2] = 1;
        for(int i = 3; i <= n; i++){
            f[i] = f[i-1] + f[i-2];
            dpFiboCnt++;
        }
        return f[n];
    }

}
