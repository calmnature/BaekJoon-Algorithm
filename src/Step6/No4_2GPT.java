package Step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No4_2GPT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        // 나의 풀이와 달리 추가적인 문자열 생성 없이
        // 기존의 문자열에서 비교를 하며,
        // 절반을 나눠서 양끝의 값이 하나라도 같지 않을 경우
        // 팰린드롬이 아니기에 break를 하여 반복의 횟수를 줄임
        boolean isPalindrome = true;
        int len = str.length();

        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome ? 1 : 0);
    }
}
