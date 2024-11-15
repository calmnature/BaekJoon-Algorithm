package Step20;

import java.io.*;
import java.util.*;

/*
    문제 접근
        - ENTER : 새로운 사람이 채팅방에 입장
        - 그 외 : 유저 닉네임
        - ENTER 이후 첫 닉네임 = 인사
        - 인사 이후 동일 닉네임 = 일반 채팅
        - 입력
            - 첫째 줄 : 채팅방 로그 N (1 <= N <= 100,000)
            - ~ N번째 줄 : ENTER or 닉네임 (1 <= 문자열 길이 <= 20)
            - 첫 로그는 반드시 ENTER
        - 출력
            - 곰곰티콘(인사) 사용 횟수 출력
* */

public class No2 {
    /*
        문제 해결
            - N번 반복
            - 로그가 ENTER일 경우 Set의 Size를 count 변수에 더해넣고 초기화
            - 한 로그에 여러 번의 ENTER가 들어올 수 있음
            - 로그가 닉네임일 경우 Set에 add
            - 반복문 종료 후 count 출력
    * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();

        int logCount = Integer.parseInt(br.readLine());
        int GomGomCount = 0;
        for(int i = 0; i < logCount; i++){
            String input = br.readLine();
            if(!input.equals("ENTER")) {
                set.add(input);
                continue;
            }
            GomGomCount += set.size();
            set.clear();
        }
        GomGomCount += set.size();

        System.out.println(GomGomCount);
    }
}
