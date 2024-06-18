package Step8;

import java.util.Scanner;

public class No6 {
    private static int N, hap = 0, start = 0, end = 1, n = 1;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        if(N == 1){
            System.out.println("1/1");
            return;
        }
        scan.close();
        calc();
        String res = "";
        res = hap % 2 == 0 ? increment() : decrement();
        System.out.println(res);
    }

    private static void calc() {
        while(N > end){
            n++;
            end += n;
        }
        start = end - n + 1;
        hap = n + 1;
    }

    private static String increment(){
        int child = hap - 1;
        int parent = hap - child;
        while(start != N){
            start++; child--; parent++;
        }
        return child + "/" + parent;
    }

    private static String decrement(){
        int parent = hap - 1;
        int child = hap - parent;

        while(start != N){
            start++; child++; parent--;
        }
        return child + "/" + parent;
    }
}
