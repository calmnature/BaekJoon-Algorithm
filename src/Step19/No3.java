package Step19;

import java.io.*;

public class No3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 1;
        for(int i = N; i > 1; i--) {
            sum *= i;
        }

        System.out.println(sum);
    }
}
