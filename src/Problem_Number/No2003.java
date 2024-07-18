package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    * 문제의 조건
    - 시간 제한 0.5초 ⇒ 5,000만번의 연산 이내로 해결
    - 첫째줄에 숫자의 개수 N과 i~j까지의 합이 M이 되어야하는 수가 주어짐
    - i ~ j까지 더하는데, i~j의 범위가 고정되지 않음
        - 입력 예제 2의 예시
            - 1번째 경우의 수 ⇒ 2 3
            - 2번째 경우의 수 ⇒ 5
            - 3번째 경우의 수 ⇒ 3 1 1
* */
public class No2003 {
    /*
        - 투 포인터 방식으로 문제 해결
        - 최초 start와 end를 같게 시작하여 다음의 규칙 만족
        - 목표값(M)보다 start~end의 합이 작을 경우 end 1증가
        - 목표값(M)보다 start~end의 합이 클 경우 start 1 증가
        - 목표값(M)과 start~end의 합이 같을 경우 start, end 둘 다 1증가
    * */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 숫자의 개수
        int M = Integer.parseInt(st.nextToken()); // 목표값
        int matchCount = 0; // 경우의 수
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0, end = 0; // 투 포인터로 사용될 시작, 끝 변수
        while(end != A.length){ // end가 배열의 길이와 같아지면 종료
            int sum = 0;
            for(int i = start; i <= end; i++){
                sum += A[i];
            }
            if(M > sum) // 목표값이 더 크다면, end 인덱스를 늘려 sum의 값을 높임
                end++;
            else if(M < sum) // 목표값이 더 작다면, start 인덱스를 1 늘려 sum의 값을 줄임
                start++;
            else{ // 목표값과 sum이 같다면, 경우의 수를 카운팅하고 start와 end를 1씩 늘림
                start++; end++; matchCount++;
            }
        }
        System.out.println(matchCount);
    }
}
