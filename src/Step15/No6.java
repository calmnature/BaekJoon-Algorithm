package Step15;

import java.io.*;

/*
    문제 접근
        입력
            - 첫째 줄 : 자연수 M과 N이 주어짐 (1 <= M <= N <= 1,000,000)
        출력
            - 한 줄에 하나씩 오름차순으로 소수 출력
* */
public class No6 {
    /*
        문제 해결
            - N ~ M까지 반복하여 소수 판별
            - 소수일 경우 true, 소수가 아닐 경우 false
            - 소수일 경우 StringBuilder에 추가
    * */
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);

        for(int i = N; i <= M; i++){
            if(check(i)){
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean check(int num){
        if(num == 2) return true;
        if(num == 1 || num % 2 == 0) return false;
        for(int i = 3; i * i <= num; i += 2){
            if(num % i == 0) return false;
        }
        return true;
    }
}
