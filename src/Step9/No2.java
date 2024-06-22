package Step9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int T = scan.nextInt();
        scan.close();
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= (int)Math.sqrt(N); i++){
            int j = N/i;
            if(N % i == 0){
                if(!list.contains(i))
                    list.add(i);
                if(!list.contains(j))
                    list.add(j);
            }
        }
        Collections.sort(list);
        System.out.println(list);
        System.out.println(list.size() < T ? "0" : list.get(T-1));
    }
}
