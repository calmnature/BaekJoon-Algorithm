package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 입력
            - 테스트 케이스 개수
            - 카드 개수
            - 카드 개수만큼 문자 입력 (모두 대문자)
        - 출력
            - 사전 순으로 가장 빠른 문자열 출력
* */
public class No13417 {
    /*
        - **문제 해결**
            - 가장 처음의 카드를 가지고 온 뒤 이후 카드는 왼쪽 또는 오른쪽으로 배치 가능
            - Deque를 이용해서 맨 앞 카드를 기준으로 왼쪽 오른쪽에 붙이면 됨
    * */
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++){
            Deque<String> deque = new LinkedList<>();

            int cardCount = Integer.parseInt(br.readLine());
            String[] card = br.readLine().split(" ");
            // 첫 카드 추가
            deque.offer(card[0]);

            for(int j = 1; j < cardCount; j++){
                String letter = card[j];
                // 맨 앞의 카드를 기준으로 맨 앞의 카드보다 더 작은 알파벳이면(사전순 or 오름차순)
                if(letter.compareTo(deque.getFirst()) <= 0)
                    // 첫 번째에 카드 추가
                    deque.offerFirst(letter);
                else // 마지막에 카드 추가
                    deque.offerLast(letter);

            }

            while(!deque.isEmpty())
                sb.append(deque.remove());
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
