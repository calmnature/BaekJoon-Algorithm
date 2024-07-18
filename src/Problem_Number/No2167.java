package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    - 첫째줄에는 2차원 배열의 크기가 주어짐 (N행 M열)
    - 둘째줄에는 2차원 배열의 값이 주어짐
    - 셋째줄에는 합을 구할 케이스가 주어짐
    - 넷째줄부터 누적 합을 할 좌표 가 주어짐[i , j] ~ [x, y]
    - 배열의 합이 2$^3$$^1$-1이하 이므로 int로 표현 가능
* */
public class No2167 {
    public static void main(String[] args) throws Exception{
        // start X ~ end X, startY ~ endY 이중 반복문으로 해결
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                A[i][j] = Integer.parseInt(st.nextToken()); // 배열 값 초기화
            }
        }
        int K = Integer.parseInt(br.readLine());
        for(int k = 0; k < K; k++){
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken()), startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken()), endY = Integer.parseInt(st.nextToken());
            int sum = 0;
            for(int i = startX; i <= endX; i++){
                for(int j = startY; j <= endY; j++){
                    sum += A[i][j];
                }
            }
            System.out.println(sum);
        }
    }
}
