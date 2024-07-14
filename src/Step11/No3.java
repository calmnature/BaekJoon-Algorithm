package Step11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken()), f = Integer.parseInt(st.nextToken());
        int answerX = 0, answerY = 0;
        for(int x = -999; x <= 999; x++){
            if(answerX != 0 && answerY != 0) break;
            for(int y = -999; y <= 999; y++){
                if(a * x + b * y == c && d * x + e * y == f){
                    answerX = x; answerY = y;
                    break;
                }
            }
        }
        System.out.println(answerX + " " + answerY);
    }
}
