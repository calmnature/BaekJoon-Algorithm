package Step5;

import java.util.Scanner;

public class No7_1My {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            String str = scan.nextLine();
            String[] split = str.split(" ");
            int R = Integer.parseInt(split[0]);
            String P = split[1];
            for(int j = 0; j < P.length(); j++){
                for(int k =0; k < R; k++){
                    sb.append(P.charAt(j));
                }
            }
            sb.append("\n");
        }
        scan.close();
        System.out.println(sb);
    }
}
