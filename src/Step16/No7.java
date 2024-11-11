package Step16;

import java.io.*;
import java.util.*;
/*
    문제 접근
        - 1 ~ N까지의 카드가 순서대로 놓임 (가장 위 1, 가장 아래 N)
            - 1. 제일 위의 카드를 버림
            - 2. 제일 위의 카드를 맨 밑으로 옮김
            - Ex) N = 4
            - 1234 → 234 → 342 → 42 → 24 → 4(출력)
        - 입력
            - 첫째 줄 : N (1 <= N <= 500,000)
        - 출력
            - 남게되는 카드 번호 출력
* */
public class No7 {
    /*
        문제 해결
            - Queue 1부터 N까지 삽입
            - Queue의 size가 1이라면 종료
            - Queue의 size가 1이 아니라면 다음 로직 실행
                1. 맨 위의 카드 버림 → poll()
                2. 맨 위의 카드를 Queue에 다시 추가 → poll() & add()
    * */
    public static void main(String[] args) throws IOException{
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            queue.add(i + 1);
        }

        while(queue.size() != 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }
}
