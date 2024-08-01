package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 스위치 0 = 꺼짐 / 스위치 1 = 켜짐
        - 남학생의 스위치 번호 ⇒ 스위치 번호의 배수들의 상태 변경
            - 남학생 스위치 번호 2번 → 2, 4, 6번 스위치 상태 변경
        - 여학생의 스위치 번호 ⇒ 해당 스위치 번호를 기준으로 좌우 대칭이 되는 모든 스위치 변경
            - 여학생의 스위치 번호 3번 → 2, 4번 대칭 되는 지 확인 : O → 1, 5번 대칭 확인 : X → 2, 3, 4번 스위치 상태 변경
        - 입력
            - 스위치 개수
            - 스위치 상태
            - 학생 수
            - 성별 스위치번호
            → 남학생 1 / 여학생 2
        - 출력
            - 1번부터 스위치 상태 출력
            - 단, 1줄에 20개씩만 출력
* */
public class No1244 {
    /*
        - **문제 해결**
            - 남학생일 경우 배수로 스위치 변경 메서드
            - 여학생일 경우 대칭으로 스위치 변경 메서드
            - 한 줄에 20개씩 출력
    * */
    static int switch_count;
    static int[] switch_status;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        switch_count = Integer.parseInt(br.readLine());
        switch_status = new int[switch_count + 1];
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 스위치 상태 초기화
        for(int i = 0; i < switch_count; i++)
            switch_status[i+1] = input[i];

        int student = Integer.parseInt(br.readLine());
        for(int i = 0; i < student; i++){
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int gender = input[0], number = input[1];
            if(gender == 1) changeMale(number);
            else changeFemale(number);
        }

        for(int i = 1; i <= switch_count; i++){
            sb.append(switch_status[i]).append(" ");
            // 20개마다 개행
            if(i % 20 == 0) sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void changeMale(int switch_number){
        // 스위치 번호의 배수마다 상태 변경
        for(int i = switch_number; i <= switch_count; i+=switch_number)
            switch_status[i] = switch_status[i] == 1 ? 0 : 1;
    }

    private static void changeFemale(int switch_number){
        int start = switch_number, end = switch_number;
        // 대칭이 되는 인덱스를 구하는 로직
        while(start > 1 && end < switch_count && switch_status[start-1] == switch_status[end + 1]){
            start--;
            end++;
        }

        // 대칭이 되는 start ~ end까지 스위치 상태 변경
        for(int i = start; i <= end; i++)
            switch_status[i] = switch_status[i] == 1 ? 0 : 1;
    }
}
