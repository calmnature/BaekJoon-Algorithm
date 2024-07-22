package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
/*
    - **문제 접근**
        - 아치형 곡선을 그어 같은 글자끼리 쌍을 지음
        - 선이 교차할 경우 좋은 단어가 아님
        - Stack을 이용하여 푸는 문제
* */
public class No3986 {
    /*
        - **문제 해결**
            - 선이 교차한다는 것은 ABAB처럼 앞에 글자와 다른 경우가 2번이상 생겼을 때를 의미
            - 다음의 규칙을 적용
                1. 스택이 비어있을 경우 추가
                2. 새로 넣을 값이 Stack의 top과 같이 같다면 top을 꺼냄
                3. 새로 넣을 값이 Stack의 top과 다르면 push
                4. 최종적으로 스택이 비어있으면 좋은 단어
    * */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int wordNumber = Integer.parseInt(br.readLine());
        int goodWordCount = 0;
        for(int i = 0; i < wordNumber; i++){
            char[] word = br.readLine().toCharArray();
            stack.clear();
            for (char ch : word) {
                if (stack.isEmpty()) stack.push(ch);
                else {
                    if (stack.peek() == ch) stack.pop();
                    else stack.push(ch);
                }
            }
            if(stack.isEmpty()) goodWordCount++;
        }
        System.out.println(goodWordCount);
    }
}
