package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 마법의 뿅망치를 사용해서 센티보다 키를 작게 할 수 있는지 판단하는 프로그램
        - 단, 1보다 작아질 수 없음
        - 입력
            - 첫째줄 ⇒ 거인의 인구수 N / 센티의 키 H / 마법의 뿅망치 횟수 T
            - 둘째줄 ~ N+1번째줄 ⇒ 거인의 키
        - 출력
            - 가능 ⇒ YES / 마법의 망치 사용 횟수
            - 불가능 ⇒ NO / 제일 큰 거인의 키
* */
public class No19638 {
    /*
        - **문제 해결**
            - 최대 힙으로 간단히 풀 수 있는 문제
            - 최대 힙의 값이 센티보다 크다면 마법의 망치 사용 횟수 1 감소 → 최대 힙 / 2한 값을 다시 추가
            - 최대 힙의 값이 센티보다 작거나, 마법의 망치 사용 횟수가 0이면 종료
    * */
    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int population = input[0], centi = input[1], magicHammer = input[2];

        for(int i = 0; i < population; i++) maxHeap.add(Integer.parseInt(br.readLine()));

        int useCount = 0;
        for(int i = 0; i < magicHammer; i++){
            int maxGiant = maxHeap.peek();
            if(maxGiant == 1) break; // 최대 힙이 1일 경우 종료
            if(centi <= maxGiant){
                maxHeap.add(maxHeap.remove()/2);
                useCount++;
            } else break; // cecnti보다 키가 작아지면 종료
        }

        if(centi > maxHeap.peek()) sb.append("YES").append("\n").append(useCount);
        else sb.append("NO").append("\n").append(maxHeap.peek());

        System.out.println(sb);
    }
}
