package Step13;

import java.io.*;

/*
    - **문제 접근**
        - 시간 제한 : Java 11 → 3초
        - 입력
            - 입력될 숫자 N(1 ≤ N ≤ 10,000,000)
            - N개의 줄만큼 숫자 입력(10,000이하의 자연수, 중복 가능)
        - 출력
            - 오름차순으로 정렬 결과 출력
* */
public class No5 {
    /*
        - **문제 해결**
            - 시간복잡도가 O(NlogN)인 알고리즘으로 풀게 되면 1,000만 * 24 = 2.4억 ⇒ 2.4초 소요
            - Arrays.sort()를 사용하여 풀었을 때 문제가 통과되기는 하지만 이것은 Counting Sort를 사용해서 푸는 것을 의도한 것으로 예상 됨
            - 숫자의 값이 1 ~ 10,000밖에 되지 않기 때문에 메모리적으로도 시간적으로도 더 좋을 것으로 예상
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = parseInt(br.readLine());
        int[] arr = new int[10001];

        for(int i = 0; i < N; i++)
            arr[parseInt(br.readLine())]++;

        br.close();

        for(int i = 1; i <= 10000; i++){
            while(arr[i] > 0){
                sb.append(i).append("\n");
                arr[i]--;
            }
        }

        System.out.println(sb);
    }

    private static int parseInt(String str){
        return Integer.parseInt(str);
    }
}
