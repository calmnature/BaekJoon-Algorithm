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
            - visited[N] 배열과 arr[M] 배열이 핵심
    * */
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] sequence; // 수열의 배열
    static boolean[] visited; // 방문 확인 배열
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream((br.readLine().split(" "))).mapToInt(Integer::parseInt).toArray();
        N = input[0]; M = input[1];
        visited = new boolean[N]; sequence = new int[M];
        DFS(0);
        System.out.println(sb);
    }

    private static void DFS(int depth) {
        if(depth == M) { // 재귀의 깊이가 수열의 길이와 같아졌다면
            Arrays.stream(sequence).forEach(num -> sb.append(num).append(" "));
            sb.append("\n");
            return;
        }

        IntStream.range(0, visited.length)
                .filter(i -> !visited[i])
                .forEach(i -> {
                    visited[i] = true;
                    sequence[depth] = i+1;
                    DFS(depth + 1);
                    visited[i] = false;
                });
    }
}
