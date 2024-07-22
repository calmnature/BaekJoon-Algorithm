package Problem_Number;

import java.io.*;
import java.util.*;

// 앞에 있는 숫자를 시작으로 N까지 출력
public class No15652 {
    /*
        - 2번 예제를 이중 반복문으로 생각을 하면, i ~ N까지 반복하고 그 다음 depth에서는 이전 i를 시작으로 N까지 반복
        - N = 4, M = 2 일 경우
        - i = 1일 경우 → j = 1, 2 , 3, 4
        - i = 2일 경우 → j = 2, 3, 4
            ⇒ (1 1), (1 2), (1 3), (1 4), (2 2), (2 3), (2 4), … (3 3), (3 4), (4 4)
    * */
    static StringBuilder sb = new StringBuilder();
    static int numCount, length;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numCount = Integer.parseInt(st.nextToken()); length = Integer.parseInt(st.nextToken());
        arr = new int[length];
        DFS(1, 0);
        System.out.println(sb);
    }

    private static void DFS(int start, int depth){
        if(depth == length){
            for(int num : arr) sb.append(num).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = start; i <= numCount; i++){
            arr[depth] = i;
            DFS(i, depth + 1);
        }
    }
}
