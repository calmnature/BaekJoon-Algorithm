package Step9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            String res = null;
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if(num1 == 0 && num2 == 0)
                break;
            if(num1 % num2 == 0)
                res = "multiple";
            else if(num2 % num1 == 0)
                res = "factor";
            else
                res = "neither";
            System.out.println(res);
        }
        br.close();
    }
}
