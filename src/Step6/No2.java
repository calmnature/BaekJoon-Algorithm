package Step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2 {
    private static int[] chess = {1,1,2,2,2,8};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chess.length; i++){
            if(sb.length() > 0)
                sb.append(" ");
            sb.append(chess[i] - Integer.parseInt(st.nextToken()));
        }
        System.out.println(sb);
    }
}
