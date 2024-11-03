package Step14;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/*
    문제 접근
        입력
            - 첫째 줄 : 집합 A의 원소 개수, 집합 B의 원소 개수
            - 둘째 줄 : 집합 A의 원소
            - 셋째 줄 : 집합 B의 원소
            - 원소 개수 <= 200,000
            - 원소 값 <= 100,000,000
        출력
            - 대칭 차집합의 원소 개수 출력
* */
public class No7 {
    /*
        문제 해결
            - A 집합에만 있는 원소 개수 + B 집합에만 있는 원소 개수를 출력하는 문제
            - A와 B의 교집합 개수를 구한 뒤, (A집합 원소 개수 - 교집합개수) + (B집합 원소 개수 - 교집합개수)를 출력하면 해결
            - 다르게 묶으면 A 집합 원소 개수 + B 집합 원소 개수 - (교집합개수 * 2)
            - Map<Integer, Boolean>으로 A집합, B집합 모든 원소를 넣는데 교집합이 아니면 true, 교집합이면 false로하여 false의 개수만 세어 A + B - 교집합 * 2로 풀이 접근
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] size = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int A = size[0], B = size[1];

        Map<Integer, Boolean> setMap = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toMap(key -> key, value -> true, (oldValue, newValue) -> !oldValue));

        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(key -> setMap.put(key, !setMap.getOrDefault(key, false)));

        long intersection = setMap.values().stream()
                .filter(value -> !value)
                .count();

        System.out.println(A + B - intersection * 2);
    }
}
