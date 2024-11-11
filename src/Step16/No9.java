package Step16;

import java.io.*;
import java.util.*;
/*
    문제 접근
        - 덱 명령어
            - 1 X : 덱의 앞에 X 추가 → addFirst()
            - 2 X : 덱의 뒤에 X 추가 → addList()
            - 3 : 덱의 앞에 정수를 제거하고 출력, 없으면 -1 → pollFirst()
            - 4 : 덱의 뒤에 정수를 제거하고 출력, 없으면 -1 → pollLast()
            - 5 : 덱의 정수 개수 출력 → size()
            - 6 : 덱이 비어있으면 1, 아니면 0 → isEmpty()
            - 7 : 덱에 정수가 있다면 출력, 없으면 -1 → peekFirst()
            - 8 : 덱의 정수가 없다면 출력, 없으면 -1 → peekLast()
            - 1 <= X <= 100,000
        - 입력
            - 첫째 줄 : 명령 N (1 <= N <= 1,000,000)
            - ~ N번째 줄 : 명령
            출력을 요구하는 명령은 1개 이상
        - 출력
            - 출력을 요구하는 명령마다 결과를 한 줄에 하나씩 출력
* */
public class No9 {
    /*
        문제 해결
            - 명령어가 1 or 2면 Deque에 추가
            - 그 외 명령어는 switch-case문으로 StringBuilder에 추가
    * */
    public static void main(String[] args) throws IOException{
        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String command = br.readLine();
            if(command.startsWith("1")){
                int data = Integer.parseInt(command.split(" ")[1]);
                deque.addFirst(data);
                continue;
            } else if(command.startsWith("2")){
                int data = Integer.parseInt(command.split(" ")[1]);
                deque.addLast(data);
                continue;
            }
            switch (command) {
                case "3" :
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst());
                    break;
                case "4" :
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast());
                    break;
                case "5" :
                    sb.append(deque.size());
                    break;
                case "6" :
                    sb.append(deque.isEmpty() ? 1 : 0);
                    break;
                case "7" :
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst());
                    break;
                case "8" :
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast());
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
