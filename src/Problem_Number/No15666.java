package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 이전 인덱스에서 +1을 해주어서 현재 인덱스 이전의 값이 나오면 안 됨
* */
public class No15666 {
    /*
        - **문제 해결**
            - ‘N과 M 11’에서 했던 것 처럼 중복 체크 필요
            - Set을 사용할 경우 메모리, 속도의 효율성이 너무 떨어지기 때문에 LastUsed 변수를 사용하여 중복 체크
                ⇒ 입력 받은 숫자들을 오름차순 정렬을 하기 때문에 중복 체크가 가능
    * */
    static StringBuilder sb = new StringBuilder();
    static int numCount, length;
    static int[] arr;
    static List<Integer> numList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numCount = Integer.parseInt(st.nextToken()); length = Integer.parseInt(st.nextToken());
        arr = new int[length];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < numCount; i++) numList.add(Integer.parseInt(st.nextToken()));
        Collections.sort(numList);

        DFS(0, 0);

        System.out.println(sb);
    }

    private static void DFS(int start, int depth){
        if(depth == length){
            for(int num : arr) sb.append(num).append(" ");
            sb.append("\n");
            return;
        }

        int lastUsed = -1;
        for(int i = start; i < numCount; i++){
            int currentNum = numList.get(i);
            if(lastUsed != currentNum){
                arr[depth] = currentNum;
                DFS(i, depth +1);
                lastUsed = currentNum;
            }
        }
    }
}
