package Step15;

import java.io.*;
import java.util.*;

/*
    문제 접근
        입력
            - n < 소수 <= 2n → 적어도 하나 존재 (1 <= n <= 123,456)
            - 여러 개의 테스트 케이스
            - 각 케이스는 n을 포함하는 한줄로 이루어짐
            - 입력의 마지막에는 0이 주어짐
        출력
            - 각 테스트 케이스에 대해서 n보다 크고, 2n보다 작거나 같은 소수의 개수 출력
* */
public class No7 {
    /*
        문제 해결
                - n ~ 2n 안에 포함되는 모든 소수를 출력하는 것은 n이 커졌을 때 너무 많은 비교가 필요
                - 에라토스테네스의 체를 사용하는 것이 효과적으로 보임
                - 1은 제외하고 2부터 시작하여 모든 숫자는 소수라고 가정
                - int i = 2부터 시작하여 i의 배수는 모두 제거
    * */
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = 123456 * 2;
        boolean[] eratos = new boolean[length + 1];

        Arrays.fill(eratos, 2, eratos.length, true);

        for(int i = 2; i * i <= length; i++){
            if(eratos[i]){
                for(int j = i * i; j <= length; j += i){
                    eratos[j] = false;
                }
            }
        }

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            int cnt = 0;
            for(int i = n + 1; i <= 2 * n; i++){
                if(eratos[i]) cnt++;
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
