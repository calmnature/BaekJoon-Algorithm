package Step14;

import java.io.*;
import java.util.*;

/*
    문제 접근
        입력
            - 첫째 줄 : 듣도 못한 사람 수 N, 보도 못한 사람 수 M (1<= N, M <= 500,000)
            - ~ N번째 줄 : 듣도 못한 사람 이름
            - ~ M번째 줄 : 보도 못한 사람 이름
            - 듣도 못한 사람, 보도 못한 사람 명단에는 중복되는 이름이 없음
        출력
            - 듣도 보도 못한 사람의 수와 명단을 사전순 출력
            - 즉, N과 M에 모두 포함되는 사람(교집합) 사전순 출력 문제
* */
public class No6 {
    /*
        문제 해결
            - 중복이 되지 않기 때문에 굳이 두 개의 저장소를 만들지 말고 Map<String, Integer>으로 N과 M 관계 없이 Map에 사람 이름(Key)으로 숫자를 카운팅(Value)
            - Value가 2인 사람만 출력하면 되는데, 사전 순 출력을 해야하기 때문에 TreeMap을 사용
    * */
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> listMap = new TreeMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long repeat = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sum();

        int cnt = 0;
        for(int i = 0; i < repeat; i++){
            String name = br.readLine();
            listMap.put(name, listMap.getOrDefault(name, 0) + 1);
            if(listMap.get(name) == 2) cnt++;
        }

        sb.append(cnt).append("\n");

        for(Map.Entry<String, Integer> entry : listMap.entrySet()) {
            if(entry.getValue() == 2) sb.append(entry.getKey()).append("\n");
        }

        System.out.println(sb);
    }
}
