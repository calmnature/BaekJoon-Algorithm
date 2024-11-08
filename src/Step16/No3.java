package Step16;

import java.io.*;
import java.util.*;
/*
    문제 접근
        - 괄호가 쌍이 맞으면 VPS(Valid PS)
        - 괄호 쌍이 아니면 VPS가 아님
        - 입력
            - 첫째 줄 : T개의 케이스가 주어짐
            - ~ T번째 줄 : 괄호 문자열 (2 <= 길이 <= 50)
        - 출력
            - VPS면 YES, VPS가 아니면 NO를 한 줄에 하나씩 출력
* */
public class No3 {
    /*
        문제 해결
            1. 입력받은 문자열을 모두 Stack에 추가
            2. 새로운 Stack 준비
            3. 기존 Stack이 isEmpty()가 될 때까지 반복
            4. 기존 Stack에서 pop을 한 괄호가 ')'라면 새로운 Stack에 Push
            5. 기존 Stack에서 pop을 한 괄호가 '('라면 새로운 Stack Pop (새로운 스택에는 ')' 괄호만 추가되어 있을 것)
                단, '('와 짝이 없다면 = 새로운 Stack이 비어있다면 '('를 push하고 break → 불필요한 반복을 줄임
            6. 최종적으로 새로운 Stack이 비어있다면 YES, 아니라면 NO를 StringBuilder에 추가
    * */
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            Stack<Character> originStack = new Stack<>();
            Stack<Character> newStack = new Stack<>();

            String input = br.readLine();
            int length = input.length();
            for(int j = 0; j < length; j++){
                originStack.push(input.charAt(j));
            }

            while(!originStack.isEmpty()){
                char ch = originStack.pop();
                if(ch == ')')
                    newStack.push(ch);
                else {
                    if(newStack.isEmpty()){
                        newStack.push(ch);
                        break;
                    }
                    newStack.pop();
                }
            }

            if(newStack.isEmpty()) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
