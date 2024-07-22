package Problem_Number;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

/*
    - **문제 접근**
        - 대표적인 백트래킹의 DFS 문제
        - boolean 배열을 이용하여 모든 경우의 수를 탐색
* */
public class No15649 {
    /*
        - **문제 해결**
            - 1 ~ N개의 수에서 길이가 M인 수열을 공백으로 출력
            - visited[N] 배열을 이용하여 방문 여부를 확인
    * */
    static StringBuilder sb = new StringBuilder();
    static int numCount, length;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream((br.readLine().split(" "))).mapToInt(Integer::parseInt).toArray();
        numCount = input[0]; length = input[1];
        visited = new boolean[numCount]; // 방문 여부를 확인할 배열
        arr = new int[length]; // 꽉 차면 출력할 배열
        DFS(0);
        System.out.println(sb);
    }

    private static void DFS(int depth){
        // 깊이와 길이가 같아졌다 => 배열이 꽉 찼다
        if(depth == length){
            Arrays.stream(arr).forEach(num -> sb.append(num).append(" "));
            sb.append("\n");
            return;
        }

        IntStream.range(0, numCount) // 0 ~ numCount - 1까지 반복
                .filter(i -> !visited[i]) // 방문하지 않았다면 실행
                .forEach(i -> {
                    visited[i] = true; // 방문한 것으로 체크
                    arr[depth] = i + 1; // 현재 깊이의 방 번호에 값 추가
                    DFS(depth + 1); // 깊이를 1 늘려 재귀 호출
                    visited[i] = false; // 재귀가 끝나면 i번 방의 방문을 false로 변경
                });
    }
}
