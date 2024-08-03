package Problem_Number;

import java.io.*;

public class No14916 {
    static final int TWO = 2;
    static final int FIVE = 5;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int remainder = Integer.parseInt(br.readLine());
        int coin = 0;

        while(remainder > 0){
            if(remainder % FIVE == 0){
                coin += remainder / FIVE;
                remainder = 0;
            } else{
                remainder -= TWO;
                coin++;
            }
        }

        if(remainder < 0)
            System.out.println(-1);
        else
            System.out.println(coin);
    }
}
