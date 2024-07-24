package Problem_Number;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    - **문제 접근**
        - 순서대로 막대를 넣은 뒤 가장 마지막에 보았을 때 보이는 막대의 개수를 출력하는 문제
        - 즉, 가장 마지막 막대의 높이를 기준으로 그보다 큰 막대들을 출력
* */
public class No17608 {
    /*
        - **문제 해결**
            - Stack을 이용하여 푸는 간단한 문제
            - Stack에서 pop을 하면서 나온 height와 maxHeight를 비교하여 height가 더 크다면 maxHeight를 height로 바꾸고 개수 카운팅
    * */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> bar = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int count = 0, maxHeight= 0;

        for(int i = 0; i < N; i++){
            int height = Integer.parseInt(br.readLine());
            bar.push(height);
        }

        for(int i = 0; i < N; i++){
            int height = bar.pop();
            if(maxHeight < height){
                maxHeight = height;
                count++;
            }
        }
        System.out.println(count);
    }
}
