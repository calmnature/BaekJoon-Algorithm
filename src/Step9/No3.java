package Step9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class No3 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        while(true){
            int N = scan.nextInt();
            if(N == -1)
                break;
            List<Integer> list = getfactorList(N);
            int sum = list.stream().mapToInt(n -> n).sum();
            StringBuilder sb = new StringBuilder();
            if(sum == N){
                sb.append(N).append(" = ");
                for(int i = 0; i < list.size(); i++){
                    sb.append(list.get(i));
                    if(i + 1 != list.size())
                        sb.append(" + ");
                }
            } else {
                sb.append(N).append(" is NOT perfect.");
            }
            System.out.println(sb);
        }
        scan.close();
    }

    private static List<Integer> getfactorList(Integer N){
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
        list.remove(list.size()-1);
        return list;
    }
}
