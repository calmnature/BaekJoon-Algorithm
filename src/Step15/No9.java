package Step15;

import java.io.*;

/*

* */
public class No9 {
    /*

    * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 1; i * i <= N; i++){
            cnt++;
        }

        System.out.println(cnt);
    }
}
