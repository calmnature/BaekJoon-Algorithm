package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
    - **문제 접근**
        - “-”를 3$^N$만큼 반복하여 문자열 생성
        - 문자열을 3등분하여 가운데 부분을 공백으로 변경
        - 각 선에 대해 2번을 반복하고 선의 길이가 1일 때 멈춤
* */
public class No4779 {
    /*
        - 각 재귀마다 총 길이 / 3을 한 값인 sublength 저장
        - sublength ~ sublength * 2의 값을 공백으로 대체
        - 재귀함수(왼쪽) + 가운데 공백 만큼 공백 + 재귀함수(오른쪽)
    * */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = br.readLine()) != null){
            int N = Integer.parseInt(input);
            String str = "-".repeat((int)Math.pow(3, N));
            String res = recursion(str, str.length());
            System.out.println(res);
        }
    }

    private static String recursion(String string, int length) {
        if(string.equals("-")) return "-";
        int sublength = length / 3;
        StringBuilder sb = new StringBuilder();
        String left = string.substring(0, sublength); // 왼쪽 추출
        String mid = string.substring(sublength, sublength * 2).replace("-", " "); // 가운데 공백으로 대체
        String right = string.substring(sublength * 2); // 오른쪽 추출
        // 문자열 더하기 연산의 성능이 좋지 않아 StringBuilder 사용
        return sb.append(recursion(left, left.length())).append(" ".repeat(mid.length())).append(recursion(right, right.length())).toString();
    }
}
