package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
    - **문제 접근**
        - 알고 있는 3의 배수는 한 자리로 3, 6, 9 밖에 모름
        - 즉, X → Y로 변경할 때 10보다 작은 수가 될 때까지 변경을 해야한다는 의미
        - 출력
            - 10보다 작은 Y가 될 때까지 몇 번의 변경이 일어났는지 출력
            - 3의 배수인지 아닌지 YES, NO로 출력
* */
public class No1769 {
    /*
        - **문제 해결**
            - 각 자리수를 모두 더하고 10보다 클 경우 작아질 때까지 반복
            - 숫자인 형태로 계산하기 보다 String의 CharAt() 메서드를 이용하는 것이 더 효율적일 것으로 생각 됨
    * */
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int count = 0;
        int sum = str.length() == 1 ? Integer.parseInt(str) : 0;
        while(str.length() != 1){
            sum = 0;
            count++;
            for(int i = 0; i < str.length(); i++){
               sum += str.charAt(i) - '0';
            }
            str = String.valueOf(sum);
        }
        String res = sum % 3 == 0 ? "YES" : "NO";
        sb.append(count).append("\n").append(res);
        System.out.println(sb);
    }
}
