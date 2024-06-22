package Step9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No5 {
    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        scan.close();
        for(int i = N; i <= M; i++){
            addList(i);
        }
        if(list.isEmpty()) {
            System.out.println(-1);
            return;
        }
        int sum = list.stream().mapToInt(n -> n).sum();
        int min = list.stream().mapToInt(n -> n).min().getAsInt();
        System.out.println(sum);
        System.out.println(min);
    }

    private static void addList(int N) {
        if(N == 1) return;
        if(N == 2) {
            list.add(N);
            return;
        }
        if(N % 2 == 0) return;
        for(int i = 3; i <= Math.sqrt(N); i+=2){
            if(N % i == 0) return;
        }
        list.add(N);
    }
}
