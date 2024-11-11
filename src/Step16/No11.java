package Step16;

import java.io.*;
import java.util.*;
/*
    문제 접근
        - 입력
            - 첫째 줄 : queuestack의 자료 구조 개수 N (1 <= N <= 100,000)
            - 둘째 줄 : 길이 N의 수열 A, 0 = Queue, 1 = Stack
            - 셋째 줄 : 길이 N의 수열 B, Bi는 i번 자료구조에 들어가있는 원소 (1 <= Bi <= 1,000,000,000)
            - 넷째 줄 : 삽입할 수열의 길이 M (1 <= M <= 100,000)
            - 다섯째 줄 : 길이 M의 삽입할 원소 수열 C (1 <= Ci <= 1,000,000,000)
        - 출력
            - 수열 C의 원소를 차례대로 queuestack에 삽입했을 때 리턴 값을 한 줄에 출력
 */
public class No11 {
    /*
    문제 해결
        - 대로 적용하게 되면 삽입할 원소 길이 M번 만큼 반복 내부에 자료 구조 개수 N번 만큼 반복의 2중 for문이 나오게 되는데, N과 M은 최대 100,000이기 때문에 100000^2 = 100억으로 시간 초과가 나오게 됨
        - Stack은 push & pop을 하면 결국 들어간 데이터와 나온 데이터가 동일하기 때문에 Stack을 무시해도 됨
        - 첫번째 Queue(1)과 마지막 Queue(4)만 놓고 규칙을 탐색하면 다음의 규칙을 발견
        - 새로운 원소 삽입 → 첫번째 Queue의 front가 이 네 번째 원소에 추가되고, 네 번째 원소의 front가 출력
        - 위의 것을 Deque로 구현하면 3번째 줄 수열 B를 Queue인 경우에만 처리(Deque에 추가)
        - 5번째 줄에서 원소를 추가할 때 Deque.addFirst()를 하고, Deque.pollLast()를 하게 되면 원하는 결과가 출력
    * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 첫째 줄
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        // 둘째 줄
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 셋째 줄
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i = 0; i < N; i++){
            if(A[i] == 0) deque.add(B[i]);
        }
        // 넷째 줄
        int M = Integer.parseInt(br.readLine());
        // 다섯째 줄
        int[] C = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 로직
        for(int i = 0; i < M; i++){
            int data = C[i];
            deque.addFirst(data);
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb);
    }
}
