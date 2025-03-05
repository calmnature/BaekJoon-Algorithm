package Step21;

import java.io.*;

/*
    - 문제 접근
        - 0과 1부터 시작하고 2번째 수부터는 앞의 두 수를 더한 값
        - 입력
            자연수 n ( 0 <= n <= 20)
        - 출력
            n번째 피보나치 수
* */
public class No2 {
    /*
        - 문제 해결
            - 아래의 표를 보면 n = (n - 1) + (n - 2)의 공식이 생김﻿
            - 종료 조건
                n = 1이면 return 1
                n = 0이면 return 0
    * */
    static int[] fiboArr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fiboArr = new int[n+1];
        if(n >= 1) {
            fiboArr[1] = 1; // 만약 n = 0이면 에러가 발생하여 조건문 추가
        }
        fibonacci(n);
        System.out.println(fiboArr[n]);
    }

    private static void fibonacci(int n) {
        for(int i = 2; i <= n; i++) {
            fiboArr[i] = fiboArr[i - 1] + fiboArr[i - 2];
        }
    }
}
