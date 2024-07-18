package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    - 문제 접근
        - A[0][0] * B[0][0] + A[0][1] * B[1][0] = 1 * -1 + 2 * 0 = -1
        - A[0][0] * B[0][1] + A[0][1] * B[1][1] = 1 * -2 + 2 * 0 = -2
        - A[0][0] * B[0][2] + A[0][1] * B[1][2] = 1 * 0 + 2 * 3 = 6
        - A[1][0] * B[0][0] + A[1][1] * B[1][0] = 3 * -1 + 4 * 0 = -3
        - A[1][0] * B[0][1] + A[1][1] * B[1][1] = 3 * -2 + 4 * 0 = -6
        - A[1][0] * B[0][2] + A[1][1] * B[1][2] = 3 * 0 + 4 * 3 = 12
        - A의 행 * B의 열을 반복
* */
public class No2740 {
    /*
        - 총 반복 횟수는 N * K번
        - A[3][2] * B[2][3]을 했을 때 [3][3]의 행렬이 결과
            - 즉, A[N][M] * B[M][K] ⇒ C[N][K] 행렬 생성
        - C[0][0]에는 A[0][**0**] * B[**0**][0] + A[0][**1**] * B[**1**][0]
            - A의 뒤(열), B의 앞(행)이 동일
    * */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        for(int i = 0; i < N; i++){ // A 행렬 생성
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] B = new int[M][K];
        for(int i = 0; i < M; i++){ // B 행렬 생성
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int[][] C = new int[N][K];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < K; j++){
                for(int k = 0; k < M; k++){
                    C[i][j] += A[i][k] * B[k][j]; // A의 행 * B의 열
                }
                sb.append(C[i][j]).append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
