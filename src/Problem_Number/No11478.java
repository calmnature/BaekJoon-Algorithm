package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 문자열을 입력 받아 1개 ~ 문자열 길이까지 개수를 구하는 것
public class No11478 {
    // 슬라이딩 윈도우를 이용하여 카운팅
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Set<String> subSet = new HashSet<>();
        for(int size = 0; size < str.length(); size++){
            int start = 0;
            int end = size+1; // substring은 마지막을 포함하지 않아 1추가
            while(end <= str.length()){ // end가 문자열 길이까지
                String subString = str.substring(start, end);
                subSet.add(subString);
                start++; end++; // start와 end를 1씩 증가시켜 윈도우를 오른쪽으로 밀음
            }
        }
        System.out.println(subSet.size());
    }
}
