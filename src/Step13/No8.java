package Step13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    - **문제 접근**
        - 입력
            - 좌표의 개수 N (1 ≤ N ≤ 100,000)
            - N개의 줄만큼 x좌표와 y좌표
        - 출력
            - 좌표 정렬 결과 출력
* */
public class No8 {
    /*
        - **문제 해결**
            - 이전 문제와 동일한 문제이나, y좌표를 오름차순 정렬
            - y좌표가 동일하다면 x좌표를 오름차순 정렬
            - 이번에는 클래스가 아닌 2차원 배열로 풀이
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++){
            int[] input = getCoordinate(br.readLine());
            arr[i][0] = input[0];
            arr[i][1] = input[1];
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        for(int[] coordinate : arr)
            sb.append(coordinate[0]).append(" ").append(coordinate[1]).append("\n");

        System.out.println(sb);
    }

    private static int[] getCoordinate(String str) {
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
