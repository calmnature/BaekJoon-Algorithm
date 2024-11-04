package Step15;

import java.io.*;
/*
    문제 접근
        입력
            - 첫째 줄, 둘째 줄 : 각 분수의 분자와 분모가 주어짐 '분자 분모'
            - 네 자연수는 30,000이하
        출력
            - 첫째 줄 : 구하고자하는 기약분수의 분자와 분모를 출력
*/
public class No3 {
    /*
        문제 해결
            - 분모의 최소공배수를 구함
            - 최소공배수 / 첫째 줄 분모 = A
            - 최소공배수 / 둘째 줄 분모 = B
            - (첫째 줄 분자 * A) + (둘째 줄 분자 * B) = 기약분수 분자
            - 최소공배수 = 기약분수 분모
     */
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long childA = Integer.parseInt(input[0]), parentA = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        long childB = Integer.parseInt(input[0]), parentB = Integer.parseInt(input[1]);

        long parentRF = lcm(parentA, parentB);
        long childRF = (childA * parentRF / parentA) + (childB * parentRF / parentB);
        long gcd = gcd(parentRF, childRF);

        sb.append(childRF/gcd).append(" ").append(parentRF/gcd);
        System.out.println(sb);
    }

    private static long gcd(long a, long b){
        return b == 0 ? a : gcd(b, a % b);
    }

    private static long lcm(long a, long b){
        return a * b / gcd(a, b);
    }
}
