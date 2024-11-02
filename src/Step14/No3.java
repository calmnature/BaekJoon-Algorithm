package Step14;

import java.io.*;
import java.util.*;

/*
    문제 접근
        입력
            - 첫째 줄 : 로그에 기록된 출입 기록 수 n(2 <= n <= 1,000,000)
            - n개의 줄 : 사람이름 출입기록(enter, leave)
            - 회사에 동명이인은 없으며, 대소문자가 다른 경우 다른 사람
            - 사람이름은 알파벳 대소문자로 5글자 이하의 문자열
        출력
            - 현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력
* */
public class No3 {
    /*
        문제 해결
            - TreeSet을 사용하여 사전 역순으로 정렬되도록 하고, 들어오면 add, 나가면 remove하여 TreeSet에 남은 사람만 출력하는 방식으로 해결 가능
            - 하지만 문제를 확장하여 출근을 한 직원, 회사에 남아있는 직원, 출근하지 않은 직원 등을 출력하는 그러한 문제들을 생각했을 때 기록을 남겨야한다고 생각하여 Map으로 풀이
            - Map<String, Integer>로 "직원이름 : 출입여부" → 0 : 출근, 1 : 퇴근으로 최종적으로 0인 직원만 출력을 하게 되면 출근하지 않은 직원까지 체크가 가능
    * */
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> logMap = new TreeMap<>(Collections.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int logCount = Integer.parseInt(br.readLine());
        for(int i = 0; i < logCount; i++){
            String[] log = br.readLine().split(" ");
            logMap.put(log[0], log[1].equals("enter") ? 0 : 1);
        }

        for(Map.Entry<String, Integer> entry : logMap.entrySet()){
            if(entry.getValue() == 0)
                sb.append(entry.getKey()).append("\n");
        }

        System.out.println(sb);
    }
}
