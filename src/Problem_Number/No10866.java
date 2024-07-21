package Problem_Number;

import java.io.*;
import java.util.*;
/*
    - Deque(Double Ended Queue) 사용 문제
    - push ⇒ offer 명령어 / add = 예외 발생
    - pop ⇒ poll 명령어 / remove = 예외 발생
    - front, back ⇒ peek명령어 / get = 예외 발생
    - 출력 ⇒ 출력할 정수가 없으면 -1 → null일 경우 -1 출력
* */
public class No10866 {
    /*
        - 명령어 수를 입력 받음
        - switch-case문으로 구현할 시 중복되는 코드가 너무 많아져 if문으로 구현
    * */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        int CommandCnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < CommandCnt; i++){
            Integer output = -999; // 출력할 결과가 -999일 떄 출력하지 않음
            String[] input = br.readLine().split(" ");
            String command = input[0];
            switch(command){
                case "push_front" : deque.offerFirst(Integer.parseInt(input[1])); break;
                case "push_back" : deque.offerLast(Integer.parseInt(input[1])); break;
                case "pop_front" : output = deque.pollFirst(); break;
                case "pop_back" : output = deque.pollLast(); break;
                case "front" : output = deque.peekFirst(); break;
                case "back" : output = deque.peekLast(); break;
                case "size" : output = deque.size(); break;
                case "empty" : output = deque.isEmpty() ? 1 : 0; break;
            }
            // Deque가 비어있을 때 poll 또는 peek을 하면 null
            if(output == null) output = -1;
            // output이 -999라면(add, offer 됐다면) 출력하지 않음
            if(output != -999)  sb.append(output).append("\n");
        }
        System.out.println(sb);
    }
}
