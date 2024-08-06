package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 입력
            - 학생의 수 N, 두 학생을 비교한 횟수 M
            - M개의 줄에 작은 학생(a) 큰 학생(b)
        - 출력
            - 자신의 키가 몇 번째인지 알 수 있는 학생의 수 출력
* */
public class No2458 {
    /*
        - **문제 해결**
            - 시작이 주어지지 않았으므로 플로이드 워셜 문제
            - 배열의 자기자신은 0, 나머지는 무한대로 초기화
            - 플로이드 워셜의 점화식을 사용
            - a학생이 b학생보다 작거나 b학생이 a학생이 작다면 키를 비교할 수 있다는 의미
                - 배열[a][b] < INF || 배열[b][a] < INF라면 1씩 카운팅
                - check == N(학생 수)와 같다면 모든 학생과 직,간접적으로 연결이 되어있다는 의미로 자신의 키가 몇 번째인 지 알 수 있다는 의미
    * */
    static int N, V;
    static final int INF = 1000000;
    static int[][] heightMap;
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = parseInt(br.readLine());

        N = input[0]; V = input[1];
        heightMap = new int[N][N];
        // 배열 초기화
        for(int i = 0; i < N; i++){
            Arrays.fill(heightMap[i], INF);
            heightMap[i][i] = 0;
        }

        // 방향 그래프 입력
        for(int i = 0; i < V; i++){
            input = parseInt(br.readLine());
            int start = input[0] - 1, end = input[1] - 1;
            heightMap[start][end] = 1;
        }

        FlyodWarshall();

        System.out.println(count);
    }

    private static void FlyodWarshall(){
        // 플로이드 워셜
        for(int k = 0; k < N; k++)
            for(int s = 0; s < N; s++)
                for(int e = 0; e < N; e++)
                    heightMap[s][e] = Math.min(heightMap[s][e], heightMap[s][k] + heightMap[k][e]);

        for(int i = 0; i < N; i++){
            int check = 0;

            for(int j = 0; j < N; j++)
                // a 학생이 b학생보다 작거나 b 학생이 a학생보다 작다는 의미
                if(heightMap[i][j] < INF || heightMap[j][i] < INF) check++;

            // 즉, 모든 학생과 연결이 되어 있다면 자신의 키 순위를 알 수 있음
            if(check == N) count++;
        }
    }

    private static int[] parseInt(String str){
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
