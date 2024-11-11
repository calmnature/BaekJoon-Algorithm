package Step16;

import java.io.*;
import java.util.*;

/*
    문제 접근
        - 1 ~ N명의 사람이 원으로 앉음
        - 순서대로 K 번째 사람 제거
        - 한 사람이 제거 되면 남은 사람들로 원을 만들어 반복
        - Ex) (N, K) 요세푸스 순열 - (7, 3)
            - 원 : 1, 2, 3, 4, 5, 6, 7
            - 제거 : 1, 2, X, 4, 5, 6, 7
            - 제거된 순서 : 3
            - 제거 : 1, 2, X, 4, 5, X, 7
            - 제거된 순서 : 3, 6
            - 제거 : 1, X, X, 4, 5, X, 7
            - 제거된 순서 : 3, 6, 2
            - 제거 : 1, X, X, 4, 5, X, X
            - 제거된 순서 : 3, 6, 2, 7
            - ...
            - 제거된 순서 : 3, 6, 2, 7, 5, 1, 4
        - 입력
            - 첫째 줄 : N과 K (1 <= K <= N <= 1,000)
        - 출력
            - 요세푸스 순열 출력
* */
public class No8 {
    /*
        문제 해결
            - 1 ~ N까지 Queue 데이터 추가
            - index = 1 선언
            - Queue가 빌 때까지 다음을 반복
                - Queue를 poll()하고 index가 3이 아니면 add()
                - index가 3이면 StringBuilder에 추가 및 index = 1으로 초기화
    * */
    public static void main(String[] args) throws IOException{
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        for(int i = 0; i < N; i++) queue.add(i + 1);

        int idx = 1;
        sb.append("<");
        while(!queue.isEmpty()) {
            int data = queue.poll();
            if(idx != K) {
                queue.add(data);
                idx++;
            }else {
                sb.append(data);
                if(!queue.isEmpty()) sb.append(",").append(" ");
                idx = 1;
            }
        }
        sb.append(">");

        System.out.println(sb);
    }
}
