package Step15;

import java.io.*;

/*
    문제 접근
        입력
            - 한 줄에 두 정수 A와 B가 공백으로 주어짐
            ㅍ50%의 입력 중 A와 B는 1,000(10^3)보다 작음
            - 다른 50%의 입력의 A와 B는 1,000보다 크고 100,000,000(10^8)보다 작음
            - Java는 long을 사용
        출력
            - A와 B의 최소 공배수를 한 줄에 출력
*/
public class No2 {
    /*
        문제 해결
            - 앞의 문제와 달라진 점은 A와 B가 매우 큰 값이 나올 수 있기 때문에 long을 사용해야 한다는 점
            - 결국 똑같은 최소공배수 문제이므로 이번에는 유클리드 호제법을 재귀함수로 구현해볼 것
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long a = Integer.parseInt(input[0]);
        long b = Integer.parseInt(input[1]);

        System.out.println(lcm(a, b));
    }

    private static long gcd(long a, long b){
        return b == 0 ? a : gcd(b, a % b);
    }

    private static long lcm(long a, long b){
        return a * b / gcd(a, b);
    }
}
