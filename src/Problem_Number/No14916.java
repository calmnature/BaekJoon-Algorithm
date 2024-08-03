package Problem_Number;

import java.io.*;

/*
    - **문제 접근**
        - 입력
            - 거스름돈 액수 n
        - 출력
            - 거스름돈 동전의 최소 개수
            - 거슬러 줄 수 없으면 -1
* */
public class No14916 {
    /*
        - **문제 해결**
            - 주어진 동전이 2원과 5원으로 배수가 되지 않아 그리디 알고리즘은 아닌 거 같음
            - 짝수와 홀수이기 때문에 거스름돈이 5보다 작고 홀수 일 때는 거슬러 줄 수 없음
            - % 5의 나머지가 짝수일 때는 5원으로 거슬러 줄 수 있는 최대로 거슬러주고
            - % 5의 나머지가 홀수일 때는 5원으로 거슬러 줄 수 있는 최대에서 5원을 1번 덜 거슬러 줌
                → 무조건 짝수가 나옴
    * */
    static final int TWO = 2;
    static final int FIVE = 5;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int remainder = Integer.parseInt(br.readLine());
        int coin = 0;

        if(remainder < FIVE && remainder % 2 == 1){
            System.out.println(-1);
            return;
        }

        if(remainder % FIVE % 2 == 0){
            coin = remainder / FIVE;
            coin += (remainder % FIVE) / TWO;
        } else{
            coin = remainder / FIVE - 1;
            coin += (remainder % FIVE + FIVE) / TWO;
        }

        System.out.println(coin);
    }
}
