package Step16;

import java.io.*;
import java.util.*;

/*
    문제 접근
        - 입력
            - 첫째 줄 : 정수 K (1 <= K <= 100,000)
            - ~ K번째 줄 : 정수 1개 (0 <= 정수 <= 1,000,000)
            - 정수가 0일 경우 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 씀
            - 정수가 0일 경우에 지울 수 있는 수는 반드시 존재
        - 출력
            - 재민이가 최종적으로 적어 낸 수의 합을 출력 (최종 합 <= 2^31 -1)
* */
public class No2 {
    /*
        문제 해결
            - 전형적인 Stack 문제
            - 0 이외의 숫자가 들어오면 Stack에 Push
            - 0이 들어올 경우 Pop
            - 최종적으로 Stack에 있는 모든 수의 합
            - 최종적으로 적은 합은 2^31-1 이므로 정확히 int 범위 이내
    * */
    public static void main(String[] args) throws IOException{
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            int number = Integer.parseInt(br.readLine());
            if(number == 0) stack.pop();
            else stack.push(number);
        }

        int sum = stack.stream().mapToInt(Integer::intValue).sum();

        System.out.println(sum);
    }
}
