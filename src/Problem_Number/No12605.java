package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    - **문제 접근**
        - 문자열을 입력 받아 공백 단위로 나눈 뒤 거꾸로 출력하는 문제
* */
public class No12605 {
    /*
        - **문제 해결**
            - split으로 나눈 뒤 for문을 이용하여 마지막 인덱스부터 출력하는 방법1
            - split으로 나눈 뒤 stack을 이용하여 마지막 알파벳부터 출력하는 방법2
            - 위 두 가지 방법으로 풀어보고 메모리, 시간, 구현 시 필요한 라인 수 비교
    * */
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> reverseSequence = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            sb.append("Case #").append(i+1).append(":").append(" ");
            for (String string : input)
                reverseSequence.push(string);
            while(!reverseSequence.isEmpty())
                sb.append(reverseSequence.pop()).append(" ");
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }

        System.out.println(sb);
    }
}
