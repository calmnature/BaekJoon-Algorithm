package Step13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    - **문제 접근**
        - 입력
            - 정렬하려는 수 N (N ≤ 1,000,000,000)
        - 출력
            - 자리수를 내림차순 정렬
* */
public class No6 {
    /*
        - **문제 해결**
            - N의 수가 10억이긴 하지만 이것은 String으로 실질적으로 10억더라도 10자리밖에 되지 않음
            - 각 자리 하나 하나를 int로 바꿔서 배열에 저장하고 내림차순 정렬
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] arr = br.readLine().toCharArray();

        Arrays.sort(arr);

        for(int i = arr.length - 1; i >= 0; i--)
            sb.append(arr[i]);

        System.out.println(sb);
    }
}
