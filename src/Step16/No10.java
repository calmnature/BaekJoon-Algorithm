package Step16;

import java.io.*;
import java.util.*;
/*
    문제 접근
        - 규칙
            - 1 ~ N번까지의 풍선이 원형으로 놓임
            - 각 풍선에는 종이가 들어있음 ( -N <= 종이 숫자 <= N)
            - 처음에는 1번 풍선을 터트림
            - 종이를 꺼내 그 종이에 적힌 값만큼 이동하여 풍선을 터뜨림
            - 양수 = 오른쪽 / 음수 = 왼쪽
        - 입력
            - 첫째 줄 : 자연수 N(1 <= N <= 1,000)
            - 둘째 줄 : 차례대로 풍선 안의 종이 숫자가 주어짐 (단, 0은 주어지지 않음)
        - 출력
            - 터진 풍선의 번호를 차례대로 나열
* */
public class No10 {
    /*
    문제 해결
        - 1 ~ N까지 Deque에 추가
        - 종이 숫자를 N+1의 배열을 만들어 인덱스 1 ~ N까지 둘째 줄 저장
        - 덱의 첫 번째 값 StringBuilder에 추가
        - 배열[터진 풍선 번호]의 값 X 확인
        - Deque이 빌 때까지 반복
            - 양수라면, X - 1만큼 pollFirst & addLast() → pollFirst를 StringBuilder에 추가 및 X값 변경
            - 음수라면, X - 1만큼 pollLast & addFirst() → pollLast를 StringBuilder 추가 및 X값 변경
    * */
    public static void main(String[] args) throws IOException{
        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) deque.addLast(i + 1);

        int[] paper = new int[N + 1];
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.arraycopy(arr, 0, paper, 1, arr.length);

        int first = deque.pollFirst();
        int X = paper[first];
        sb.append(first).append(" ");
        while(!deque.isEmpty()) {
            int data = 0;
            for(int i = 0; i < Math.abs(X); i++){
                if(X > 0) {
                    data = deque.pollFirst();
                    if(i < X - 1) deque.addLast(data);
                } else {
                    data = deque.pollLast();
                    if(i < X * - 1 - 1)  deque.addFirst(data);
                }
            }

            sb.append(data).append(" ");
            X = paper[data];
        }

        System.out.println(sb);
    }
}
