package Problem_Number;

import java.io.*;

/*
    - **문제 접근**
        - 입력
            - 레벨의 수 N (1 ~ 100)
            - 클리어 시 점수 (1 ~ 19,999)
            - 항상 답이 존재하는 경우만 주어짐
        - 출력
            - 점수를 몇 번 감소 시키면 되는 지 출력
* */
public class No2847 {
    /*
        - **문제 해결**
            - 점수 1 감소 시 1씩 카운트
            - 가장 마지막을 시작으로 마지막 - 1이 마지막보다 작아지게, 마지막 -2가 마지막 - 1 보다 작아지도록 반복
    * */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int levelCount = Integer.parseInt(br.readLine());
        int[] level = new int[levelCount];

        for(int i = 0; i < levelCount; i++)
            level[i] = Integer.parseInt(br.readLine());

        int count = 0;
        // 가장 마지막부터 시작해서 다음인덱스보다 현재 인덱스가 더 작아지도록 설정
        for(int i = level.length - 2; i >= 0; i--){
            while(level[i] >= level[i+1]){
                level[i]--;
                count++;
            }
        }

        System.out.println(count);
    }
}
