package Step14;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/*
    문제 접근
        입력으로 주어지는 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않고, 집합 S에 중복된 문자열은 주어지지 않음
        입력
            첫째 줄 : 문자열 개수 N과 M(1 <= N <= 10,000, 1 <= M <= 10,000)
            N개의 줄 : 집합 S에 포함되어 있는 문자열이 주어짐
            M개의 줄 : 검사해야하는 문자열
        출력
            M개의 문자열 중 총 몇 개가 집합 S에 포함되는 지 출력
* */
public class No2 {
    /*
        문제 해결
            1 ~ N개의 줄이 집합 S → Set에 추가
            N+1번째 줄 부터 M개까지의 문자열이 집합 S에 포함되는 지 확인 → 문자열 배열에 저장하여 0 ~ M-1번까지 Set에 포함되는 지 확인하여 숫자 카운팅
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = input[0], M = input[1];

        Set<String> S = br.lines()
                .limit(N)
                .collect(Collectors.toSet());

        long cnt = br.lines()
                .limit(M)
                .filter(S::contains)
                .count();

        System.out.println(cnt);
    }
}
