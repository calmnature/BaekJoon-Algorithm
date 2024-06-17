package Step8;

import java.util.Scanner;

public class No3 {
    private static final int[] coin = new int[]{25, 10, 5, 1};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = scan.nextInt();
        for(int i = 0; i < T; i++){
            int money = scan.nextInt();
            for(int j = 0; j < coin.length; j++){
                sb.append(money/coin[j]);
                money %= coin[j];
                if(j + 1 != coin.length)
                    sb.append(" ");
            }
            sb.append("\n");
        }
        scan.close();
        System.out.println(sb);
    }
}
