package Step12;

import java.util.Scanner;

public class No6 {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.close();
        int count = -1;
        if(N % 5 == 0){
            count = N / 5;
        } else {
            int quotient = N / 5;
            for(int i = quotient; i >= 0; i--){
                int remainder = N - (i * 5);
                if(remainder % 3 == 0){
                    count = i + remainder/3;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
