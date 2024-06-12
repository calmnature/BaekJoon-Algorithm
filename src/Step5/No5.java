package Step5;

import java.util.Scanner;

public class No5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        String str = scan.nextLine();
        scan.close();
        int res = 0;
        for(int i = 0; i < N; i++){
            res += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        System.out.println(res);
    }
}