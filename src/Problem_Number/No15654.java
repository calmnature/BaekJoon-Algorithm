package Problem_Number;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/*
    - **문제 접근**
        - 별도의 수를 입력받지 않고 1 ~ N까지 순차적이였던 것과 달리 10,000이하의 N개의 자연수를 입력 받음
        - 2번 출력을 보면 앞의 숫자랑 같은 것은 출력하지 않음
* */
public class No15654 {
    /*
        - **문제 해결**
            - 가장 처음의 ‘N과 M 1’의 문제와 똑같이 visited 배열이 필요
            - 입력받은 숫자들을 오름차순 수열로 출력을 해야 하기 때문에 list에 입력을 받고 정렬을 한 뒤 DFS 재귀 호출
    * */
    static StringBuilder sb = new StringBuilder();
    static int numCount, length;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> numList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        numCount = input[0]; length = input[1];
        visited = new boolean[numCount]; arr = new int[length];

        // List에 값 추가
        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < numCount; i++) numList.add(input[i]);
        // 오름차순 출력을 위해 List 정렬
        Collections.sort(numList);

        DFS(0);

        System.out.println(sb);
    }

    private static void DFS(int depth){
        if(depth == length){
            Arrays.stream(arr).forEach(num -> sb.append(num).append(" "));
            sb.append("\n");
            return;
        }

        IntStream.range(0, numCount)
                .filter(i -> !visited[i])
                .forEach(i -> {
                    visited[i] = true;
                    arr[depth] = numList.get(i);
                    DFS(depth + 1);
                    visited[i] = false;
                });
    }
}
