package Step8;

import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int B = scan.nextInt();
        scan.close();
        StringBuilder sb = new StringBuilder();
        do {
            int remainder = N % B;
            sb.append(remainder < 10 ? remainder : String.valueOf((char)(remainder - 10 + 'A')));
            N/=B;
        }while(N != 0);
        System.out.println(sb.reverse());
    }
}
