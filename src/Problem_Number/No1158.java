package Problem_Number;

import java.io.*;
import java.util.*;

public class No1158 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= N; i++) queue.offer(i);
        sb.append("<");

        while(!queue.isEmpty()){
            for(int i = 0; i < K; i++){
                int value = queue.remove();
                if(i == K-1) sb.append(value).append(",").append(" ");
                else queue.add(value);
            }
        }
        sb.deleteCharAt(sb.length()-1).deleteCharAt(sb.length()-1).append(">");
        System.out.println(sb);
    }
}
