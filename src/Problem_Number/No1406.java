package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 문자열을 자르고 더하는 것으로 시도해보았지만 시간 초과 (0.3초)
        - Stack을 사용하게 되면 시간 복잡도가 O(1)를 갖는다고 함
* */
public class No1406 {
    /*
        - **문제 해결**
            - 2개의 스택을 가지고 하나는 데이터 저장용, 하나는 출력용으로 사용
            - L(커서 왼쪽 이동) 명령 : 1번 → 2번 스택 이동
            - D(커서 오른쪽 이동) 명령 : 2번 → 1번 스택 이동
            - B(커서 왼쪽 삭제) 명령 : 1번 스택 맨 위의 데이터 삭제
            - P ?(? 데이터 삽입) 명령 : 1번 스택 데이터 추가
            - 모든 명령이 종료된 뒤 1번 스택이 빌 때까지 2번 스택으로 옮기고 2번 스택 모두 출력
    * */
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        Stack<String> saveStack = new Stack<>();
        Stack<String> outputStack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        for(int i = 0; i < str.length(); i++)
            saveStack.push(String.valueOf(str.charAt(i)));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String[] command = br.readLine().split(" ");
            switch (command[0]){
                case "L" : if(!saveStack.isEmpty()) outputStack.push(saveStack.pop()); break;
                case "D" : if(!outputStack.isEmpty()) saveStack.push(outputStack.pop()); break;
                case "B" : if(!saveStack.isEmpty()) saveStack.pop(); break;
                case "P" : saveStack.push(command[1]); break;
            }
        }

        while(!saveStack.isEmpty()) outputStack.push(saveStack.pop());
        while(!outputStack.isEmpty()) sb.append(outputStack.pop());
        System.out.println(sb);
    }
}
