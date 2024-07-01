package Step10;

import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int res = scan.nextInt();
        res *= scan.nextInt();
        scan.close();
        System.out.println(res);
    }
}
