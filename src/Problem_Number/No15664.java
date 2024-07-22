package Problem_Number;

import java.io.*;
import java.util.*;
/*
    - **문제 접근**
        - 이전 인덱스와 자기 자신을 포함하지 않음
* */
public class No15664 {
    /*
        - **문제 해결**
            - 재귀 호출 시 현재 인덱스 + 1
            - ‘N과 M 9’와 동일하게 Set으로 중복 체크 필요
    * */
    static StringBuilder sb = new StringBuilder();
    static int numCount, length;
    static int[] arr;
    static List<Integer> numList = new ArrayList<>();
    static Set<String> numSet = new HashSet<>();

    public static void main(String[] args) throws Exception{
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
            StringBuilder tmp = new StringBuilder();
            for(int num : arr) tmp.append(num).append(" ");
            tmp.append("\n");
            if(numSet.add(tmp.toString())) sb.append(tmp);
            return;
        }

        for(int i = start; i < numCount; i++){
            arr[depth] = numList.get(i);
            DFS(i + 1, depth + 1);
        }
    }
}
