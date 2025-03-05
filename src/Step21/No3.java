package Step21;

import java.io.*;

/*
    - 문제 접근
        - 펠린드롬 문자열이라면 1, 펠린드롬 문자열이 아니라면 0 / 재귀 함수 호출 횟수를 공백으로 한 줄에 출력하는 문제
        - 입력
            첫째줄 : 테스트케이스 개수 T (1<= T <= 1,000)
            둘째줄 ~ : 알파벳 대문자로 구성된 문자열 S
        - 출력
             isPalindrome 함수의 반환값과 recursion 함수의 호출 횟수를 한 줄에 공백으로 구분하여 출력
* */
public class No3 {
    /*
        - 문제 해결
            - 문제에서 주어진 C언어 코드를 Java 언어로 변경
            - 전역 변수 count를 선언하고, for문이 시작될 때 0으로 초기화
            - isPalindrome 함수와 recursion 함수가 종료되면 StringBuilder에 넣고 테스트케이스 개수만큼 반복
    * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String s = br.readLine();
            int[] result = isPalindrome(s);
            bw.write(result[0] + " " + result[1] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int[] isPalindrome(String s) {
        int count = 0;
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            count++;
            if(s.charAt(left) != s.charAt(right)) return new int[]{0, count};
            left++; right--;
        }

        if(s.length() % 2 == 0) count++;
        return new int[]{1, count};
    }
}
