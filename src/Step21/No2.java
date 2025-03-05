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
        fiboArr = new int[n + 1];
        int result = fibonacci(n);
        System.out.println(result);
    }

    private static int fibonacci(int n) {
        if(n <= 1) return n; // 1이하라면 그대로 n 그대로 반환
        if(fiboArr[n] != 0) return fiboArr[n]; // 이미 계산된 값이면 그대로 반환
        return fiboArr[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
