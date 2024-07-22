package Problem_Number;

import java.io.*;
import java.util.*;
/*
    - **문제 접근**
        - 같은 수를 여러 번 골라도 되지만, 중복 수열은 출력해선 안 됨
* */
public class No15665 {
    /*
        - **문제 해결**
            - i = 0 ~ N 까지 모든 경우의 수 출력
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

        DFS(0);

        System.out.println(sb);
    }

    private static void DFS(int depth){
        if(depth == length){
            StringBuilder tmp = new StringBuilder();
            for(int num : arr) tmp.append(num).append(" ");
            tmp.append("\n");
            if(numSet.add(tmp.toString())) sb.append(tmp);
            return;
        }

        for(int i = 0; i < numCount; i++){
            arr[depth] = numList.get(i);
            DFS(depth + 1);
        }
    }
}
