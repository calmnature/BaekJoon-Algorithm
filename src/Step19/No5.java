package Step19;

import java.io.*;

/*
    문제 접근
        - 입력
            - 첫째 줄 : 테스트 케이스 T
            - ~ T번째 줄 : 서쪽 사이트 개수 N, 동쪽 사이트 개수 M(0 <= N <= M < 30)
        - 출력
            - 각 테스트 케이스에서 조건에 맞게 다리를 지을 수 있는 경우의 수 출력
* */
public class No5 {
    /*
    문제 해결
        - 서쪽 사이트와 동쪽 사이트가 1:1 매핑이 되어야 함 → 한 사이트가 반대편 사이트에 여러 개 다리 설치 불가
        - 서쪽 사이트 수(N) <= 동쪽 사이트 수(M)이기 때문에 결국 mCn의 조합 문제
        - 여러 개의 케이스가 주어지기 때문에 미리 dp[30][30]의 배열을 만들고, 규칙을 적용하고 2중 for문으로 점화식 사용﻿
            - dp[i][i] = 1
            - dp[i][0] = 1
            - dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]
    * */
    static final int MAX_SITE = 29;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[][] dp = new long[MAX_SITE + 1][MAX_SITE + 1];
        for(int i = 0; i <= MAX_SITE; i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for(int i = 1; i <= MAX_SITE; i++){
            for(int j = 1; j < i; j++){
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            sb.append(dp[M][N]).append("\n");
        }

        System.out.println(sb);
    }
}
