package Problem_Number;
import java.io.*;
import java.util.*;
import java.util.stream.*;

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
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        numCount = input[0]; length = input[1];
        arr = new int[length];

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < numCount; i++) numList.add(input[i]);
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
                .forEach(i -> {
                    arr[depth] = numList.get(i);
                    DFS(depth + 1);
                });
    }
}
