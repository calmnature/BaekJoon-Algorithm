package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
    - 문자열을 입력 받아 1개 ~ 문자열 길이까지의 모든 문자열을 저장
    - 단, 겹치는 문자열은 제외하고 서로 다른 것의 개수만 출력
* */
public class No11478 {
    // Set을 이용하여 모든 경우의 수 저장
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Set<String> subSet = new HashSet<>();
        for(int start = 0; start < str.length(); start++){
            for(int end = start + 1; end <= str.length(); end++){
                // end = start를 하게 되면, [0,0]일 때 공백이 Set에 저장되어 1개가 더 카운팅
                // substring의 endIndex는 포함되지 않아 end는 문자열 길이까지
                subSet.add(str.substring(start, end));
            }
        }
        System.out.println(subSet.size());
    }
}
