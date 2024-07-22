package Problem_Number;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

/*
    - **문제 접근**
        - N과 M 1의 문제에서 달라진 점은 앞의 수보다 뒤의 수가 작아야 함
        - 즉, 아래 같은 경우가 출력 되지 않음
            - 2 1
            - 3 1
            - 3 2
            - 4 1
            - 4 2
            - 4 3
* */
public class No15650 {
    /*
        - **문제 해결**
            - 반복문의 시작값을 이전 i보다 1증가되어 시작
            - DFS 함수 매개 변수로 현재 시점이라는 now 변수를 전달
            - DFS 함수호출 시 now를 1 증가, depth를 1증가하여 반복문의 i는 now부터 시작하여 numCount까지 반복
    * */
    static StringBuilder sb = new StringBuilder();
    static int numCount, length;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream((br.readLine().split(" "))).mapToInt(Integer::parseInt).toArray();
        numCount = input[0]; length = input[1];
        arr = new int[length];
        DFS(1, 0);
        System.out.println(sb);
    }

    private static void DFS(int now, int depth){
        if(depth == length){ // depth가 배열 길이랑 같아지면
            Arrays.stream(arr).forEach(num -> sb.append(num).append(" "));
            sb.append("\n");
            return;
        }

        IntStream.range(now, numCount + 1)
                .forEach(i -> {
                    arr[depth] = i;
                    DFS(i + 1, depth + 1);
                });
    }
}
