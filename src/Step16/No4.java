package Step16;

import java.io.*;
import java.util.*;

/*
    문제 접근
        - 문자열에 포함되는 괄호는 소괄호와 대괄호 2종류
        - 문자열이 균형을 이루는 조건은 아래와 같음
        - 모든 왼쪽 소괄호는 오른쪽 소괄호와만 짝을 이룸
        - 모든 왼쪽 대괄호는 오른쪽 대괄호와만 짝을 이룸
        - 모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재
        - 모든 괄호들의 짝은 1:1 매칭만 가능
        - 짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 함
        - 입력
            - 각 문자열은 마지막 글자를 제외하고 영문 알파벳, 공백, 소괄호, 대괄호로 이루어져 있으며, 온점(.)으로 끝나고 길이는 100글자 이하
            - 입력의 종료 조건으로 맨 마지막에 온점 하나(".")
        - 출력
            - 각 줄마다 해당 문자열이 균형을 이루고 있으면 yes, 아니면 no 출력
* */

public class No4 {
    /*
        문제 해결
            - 무한 반복문으로 들어온 문자가 정확히 "."라면 반복 종료
            - 입력받은 문자열 길이만큼 반복
            - '(' 또는 '['일 경우 무조건 Stack에 추가
            - ) 또는 ]일 때 Stack이 비어있으면 불균형 문자열 (항상 여는 괄호 (, [가 먼저 나오기 때문에 Stack에 있어야 함) → 반복문 종료
            - ')'일 때 짝이 '('가 아니거나, ']'일 때 짝이 '['가 아니라면 불균형 문자열 → 반복문 종료
            - 반복문이 종료된 후 스택이 비어있지 않더라도 불균형 문자열
    * */
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String str = br.readLine();
            if(str.equals(".")) break;

            boolean isBalanced = true;
            Stack<Character> stack = new Stack<>();

            int repeat = str.length();
            for(int i = 0; i < repeat; i++){
                char ch = str.charAt(i);
                // (, ), [, ] 이 외에는 무시
                if(ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if(ch == ')' || ch == ']'){ // )이거나 ]일 때 실행
                    if(stack.isEmpty()) { // 비어있으면 no
                        isBalanced = false;
                        break;
                    }
                    char pop = stack.pop();
                    if((ch == ')' && pop != '(') || (ch == ']' && pop != '[')){
                        // ')'일 때 짝(pop)이 '('가 아니라 '['라면 불균형
                        // ']'일 때 짝(pop)이 '['가 아니라 '(' 라면 불균형
                        isBalanced = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) isBalanced = false;
            sb.append(isBalanced ? "yes" : "no").append("\n");
        }
        System.out.println(sb);
    }
}
