package Step13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    - **문제 접근**
        - 입력
            - 첫번째 줄
                - 응시자수 N (1 < N < 1000)
                - 상을 받는 사람 수 k (1 ≤ k ≤ N)
            - 두번째 줄
                - 각 학생의 점수 x (0 ≤ x ≤ 10000)
        - 출력
            - 상을 받는 커트라인 점수 출력
* */
public class No3 {
    /*
        - **문제 해결**
            - 응시자수는 최대 999명으로 시간의 복잡도가 O(n^2)인 정렬 알고리즘도 사용 가능
            - 정렬 후 N - k번째 점수 출력
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = getArray(br.readLine());
        int N = input[0], k = input[1];
        int[] scoreArr = getArray(br.readLine());
        br.close();

        Arrays.sort(scoreArr);

        System.out.println(scoreArr[N - k]);
    }

    private static int[] getArray(String str) {
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
