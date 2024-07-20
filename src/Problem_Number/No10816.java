package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/*
    - **문제 접근**
        - 이전 숫자 카드(10815번) 문제와 조건은 동일
        - 출력 ⇒ 4번째 줄에 주어진 숫자 카드를 보유하고 있으면 몇 개인지까지 출력
* */

public class No10816 {
    /*
        - **문제 해결**
            - Map 문제로 풀면 간단할 것으로 예상
            - 정렬은 굳이 하지 않아도 될 것 같으니 TreeMap은 필요 없음
    * */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        Map<Integer, Integer> myCards = new HashMap<>();
//        int N = Integer.parseInt(br.readLine());
//        int[] input = Arrays.stream((br.readLine().split(" "))).mapToInt(Integer::parseInt).toArray();
//        for(int i = 0; i < N; i++){
//            int key = input[i];
//            // 기존에 존재하면 해당 값 + 1 저장, 존재하지 않으면 1
//            myCards.put(key, myCards.getOrDefault(key, 0) + 1);
//        }

        br.readLine();
        Map<Integer, Integer> myCards = Arrays.stream((br.readLine().split(" ")))
                .map(Integer::parseInt)
                .collect(Collectors.toMap(key -> key, value -> 1, Integer::sum));
//        int M = Integer.parseInt(br.readLine());
//        int[] input = Arrays.stream((br.readLine().split(" "))).mapToInt(Integer::parseInt).toArray();
//        for(int i = 0; i < M; i++){
//            int key = input[i];
//            // 기존에 존재하면 해당 값, 존재하지 않으면 0 StringBuilder에 추가
//            sb.append(myCards.getOrDefault(key, 0)).append(" ");
//        }
        br.readLine();
        Arrays.stream(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray())
                .mapToObj(i -> myCards.getOrDefault(i, 0))
                .forEach(res -> sb.append(res).append(" "));
        System.out.println(sb.toString().trim());
    }
}
