package Step15;

import java.io.*;
/*
    문제 접근
        입력
            - 첫째 줄 : 테스트 케이스의 개수 T(1 <= T <= 1,000)
            - ~ T번째 줄 : A와 B
        출력
            - T개의 줄에 A와 B의 최소공배수를 한 줄에 하나씩 출력
* */
public class No1 {
    /*
        문제 해결
            - 최소공배수를 구하는 방법 → A * B / 최대공약수
            - 최대공약수를 구하는 방법 (유클리드 호제법)
                - 두 수 a와 b가 있을 때, a를 b로 나눈 나머지를 구함 (r = a mod b)
                - a와 b를 b와 r로 바꾸고 1번을 반복
                - 나머지가 0이 되었을 때 b값이 최대공약수
            - ex) a = 6,  b = 15
                1. 6 mod 15 = 6 → a = 15, b =6
                2. 15 mod 6 = 3 → a = 6, b = 3
                3. 6 mod 3 = 0 → 나머지가 0이므로 마지막 b(3)이 최대 공약수
                4. a(6) * b(15) / 최대공약수(3) = 30
                5. 따라서, 6과 15의 최소공배수 30
     * */
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int r;
            int tmpA = a;
            int tmpB = b;
            while(true){
                r = tmpA % tmpB;
                if(r == 0) break;
                tmpA = tmpB;
                tmpB = r;
            }
            sb.append(a * b / tmpB).append("\n");
        }

        System.out.println(sb);
    }
}
