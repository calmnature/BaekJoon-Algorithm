package Step11;

import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String tmpN = scan.next();
        scan.close();
        int N = Integer.parseInt(tmpN);
        int constructor = 0;
        int start = N - (tmpN.length() * 9);
        for(int i = start; i < N; i++){
            int sum = i;
            int tmp = i;
            while(tmp > 0){
                sum += tmp % 10;
                tmp /= 10;
            }
            if(sum == N){
                constructor = i;
                break;
            }
        }
        System.out.println(constructor);
    }
}
