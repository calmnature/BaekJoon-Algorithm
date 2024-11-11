package Step16;

import java.io.*;
import java.util.*;
/*
    문제 접근
        - 큐 명령어
            - push X : 정수 X를 Queue에 추가 → add(X)
            - pop : Queue에 가장 앞의 정수를 빼고 그 수를 출력, 큐가 비어있다면 없다면 -1 → poll()
            - size : 큐에 있는 정수 개수 출력 → size()
            - empty : 큐가 비어있으면 1, 아니면 0 출력 → isEmpty()
            - front : 큐의 가장 앞 정수 출력, 큐가 비어있다면 -1 출력 → peek()
            - back : 큐의 가장 뒤 정수 출력, 큐가 비어있다면 -1 출력 → 메서드 생성
        - 입력
            - 첫째 줄 : 명령의 수 N(1 <= N <= 2,000,000)
            - ~ N번째 줄 : 명령 (1 <= 정수 X <= 100,000)
        - 출력
            - 출력 명령 하나마다 1개씩 출력
* */
public class No6 {
    /*
        문제 해결
            - 문자열을 입력 받아 push로 시작하면 Queue에 X 삽입
            - 나머지 명령은 switch-case문으로 구성
            - 큐의 가장 뒤 정수를 출력하는 방법은 없기 때문에 메소드 생성
                - LinkedList로 구현하는 경우 getLast() 메서드 사용
                - Queue의 경우 순회하여 가장 마지막 데이터 출력
    * */
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String command = br.readLine();
            if(command.startsWith("push")) {
                int data = Integer.parseInt(command.split(" ")[1]);
                queue.add(data);
                continue;
            }
            switch(command) {
                case "pop" :
                    if(queue.isEmpty()) sb.append("-1");
                    else sb.append(queue.poll());
                    break;
                case "size" :
                    sb.append(queue.size());
                    break;
                case "empty" :
                    if(queue.isEmpty()) sb.append(1);
                    else sb.append(0);
                    break;
                case "front" :
                    if(queue.isEmpty()) sb.append(-1);
                    else sb.append(queue.peek());
                    break;
                case "back" :
                    if(queue.isEmpty()) sb.append(-1);
                    else sb.append(lastData());
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int lastData() {
        // LinkedList로 형변환
         return ((LinkedList<Integer>) queue).getLast();

        // Queue를 순회하여 마지막 데이터 반환 → 시간 초과
//        int lastData = 0;
//        for(int data : queue){
//            lastData = data;
//        }
//
//        return lastData;
    }
}
