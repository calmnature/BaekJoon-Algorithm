package Step14;


import java.io.*;
import java.util.*;

/*
    문제 접근
        입력
            - 첫째줄 : 문자열 S
            - S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000 이하
        출력
            - 첫째 줄에 S의 서로 다른 부분 문자열 개수 출력
* */
public class No8 {
    /*
        문제 해결
            - 길이가 1 (a, b, c)부터 길이가 5(ababc)까지 중복되지 않는 문자열의 개수를 체크
            - 중복이 되지 않아야하기 때문에 컬렉션의 Set 사용
    * */
    public static void main(String[] args) throws IOException {
        Set<String> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int length = str.length(); // 문자열 길이
        int scope = 1; // 부분 문자열 범위
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length - i; j++){
                if(j == length - 1)
                    set.add(str.substring(j));
                else
                    set.add(str.substring(j, j + scope));
            }
            scope++;
        }

        System.out.println(set.size());
    }
}
