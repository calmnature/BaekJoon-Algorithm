package Step19;

import java.io.*;
/*
    문제 접근
        - 입력
            - N (0 <= N <= 12)
        - 출력
            - N 팩토리얼 출력
* */
public class No3 {
    /*
    문제 해결
        - 문제를 푸는 방법은 2가지
        - 입력받은 N ~ 1까지 모두 곱하는 반복문 사용
        - 재귀 함수 사용
    * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(factorial(N));
    }

    private static int factorial(int N) {
        if(N <= 1) return 1;
        return N * factorial(N - 1);
    }
}
