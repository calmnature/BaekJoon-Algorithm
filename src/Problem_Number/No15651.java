package Problem_Number;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

// 숫자 개수 N과 길이 M을 입력 받고, 1 ~ N까지, 1 ~ N까지 반복이 됨
public class No15651 {
    // 이중 반복문으로 생각하면 i = 1 ~ N까지, 그 다음 depth에서 다시 i = 1 ~ N까지 반복 됨
    static StringBuilder sb = new StringBuilder();
    static int numCount, length;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream((br.readLine().split(" "))).mapToInt(Integer::parseInt).toArray();
        numCount = input[0]; length = input[1];
        arr = new int[length];
        DFS(0);
        System.out.println(sb);
    }

    private static void DFS(int depth){
        if(depth == length){
            Arrays.stream(arr).forEach(num -> sb.append(num).append(" "));
            sb.append("\n");
            return;
        }

        IntStream.range(1, numCount + 1)
                .forEach(i -> {
                    arr[depth] = i;
                    DFS(depth + 1);
                });
    }
}
