package Problem_Number;

import java.util.Scanner;

/*
    - **문제 접근**
        - 입력 ⇒ 최대 10^5개의 숫자로 구성된 값을 입력 받음
        - 출력 ⇒ 30의 배수 중 최댓값을 출력, 30의 배수가 아니라면 -1
* */
public class No10610 {
    /*
        - **문제 해결**
            - 30의 배수이기 위해서는 반드시 0이 한 개 필요
            - 각 자리 수의 합이 3의 배수가 아니라면 30의 배수가 될 수 없음
            - 내림차순으로 문자열을 재구성
    * */
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] charArr = str.toCharArray();

        int sum = 0; // 각 자리수의 합
        int[] counting = new int[10]; // 0~9까지 개수 카운팅

        for(char ch : charArr){
            // char를 int 숫자로 변환
            int value = ch - '0';
            // 각 자릿수 합에 누적
            sum += value;
            // 해당 숫자의 index의 값 1증가
            counting[value]++;
        }

        // 0이 한개도 없거나, 각 자릿수의 합이 3의 배수가 아니라면 30의 배수가 아님
        if(!str.contains("0") || sum % 3 != 0){
            System.out.println(-1);
            return;
        }

        // int 배열의 마지막 부터 (내림차순)
        for(int i = 9; i >= 0; i--)
            // 인덱스의 값이 0이 아니라면
            while (counting[i]-- > 0)
                // 값 추가
                sb.append(i);

        System.out.println(sb);
    }
}
