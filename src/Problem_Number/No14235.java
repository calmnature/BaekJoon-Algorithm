package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 아이들을 만났을 때 가장 가치가 큰 선물을 준다 ⇒ **최대 힙**
        - 입력
            - 첫 번째 줄 ⇒ 아이들 or 거점지 방문 횟수 N
            - 두 번째 줄
                - 0일 경우 아이들을 만남 ⇒ 선물 증정
                - 0이 아닐 경우 거점지에서 A개만큼의 선물 충전
        - 출력
            - 아이들을 만남 ⇒ 최대 가치 선물 출력
                - 줄 선물이 없다면 -1
* */
public class No14235 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> present = new PriorityQueue<>((o1,o2) -> o2 - o1);

        int visit_count = Integer.parseInt(br.readLine());
        for(int i = 0; i < visit_count; i++){
            int[] check = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if(check[0] == 0){ // 0이라면 출력
                if(present.isEmpty()) sb.append(-1);
                else sb.append(present.poll());
                sb.append("\n");
            }else { // 0이 아니라면 거점지에서 선물 추가
                for(int j = 1; j < check.length; j++) present.offer(check[j]);
            }
        }

        System.out.println(sb);
    }
}
