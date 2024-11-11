package Step19;

import java.io.*;
/*
    문제 접근
        - 입력
            - 녹색 거탑의 높이 N (1 <= N <= 5)
        - 출력
            - 녹색 거탑의 정상에서 바닥으로 내려오는 경우의 수 출력
* */
public class No2 {
    /*
        - 문제 해결
            - 바닥과 근접한 상자 1개당 2개의 경우의 수를 가짐
            - 따라서, 규칙을 보면 2^n만큼의 규칙을 보임
    * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println((int)Math.pow(2, N));
    }
}
