package Step10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr = new int[3];
        String res;
        while(true){
            st = new StringTokenizer(br.readLine());
            int max = 0, sum = 0;
            for(int i = 0; i < arr.length; i++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 0) return;
                arr[i] = num;
                max = Math.max(max, num);
                sum += num;
            }
            if(max >= sum - max)
                res = "Invalid";
            else if(arr[0] == arr[1] && arr[1] == arr[2])
                res = "Equilateral";
            else if(arr[0] != arr[1] && arr[0] != arr[2] && arr[1] != arr[2])
                res = "Scalene";
            else
                res = "Isosceles";
            System.out.println(res);
        }
    }
}
