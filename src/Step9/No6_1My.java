package Step9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No6_1My {
    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.close();
        if(N == 1) return;
        if(N == 2){
            System.out.println("2");
            return;
        }
        addList(N);
        for(int i : list){
            System.out.println(i);
        }
    }

    private static void addList(int N){
        int i = 2;
        while(N != 0 && N != 1){
            while(N % i == 0){
                list.add(i);
                N /= i;
            }
            if(i == 2){
                i++;
            }else
                i += 2;
        }
    }
}
