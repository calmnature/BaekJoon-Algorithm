package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
    - **문제 접근**
        - 1번째 줄 ⇒ 숫자 카드 개수 N (50만 이하)
        - 2번째 줄 ⇒ -1000만 ~ 1000만 사이의 카드가 주어짐
        - 3번째 줄 ⇒ 맞춰야할 카드 개수 M (50만 이하)
        - 4번째 줄 ⇒ 공백으로 -1000만 ~ 1000만의 숫자 카드 M개
        - 같은 숫자의 카드는 없음
        - 출력 ⇒ 4번째 줄의 카드를 가지고 있으면 1, 아니면 0
* */
public class No10815 {
    /*
        - 리스트로 저장 ⇒ X
            - 최대 50만개의 데이터 추가로 인해 시간 초과 발생 ⇒ Set으로 변경
        - 4번째 줄을 for문으로 하나씩 비교하여 1 or 0 StringBuilder에 저장
    * */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 일반적인 방식으로 했을 때보다 아래 두 줄 바꿨을 때 약 120ms 개선
        // 기존 : 1092ms -> 972ms
        br.readLine();
        Set<Integer> myCards = Arrays.stream((br.readLine().split(" ")))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        br.readLine();
        // 아래 두 줄 성능 => 165MB, 1120ms
//         int[] input = Arrays.stream((br.readLine().split(" "))).mapToInt(Integer::parseInt).toArray();
//         Arrays.stream(input).mapToObj(i -> myCards.contains(i) ? 1 : 0)
//                        .forEach(result -> sb.append(result).append(" "));
        // 아랫 줄 성능 => 166MB, 1072ms
        Arrays.stream(Arrays.stream((br.readLine().split(" ")))
                .mapToInt(Integer::parseInt).toArray()) // 입력 받은 String 배열 Integer 배열로 변경
                .mapToObj(i -> myCards.contains(i) ? 1 : 0) // Integer 배열의 i값을 뽑아 Set에 포함 되면 1, 아니면 0의 결과
                .forEach(res -> sb.append(res).append(" ")); // 결과 추가
        System.out.println(sb.toString().trim());
    }
}
