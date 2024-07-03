package Step10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No8 {
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        //  입력 받은 값을 배열에 저장하고 max 값을 구함
        for(int i = 0; i < arr.length; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            max = Math.max(max, num);
        }
        System.out.println(maxLength(arr));
    }

    private static int maxLength(int[] arr){
        int sum = 0;
        // max의 값과 동일한 변이 2개이상 있을 때를 대비하여 flag 변수 생성
        boolean flag = true;
        for(int n : arr){
            if(flag && max == n){ // max와 값이 같을 경우
                // 최초 1회만 continue;를 하고 이후에는 sum에 더해침
                flag = false;
                continue;
            }
            sum += n;
        }
        if(sum > max) // 두 변의 합이 max보다 클 경우 max를 더함
            sum += max;
        else // 두 변의 합보다 max가 클 경우 sum에 sum - 1을 더함
            sum += sum - 1;
        return sum;
    }
}
