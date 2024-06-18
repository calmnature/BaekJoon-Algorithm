package Step8;

import java.util.Scanner;

public class No7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        int V = scan.nextInt();
        scan.close();
        int day = (V - B) / (A - B);
        int remainder = (V - B) % (A - B);
        if(remainder != 0)
            day++;
        System.out.println(day);
    }
}
