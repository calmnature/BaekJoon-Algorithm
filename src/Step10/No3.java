package Step10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // X축과 Y축에서 나온 숫자를 카운트할 배열 생성
        // 0번은 사용하지 않음 => 조건 : 좌표 범위 = 1 ~ 1000
        int[] xArr = new int[1001];
        int[] yArr = new int[1001];
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            xArr[Integer.parseInt(st.nextToken())]++;
            yArr[Integer.parseInt(st.nextToken())]++;
        }
        br.close();
        int x = coordinate(xArr);
        int y = coordinate(yArr);
        System.out.println(x + " " + y);
    }

    private static int coordinate(int[] arr){
        // 배열의 값이 % 2를 하였을 때 나머지가 1인 경우는 홀수로 그 값을 리턴
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != 0){
                return i;
            }
        }
        return 0;
    }
}
