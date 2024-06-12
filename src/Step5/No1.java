package Step5;

import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int idx = scan.nextInt()-1;
        scan.close();
        System.out.println(str.charAt(idx));
    }
}
