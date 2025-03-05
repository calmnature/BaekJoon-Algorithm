package Step21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문제 접근
        - 재귀에서 가장 중요한 점은 종료하는 조건이 필수적
        - 종료 조건을 제대로 설정하지 않으면 무한 재귀에 빠지며 StackOverFlow가 발생하게 됨
        - 입력
            - 정수 N (0 <= N <= 20)
        - 출력
            - N!
* */
public class No1 {
    /*
        - 문제 해결
            - 종료 조건 : N의 값이 1이하일 경우에는 1을 return
    * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(recursive(N));
    }

    private static long recursive(int N) {
        if(N <= 1) {
            return 1;
        }
        return N * recursive(N-1);
    }
}
