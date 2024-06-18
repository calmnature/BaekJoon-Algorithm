package Step8;

import java.util.Scanner;

public class No4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println((int)Math.pow((1 + Math.pow(2,scan.nextInt())), 2)); // 한 줄 정리
//        int N = scan.nextInt();
        scan.close();
//        int bottom = (int)(1 + Math.pow(2, N));
//        int square = (int)Math.pow(bottom,2);
//        System.out.println(square);
    }
}
