package Problem_Number;

import java.io.*;
import java.util.*;
/*
    - **문제 접근**
        - 1 ~ 8번 시리즈와는 다르게 겹치는 숫자가 주어짐
        - 동일한 수열은 출력되어서는 안 됨
            - (1 7), (1 9), (1 9) ⇒ (1 9) 겹쳐서 하나만 출력
            - (7 1), (7 9), (7 9) ⇒ (7 9) 겹쳐서 하나만 출력
* */
public class No15663 {
    /*
        - **문제 해결**
            - Set<String>을 선언해서 StringBuilder에 추가하기 전 셋에 없는 문자열일 경우에만 StringBuilder에 추가
    * */
    static StringBuilder sb = new StringBuilder();
    static int numCount, length;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> numList = new ArrayList<>();
    static Set<String> sequenceSet = new HashSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numCount = Integer.parseInt(st.nextToken()); length = Integer.parseInt(st.nextToken());
        visited = new boolean[numCount]; arr = new int[length];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCount; i++) numList.add(Integer.parseInt(st.nextToken()));
        Collections.sort(numList);

        DFS( 0);

        System.out.println(sb);
    }

    private static void DFS(int depth){
        if(depth == length){
            // 문자열이 존재하는 지 확인하기 위해 임시 StringBuilder에 추가
            StringBuilder tmp = new StringBuilder();
            for(int num : arr) tmp.append(num).append(" ");
            tmp.append("\n");
            // 해당 문자열이 Set에 없다면 중복되지 않음
            if(!sequenceSet.contains(tmp.toString())){
                sequenceSet.add(tmp.toString()); // Set에 추가하여 중복 체크
                sb.append(tmp); // 출력할 StringBuilder에 추가
            }
            return;
        }

        for(int i = 0; i < numCount; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = numList.get(i);
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
}
