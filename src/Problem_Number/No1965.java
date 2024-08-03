package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 입력
            - 상자의 개수
            - 상자의 개수만큼 상자의 크기
        - 출력
            - 한 상자에 넣을 수 있는 최대 상자 개수
* */
public class No1965 {
    /*
        - **문제 해결**
            - 1개의 상자에는 반드시 1개가 포함(자기 자신) ⇒ dp 배열을 1로 초기화
            - 현재 상자 사이즈가 dp[j] 상자 사이즈보다 크다면 dp[i] = max(dp[i], dp[j] + 1)
                - dp[j]에 몇 개의 상자가 들어있을진 모르겠지만 어찌됐든 dp[j]에는 그보다 작은 상자들이 누적되어있었을 것이기 때문
    * */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] boxSize = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N];
        // 1개의 상자에는 반드시 1개가 포함(자기 자신)
        Arrays.fill(dp, 1);

        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                // 현재 박스 사이즈보다 작으면
                if(boxSize[i] > boxSize[j]){
                    // j에 담긴 박스 사이즈 + 1과 자기 자신을 비교하여 큰 값 저장
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}