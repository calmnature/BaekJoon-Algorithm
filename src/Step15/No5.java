package Step15;

import java.io.*;

public class No5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            long n = Long.parseLong(br.readLine());
            while (!check(n)) {
                n++;
            }
            sb.append(n).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean check(long n) {
        if(n == 2) return true;
        if (n == 1 || n % 2 == 0) return false;
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
