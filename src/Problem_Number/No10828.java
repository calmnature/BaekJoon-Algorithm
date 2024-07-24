package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    - **문제 접근**
        - 제목 그대로 스택 구현 문제
* */
public class No10828 {
    /*
        - **문제 해결**
            - Stack 클래스를 사용하여 구현
            - 큐 문제처럼 별도로 구현해야하는 명령어는 없음
    * */
    public static void main(String[] args) throws Exception{
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int NOT_OUTPUT = -999;
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String[] command = br.readLine().split(" ");
            Integer output = NOT_OUTPUT;

            switch(command[0]){
                case "push" : stack.push(Integer.parseInt(command[1])); break;
                case "pop" : output = stack.empty() ? -1 : stack.pop(); break;
                case "size" : output = stack.size(); break;
                case "empty" : output = stack.isEmpty() ? 1 : 0; break;
                case "top" : output = stack.empty() ? -1 : stack.peek(); break;
            }

            if(output != NOT_OUTPUT) sb.append(output).append("\n");
        }

        System.out.println(sb);
    }
}
