package Step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No4_1My {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        boolean flag = new StringBuilder(str).reverse().toString().equals(str);
        System.out.println(flag ? 1 : 0);
    }
}
