package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1748 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = 1, end = 9, sum = 0, length = 1;
        while(start <= N){ // 시작값이 N 이하일 때만 실행
            if(N < end) // N이 end보다 작으면, start ~ N까지의 길이만 구함
                sum += (N - start + 1) * length;
            else // N이 end보다 크다면 start ~ end의 모든 숫자 개수 * 길이
                sum += (end - start + 1) * length;
            start *= 10;
            end = end * 10 + 9;
            length++;
        }
        System.out.println(sum);
    }
}
