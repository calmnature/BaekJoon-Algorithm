package Problem_Number;

import java.io.*;
import java.util.*;

public class No15665 {
    static StringBuilder sb = new StringBuilder();
    static int numCount, length;
    static int[] arr;
    static List<Integer> numList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numCount = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());

        arr = new int[length];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCount; i++) numList.add(Integer.parseInt(st.nextToken()));
        Collections.sort(numList);
        DFS(0);
        System.out.println(sb);
    }

    private static void DFS(int depth) {
        if (depth == length) {
            for (int num : arr) sb.append(num).append(" ");
            sb.append("\n");
            return;
        }

        int lastUsed = -1;
        for (int i = 0; i < numCount; i++) {
            int current = numList.get(i);
            if (current != lastUsed) { // 현재 숫자가 마지막에 사용된 숫자와 같지 않다면
                arr[depth] = current; // 현재 dpeth번방에 현재 숫자를 넣음
                DFS(depth + 1);
                lastUsed = current; // 재귀 종료 후, 마지막 사용된 숫자에 현재 숫자를 저장
            }
        }
    }
}