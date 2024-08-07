package Problem_Number;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/*
    - **문제 접근**
        - 앞의 인덱스는 출력하지 않고, 자기 자신은 출력
* */
public class No15657 {
    /*
        - **문제 해결**
            - 2번 출력을 예시로 0 ~ N까지 출력 → 1 ~ N까지 출력 → 2 ~ N까지 출력
            - 현재 i를 넘겨주는 방식
    * */
    static StringBuilder sb = new StringBuilder();
    static int numCount, length;
    static int[] arr;
    static List<Integer> numList = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        numCount = input[0]; length = input[1];
        arr = new int[length];

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < numCount; i++) numList.add(input[i]);
        Collections.sort(numList);

        DFS(0, 0);

        System.out.println(sb);
    }

    private static void DFS(int start, int depth){
        if(depth == length){
            Arrays.stream(arr).forEach(num -> sb.append(num).append(" "));
            sb.append("\n");
            return;
        }

        IntStream.range(start, numCount)
                .forEach(i -> {
                    arr[depth] = numList.get(i);
                    DFS(i, depth + 1);
                });
    }
}
