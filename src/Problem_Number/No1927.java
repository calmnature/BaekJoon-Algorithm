package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
    - **문제 접근**
        - 값을 입력하고, 출력 명령 시 가장 작은 값을 출력하는 문제
        - 전형적인 최소 힙 문제
        - 입력 ⇒ 연산 개수 N / 2 ~ N+1번째 줄 ⇒ 자연수 일 시 추가, 0일시 출력
            - 자연수는 2^31보다 작으므로 정확히 int의 max사이즈까지 입력 됨

                → long을 쓰지 않아도 됨

        - 출력 ⇒ 0이 주어진 횟수 만큼 출력, 비어있을 경우 0 출력
* */
public class No1927 {
    /*
        - **문제 해결**
            - 우선순위 큐로 minHeap을 선언
            - 0이 아닐 경우 추가, 0일 경우 출력 및 제거
    * */
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int commandLine = Integer.parseInt(br.readLine());

        for(int i = 0; i < commandLine; i++){
            int value = Integer.parseInt(br.readLine());
            if(value == 0){
                if(minHeap.isEmpty()) sb.append(0);
                else sb.append(minHeap.poll());
                sb.append("\n");
            }
            else minHeap.add(value);
        }

        System.out.println(sb);
    }
}
