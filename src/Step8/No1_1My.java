package Step8;

import java.util.Scanner;

public class No1_1My {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String N = scan.next();
        int B = scan.nextInt();
        scan.close();

        int[] strToInt = new int[N.length()];
        for(int i = 0; i < N.length(); i++){
            char ch = N.charAt(i);
            strToInt[i] = (ch >= '0') && (ch <= '9') ? ch - '0' : ch - 'A' + 10;
        }

        int sum=0;
        for(int i = 0; i < N.length(); i++){
            sum += strToInt[i] * (int)Math.pow(B, N.length() - i - 1);
        }
        System.out.println(sum);
    }
}
