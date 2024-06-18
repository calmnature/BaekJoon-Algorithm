package Step8;

import java.util.Scanner;

public class No5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        if(N == 1){
            System.out.println(1);
            return;
        }
        scan.close();
        int layer = 1;
        int endNum = 1;
        while(N > endNum){
            endNum += 6 * layer;
            layer++;
        }
        System.out.println(layer);
    }
}
