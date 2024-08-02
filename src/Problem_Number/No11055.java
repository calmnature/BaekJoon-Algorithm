package Problem_Number;

import java.io.*;
import java.util.*;
/*
     - **문제 접근**
         - 입력
            - 수열의 개수
            - 수열
         - 출력
            - 가장 큰 수열의 합
 */
public class No11055 {
    /*
        - 가장 긴 감소하는 수열 문제와 크게 다르지 않음
        - dp에는 자기 자신의 숫자로 초기화
        - 현재의 인덱스가 기존의 인덱스보다 클 경우 dp[i] = dp[i]와 dp[j] + 현재값 중 큰 값
            - dp 배열에는 다음과 같이 초기화
            1 100 2 50 60 3 5 6 7 8
            - 100을 기준 / 1 < 100 ⇒ dp[1] = max(100, 1 + 100)
            - 2를 기준 / 1 < 2 ⇒ dp[2] = max(2, 1 + 2)
                - 100 > 2 ⇒ 무시
            - 50을 기준 / 1 < 50 ⇒ dp[3] = max(50, 1 + 50)
                - 100 > 50 ⇒ 무시
                - 2 < 50 ⇒ dp[4] = max(51, 2 + 51)
            - 60을 기준 / 1 < 60 ⇒ dp[4] = max(60, 1 + 60)
                - 100 > 60 ⇒ 무시
                - 2 < 60 ⇒ dp[4] = max(61, 2 + 60)
                - 50 < 60 ⇒ dp[4] = max(63, 53 + 60)
    * */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] sequence = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[size];

        // dp는 수열의 숫자로 초기화
        System.arraycopy(sequence, 0, dp, 0, dp.length);

        for(int i = 1; i < size; i++){
            for(int j = 0; j < i; j++){
                // j 수열의 값이 현재 수열의 값보다 작다면
                if(sequence[j] < sequence[i]){
                    // 현재 오름차순 수열의 합 vs j에 있는 오름차순 수열의 합 + 현재 값 중 큰 값
                    dp[i] = Math.max(dp[i], dp[j] + sequence[i]);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
