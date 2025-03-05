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
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = fibonacci(n);
        System.out.println(result);
    }

    private static int fibonacci(int n) {
        if(n == 0) return 0;
        else if(n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
