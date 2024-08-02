package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 입력
            - 테스트 케이스 T
            - T개만큼의 N
        - 출력
            - P(N)에 대한 결과 출력
* */
public class No9461 {
    /*
        - **문제 해결**
            - 규칙을 따라가다보면 1~5번째까지는 고정된 숫자이고, 6번째부터는 (i - 1)번째 값 + (i - 5)번째의 값이 i의 결과로 나타남
            - dp[i] = dp[i-1] + dp[i-5]의 점화식을 구할 수 있음
            - 단 int 배열로 출력하다보면 값이 엄청나게 커져서 int 범위 초과로 (-)가 등장
                → long 배열 필요
    * */
    static long[] padoSequence;
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        padoSequence = new long[101];

        setPadoSequence();

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            sb.append(padoSequence[N]).append("\n");
        }

        System.out.println(sb);
    }

    private static void setPadoSequence(){
        padoSequence[1] = 1; padoSequence[2] = 1; padoSequence[3] = 1; padoSequence[4] = 2; padoSequence[5] = 2;
        for(int i = 6; i <= 100; i++){
            padoSequence[i] = padoSequence[i-1] + padoSequence[i - 5];
        }
    }
}
