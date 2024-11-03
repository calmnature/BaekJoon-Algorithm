package Step14;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
    문제 접근
        입력
            - 첫째 줄 : 상근이가 가진 카드 개수 N (1 <= N <= 500,000)
            - 둘째 줄 : 숫자 카드에 적힌 정수 (-10,000,000 <= 숫자 <= 10,000,000)
            - 셋째 줄 : M (1 <= N <= 500,000)
            - 넷째 줄 : 상근이가 몇 개 가지고 있는 숫자 카드인지 비교할 숫자 카드 (-10,000,000 <= 숫자 <= 10,000,000)
        출력
            - 네 번째 줄에 있는 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분하여 한 줄 출력
* */
public class No5 {
    /*
        문제 해결
            - 숫자 카드 1 문제와 달라진 점은 상근이가 가진 숫자 카드(둘째 줄)이 중복되어 카운팅을 해야하는 것
            - 방법1) 배열을 이용하여 둘째 줄의 숫자가 들어올 때마다 해당 숫자 index 카운트
            - 방법2) Map을 이용하여 디폴트 값을 0으로 잡고, 중복된 Key값(숫자 카드)가 들어오면 Value += 1
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        br.readLine();
        Map<Integer, Integer> cardMap = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toMap(key -> key, value -> 1, Integer::sum));


        br.readLine();
        Arrays.stream(Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                        .mapToObj(i -> cardMap.getOrDefault(i, 0))
                        .forEach(res -> sb.append(res).append(" "));

        System.out.println(sb.toString().trim());
    }
}
