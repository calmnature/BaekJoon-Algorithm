package Step7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] canvas = new int[101][101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j = x; j < x + 10; j++){
                for(int k = y; k < y + 10; k++){
                    canvas[j][k] = 1;
                }
            }
        }
        br.close();
//        for(short[] s : canvas){
//            System.out.println(Arrays.toString(s));
//        }
//        int sum = 0;
//        for (short[] can : canvas) {
//            for (short i : can) {
//                sum += i;
//            }
//        }

        // 스트림 풀이방식
        int sum = Arrays.stream(canvas)
                .flatMapToInt(row -> Arrays.stream(row).map(i -> i))
                .sum();
        System.out.println(sum);
    }
}
