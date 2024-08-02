package Problem_Number;

/*
    - **문제 접근**
        - 입력
            - 수열의 크기
            - 수열
        - 출력
            - 내림차순으로 제일 긴 값을 출력
* */

import java.io.*;
import java.util.*;
public class No11722 {
    /*
        - **문제 해결**
            - Dynamic Programming으로 풀 수 있는 문제
            - 각 자리의 수열은 자기 자신을 가지기 때문에 1을 가짐 ⇒ dp 배열을 1로 초기화
                - {10} {30} {10} {20} {20} {10}
            1. dp[i]를 기준으로 0 ~ i-1까지 확인
            2. dp[i] 보다 dp[j]의 값이 더 크다면, dp[i]에 dp[i]와 dp[j] + 1 중 더 큰 값을 저장
                - 30은 자기 자신 {30}을 가져서 dp[1]에는 1이 들어가 있고, 30 앞의 10은 30보다 작으므로 {10, 30}으로 조건 불만족 → dp[1] = 1
                - 2번째 10의 앞에는 10과 30으로 10보다 큰 것은 30으로 {30, 10}이 되어 내림차순을 만족 → dp[2] = 2
                - 3번째, 4번째 20의 앞에는 10, 30, 10으로 {30, 20}을 만족하여 dp[3]과 dp[4] = 2
                - 마지막 10의 앞에는 10, 30, 10, 20, 20이 존재하고 각각의 dp에는 1, 1, 2, 2, 2가 저장
                - 현재 값보다 큰 값에는 이미 내림차순 수열의 개수가 저장
                → 따라서 큰 값의 수열 개수 + 1(현재 값을 수열에 추가) vs 현재 값 중 큰 값을 저장
    * */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] dp = new int[size];
        int[] sequence = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 1로 초기화
        Arrays.fill(dp, 1);

        for(int i = 1; i < size; i++){
            for(int j = 0; j < i; j++){
                // j번째 인덱스 수가 i번째 인덱스보다 크다면
                if(sequence[j] > sequence[i]){
                    // 현재 dp[i]의 값과 dp[j] + 1의 값 중 큰 값을 저장
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
