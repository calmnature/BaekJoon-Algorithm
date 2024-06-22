package Step9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class No4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int cnt = 0;
        for(int i = 0; i < N; i++){
            cnt += function(Integer.parseInt(st.nextToken()));
        }
        System.out.println(cnt);
    }

    private static int function(int n) {
        if(n == 1) return 0;
        else if(n == 2) return 1;
        for(int i = 2; i < n; i++){
            if(n % i == 0)
                return 0;
        }
        return 1;
    }
}
