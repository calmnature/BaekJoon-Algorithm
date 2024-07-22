package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
    - 이번에는 앞의 인덱스의 숫자와 자기 자신을 출력하지 않음
        - 앞의 인덱스 숫자 ⇒ (7 1), (8 7) 등
        - 자기 자신 ⇒ (1 1) (7 7) 등
* */
public class No15655 {
    /*
        - **문제 해결**
            - 재귀 호출 시 현재 i + 1의 값 전달
    * */
    static StringBuilder sb = new StringBuilder();
    static int numCount, length;
    static int[] arr;
    static List<Integer> numList = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numCount = Integer.parseInt(st.nextToken()); length = Integer.parseInt(st.nextToken());
        arr = new int[length];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCount; i++) numList.add(Integer.parseInt(st.nextToken()));
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

        for(int i = start; i < numCount; i++){
            arr[depth] = numList.get(i);
            DFS(i + 1, depth + 1);
        }
    }
}
