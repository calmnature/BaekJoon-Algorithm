package Step07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = 0, row = 1, col = 1;
        for(int i = 1; i <= 9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 9; j++){
                int now = Integer.parseInt(st.nextToken());
                if(now >= max){
                    max = now;
                    row = i; col = j;
                }
            }
        }
        br.close();
        System.out.println(max);
        System.out.println(row + " " + col);
    }
}
