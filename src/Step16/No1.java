package Step16;

import java.io.*;
import java.util.*;
/*
    문제 접근
        - 정수를 저장하는 스택을 구현
        - 총 5가지의 명령
            - 1 X : 정수 X를 스택에 추가 (1 <= X <= 100,000) → Push
            - 2 : 스택에 정수가 있다면 맨 위의 정수를 출력, 없다면 -1 출력 → Pop
            - 3 : 스택에 들어있는 정수의 개수 출력 → Size
            - 4 : 스택이 비어있으면 1, 아니면 0 출력 → isEmpty()
            - 5 : 스택에 정수가 있다면 맨 위의 정수를 출력, 없다면 -1 출력 → Peek
        - 입력
            - 첫째 줄 : 명령의 수 N (1 <= N <= 1,000,000)
            - ~ N번째 줄 : 명령
            - 출력을 요구하는 명령(2, 5)은 하나 이상 주어짐
        - 출력
            - 출력을 요구하는 명령이 주어질 때마다, 명령의 결과를 한 줄에 하나씩 출력
* */
public class No1 {
    /*
        문제 해결
            - Integer를 저장하는 스택 생성
            - 입력이 1로 시작하면 push이기 때문에 split으로 나눠 1번 인덱스의 값을 push
            - 나머지 명령에 따라 switch-case문 실행
    * */
    public static void main(String[] args) throws IOException{
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            if(input.startsWith("1")) {
                int number = Integer.parseInt(input.split(" ")[1]);
                stack.push(number);
                continue;
            }

            switch(input) {
                case "2" :
                    if(stack.isEmpty()) sb.append("-1");
                    else sb.append(stack.pop());
                    break;
                case "3" :
                    sb.append(stack.size());
                    break;
                case "4" :
                    if(stack.isEmpty()) sb.append("1");
                    else sb.append("0");
                    break;
                case "5" :
                    if(stack.isEmpty()) sb.append("-1");
                    else sb.append(stack.peek());
                    break;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
