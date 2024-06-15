package Step6;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        br.close();
        int[] alpha = new int[26];
        for(char ch : str.toCharArray()){
            alpha[(ch - 'A')]++;
        }

        // 배열의 max 값을 구하고, max 값의 idx를 구해야 함
        // 단, max와 같은 값이 중복되면 ?를 출력해야 함
        int max = Arrays.stream(alpha).max().getAsInt();
        int idx = 0, cnt = 0;
        for(int i = 0; i < alpha.length; i++){
            if(alpha[i] == max){
                idx = i;
                cnt++;
            }
            if(cnt >= 2){
                idx = -1;
                break;
            }
        }
        System.out.println(idx == - 1 ? "?" : (char)(idx + 65));

    }
}
