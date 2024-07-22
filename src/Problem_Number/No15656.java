package Problem_Number;
import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 모든 경우의 수를 출력 (자기 자신 포함)
* */
public class No15656 {
    /*
        - **문제 해결**
            - 출력 예제 2번을 기준으로 이중 반복문으로 생각하면 0 ~ N, 0 ~ N 모두 출력
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

        DFS(0);

        System.out.println(sb);
    }

    private static void DFS(int depth){
        if(depth == length){
            for(int num : arr) sb.append(num).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < numCount; i++){
            arr[depth] = numList.get(i);
            DFS( depth + 1);
        }
    }
}
