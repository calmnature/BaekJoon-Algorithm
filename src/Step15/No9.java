package Step15;

import java.io.*;

/*
    문제 접근
        - N개의 창문과 N명의 사람 존재
        - N번째 사람은 N의 배수 창문을 열거나 닫음
        - 처음엔 모든 창문이 닫혀있음
            - Ex) N = 3
            - 1번째 사람은 1, 2, 3창문을 열음 (1, 1, 1)
            - 2번째 사람은 2번 창문을 닫음 (1, 0, 1)
            - 3번째 사람은 3번 창문을 닫음 (1, 0, 0)
            - 따라서, 마지막에 열린 창문의 개수는 1개
        입력
            - 첫째 줄 : 창문의 수와 사람의 수 N (1 <= N <= 2,100,000,000)
        출력
            - 마지막에 열려 있는 창문 개수 출력
* */
public class No9 {
    /*
        문제 해결
            - int의 범위는 21억 4748만 ~~ 이기 때문에 long을 굳이 쓰지 않아도 됨
            - boolean[] window로 21억개의 에라토스테네스의 해를 사용하려 하였는데 예상했던 대로 메모리 부족 발생
            - 단순 산술 연산 같은 식이 필요할 거 같아 일일히 쓰면서 규칙을 찾음
            - 1 ~ 20까지 했을 때 1, 4, 9, 16
            - 1 ~ 25까지 했을 때 1, 4, 9, 16, 25
            - 즉, n^2인 창문만 열린다는 규칙을 찾을 수 있음
            - 따라서, 1부터 N까지 제곱했을 때 N보다 작거나 같은 숫자만 카운팅하면 됨
    * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 1; i * i <= N; i++){
            cnt++;
        }

        System.out.println(cnt);
    }
}
