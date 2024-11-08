package Step16;

import java.io.*;
import java.util.*;

/*
    문제 접근
        - 번호표 순서대로만 간식을 받을 수 있음 → Nice 출력
        - 즉, 번호 순서대로가 아니면 간식을 받지 못함 → Sad 출력
        - 입력
            - 첫째 줄 : 학생들의 수 N (1 <= N <= 1,000)
            - 둘째 줄 : 모든 학생들의 번호표 (1, 2, ..., N)
        - 출력
            - 무사히 간식을 받을 수 있으면 Nice, 그렇지 않으면 Sad 출력
* */
public class No5 {
    /*
        문제 해결
            - 번호표(numberSequence)는 1번부터 시작, N번만큼 반복
            - 번호표와 숫자가 같으면 번호표 +1, 아니면 Stack Push
            - while문 조건 : Stack이 비어있지 않고, peek()이 번호표와 같으면 번호표 + 1, Stack Pop
            - 최종적으로 Stack이 비어있으면 Nice, 아니면 Sad
    * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> waitingLine = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numberSequence = 1;

        for(int i = 0; i < N; i++){
            int number = input[i];
            if(numberSequence == number) {
                numberSequence++;
            } else {
                waitingLine.push(number);
            }

            while(!waitingLine.isEmpty() && waitingLine.peek() == numberSequence){
                numberSequence++;
                waitingLine.pop();
            }
        }

        System.out.println(waitingLine.isEmpty() ? "Nice" : "Sad");
    }
}
