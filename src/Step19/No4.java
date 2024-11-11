package Step19;

import java.io.*;

/*
    문제 접근
        - 이항계수란 주어진 집합에서 원하는 개수만큼 순서없이 뽑는 조합의 개수를 의미
        - 순서가 있다는 것은 순열, 순서가 없다는 것은 조합
        - 5개 중 2개를 선택(5C2) → 5 * 4 * 3 * 2 * 1 / 3 * 2 * 1 * 2 * 1 = 120 / 12 = 조합 경우의 수는 10개
        - 입력
            - N과 K (1 <= N <= 10, 0 <= K <= N)
        - 출력
            - (5, 2) 이항 계수 출력
* */
public class No4 {
    /*
    문제 해결
        - 5개 중 2개를 선택한다는 것은 다음과 같이 볼 수 있음
            - 가장 마지막 데이터를 선택 → 이미 1개가 선택되어 4개 중 1개를 선택
            - 가장 마지막 데이터를 선택하지 않음 → 4개 중 2개를 선택
            - 즉, 5개 중 2개를 선택한 경우의 수 = 4개 중 1개를 선택한 경우의 수 + 4개 중 2개를 선택한 경우의 수
            - 점화식 : [5][2] = [4][2] + [4][1]
        - dp[N+1][N+1]의 배열을 선언
        - 이항 계수는 아래의 규칙을 가짐
            - dp[i][0] = 1
                → i개 중 0개를 선택하는 경우의 수는 1개
            - dp[i][i] = 1
                → i개 중 i개를 선택하는 경우의 수는 1개
        - i = 1 ~ N까지, j = 1 ~ i - 1까지 반복
        - dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[][] dp = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        System.out.println(dp[N][K]);
    }
}
