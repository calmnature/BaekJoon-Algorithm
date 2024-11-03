package Step14;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long repeat = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sum();

        Map<String, Long> listMap = br.lines()
                .limit(repeat)
                .collect(Collectors.groupingBy(name -> name,                // 각 이름을 키로 사용
                                                TreeMap::new,               // 결과를 TreeMap으로 수집 (오름차순)
                                                // () -> new TreeMap<>(Comparator.reverseOrder()), // TreeMap 생성 (내림차순)
                                                Collectors.counting()));    // 그룹별 요소 개수를 세어 Long 타입으로 저장

        long cnt = listMap.values().stream()
                        .filter(count -> count == 2)
                        .count();
        sb.append(cnt).append("\n");

        listMap.entrySet().stream()
                        .filter(entry -> entry.getValue() == 2)
                        .forEach(entry -> sb.append(entry.getKey()).append("\n"));

        System.out.println(sb);
    }
}
