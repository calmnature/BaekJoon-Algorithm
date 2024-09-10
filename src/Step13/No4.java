package Step13;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 입력
            - 입력될 숫자 N (1 ≤ N ≤ 1,000,000)
            - N개의 숫자 입력
        - 출력
            - 오름차순으로 정렬
* */
public class No4 {
    /*
        - **문제 해결**
            - N의 최댓값이 100만이기 때문에 시간 복잡도가 O(n^2)의 알고리즘으로 풀게 되면 1조의 연산으로 10,000초(1억의 연산 = 1초) 소요
            - 시간 복잡도가 O(NlogN)으로 풀 경우 100만 * 20 = 2,000만 ⇒ 0.2초로 시간 제한이 문제 되지 않음
            - Arrays.sort 또는 Collections.sort는 평균 시간의 복잡도가 O(NlogN)이므로 두 개의 정렬 중 선택
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = parseInt(br.readLine());
        br.close();

        Arrays.sort(arr);
        for(int num : arr)
            sb.append(num).append("\n");
        System.out.println(sb);
    }

    private static int parseInt(String str){
        return Integer.parseInt(str);
    }
}
