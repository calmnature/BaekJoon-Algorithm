package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
    * 문제 접근
    - 1부터 N까지의 배열을 생성
    - 더하는 수의 개수는 고정이 아님
* */
public class No2018 {
    /*
    - 1 ~ N까지 배열 생성
    - 시작 ~ 마지막의 합이 N을 넘을 경우 종료
        - Ex) N = 30
            - start = 14, end = 15 ⇒ 14 + 15 ⇒ 29
            - 15(end) + 16(end+1) ⇒ 31 > 30
            - 즉, 15이후 부터는 30이 만들어지는 경우가 없음
    - 투 포인터로 아래의 규칙 생성
        - 조건 : satrt + end가 N이하일 때까지
        - start ~ end의 합이 N보다 작다면 ⇒ end 1증가
        - start ~ end의 합이 N보다 크다면 ⇒ start 1증가
        - start ~ end의 합이 N과 같다면 ⇒ start, end, count 1증가
    * */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int goal = Integer.parseInt(br.readLine());
        int[] A = new int[goal + 1]; // 인덱스 0은 사용하지 않음
        int matchCount = 1;
        for(int i = 1; i < goal; i++){ // 1 ~ N까지의 배열 초기화
            A[i] = i;
        }
        int start = 1, end = 2; // 1 + 2부터 시작
        while(end < A.length){ // 마지막 인덱스가 배열 길이 이상이 되면 종료
            int sum = 0; // 누적 합 변수
            for(int i = start; i <= end; i++) sum += A[i]; // start ~ end 누적합
            if(sum < goal) end++; // 합계가 목표보다 작으면 end를 늘려 합계를 높임
            else if(sum > goal) start++; // 합계가 목표보다 클 경우 start를 늘려 합계를 줄임
            else { // 합계와 목표값이 같을 경우
                start++; end++; matchCount++; // 경우의 수 1 카운트, 시작값과 끝값을 1씩 증가
            }
            // end가 배열 길이보다 작을 때 start + end의 값이 목표보다 커지면 종료
            // 목표값이 1억일 때, 5000만 ~ 9999까지의 연산을 방지
            if(end < A.length && A[start] + A[end] > goal) break;
        }
        System.out.println(matchCount);
    }
}
