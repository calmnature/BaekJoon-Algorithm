package Step19;

import java.io.*;
import java.util.*;
/*
    문제 접근
        - 입력
            - 첫째 줄 : N (1 <= N <= 2017)
        - 출력
            - 상의와 하의가 다른 서로 다른 색상의 조합 가짓수 출력
* */
public class No1 {
    /*
        - 문제 해결
            - N * N의 2차원 배열로 나타냄
            - N = 3 이라고 했을 때 i == j가 동일하면 0, 동일하지 않으면 1
            - 배열의 총 합 = 서로 다른 색상의 조합 가짓수
    * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] combination = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i != j) combination[i][j]++;
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++){
            cnt += Arrays.stream(combination[i]).sum();
        }

        System.out.println(cnt);
    }
}
