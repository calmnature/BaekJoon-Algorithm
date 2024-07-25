package Problem_Number;

import java.io.*;
import java.util.*;

public class No11478 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> stringSet = new HashSet<>();
        String str = br.readLine();
        // 슬라이딩 윈도우 도전
        int size = 1;
        while(size <= str.length()){
            StringBuilder sb = new StringBuilder();
            int start = 0, end = size;
            // str의 0 ~ end-1까지 substring하여 StringBuilder에 추가 -> 최초 윈도우
            sb.append(str, start, end);
            // 최초 윈도우의 값 Set에 저장
            stringSet.add(sb.toString());
            while(end < str.length()) {
                // StringBuilder의 가장 첫 번째값 삭제
                sb.deleteCharAt(0);
                // StringBuilder에 문자열의 end번째 값 추가
                // substring은 endIndex를 포함하지 않기 때문에, end번째 인덱스의 값을 추가하고 후증가
                sb.append(str.charAt(end++));
                // 앞에 한 개 지우고, 뒤에 한 개 추가한 부분 문자열 Set에 저장
                stringSet.add(sb.toString());
            }
            size++; // 슬라이딩 윈도우 크기 증가
        }

        System.out.println(stringSet.size());
    }
}
