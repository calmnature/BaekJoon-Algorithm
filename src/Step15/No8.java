package Step15;

import java.io.*;
import java.util.*;

/*
    문제 접근
        - 골드 바흐의 추측 : 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있음
        - 두 소수의 순서만 다른 것은 같은 파티션
        입력
            - 첫째 줄 : 테스트 케이스 개수 T (1 <= T <= 100)
            - ~ T번째 줄 : 정수 N (2 < N <= 1,000,000)
            - Ex1) 6 = 3 + 3
            - Ex2) 8 = 3 + 5
            - Ex3) 10 = 3 + 7, 5 + 5
            - Ex4) 12 = 5 + 7
        출력
            - 각 테스트 케이스마다 골드바흐 파티션의 수 출력
* */
public class No8 {
    /*
        문제 해결
            - 에라토스테네스의 체로 소수를 미리 구해둠
            - n - 첫번 째 소수 = 결과가 소수라면 (O)
            - n - 두번 째 소수 = 결과가 소수가 아니라면 (X)
            - ...
            - 단, n / 2까지만 체크
                → 그렇지 않으면, 10의 경우 3+7, 5+5, 7+3으로 순서가 다른 것이 나오게 됨
    * */
    static final int LENGTH = 1_000_000;
    static boolean[] eratos = new boolean[LENGTH + 1];
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        createEratos();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T;i ++){
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;

            for(int j = 2; j <= N/2; j++){
                if(eratos[j] && eratos[N - j]){
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static void createEratos(){
        Arrays.fill(eratos, 2, LENGTH + 1, true);

        for(int i = 2; i * i <= LENGTH; i++){
            if(eratos[i]){
                for(int j = i * i; j <= LENGTH; j += i){
                    eratos[j] = false;
                }
            }
        }
    }
}
