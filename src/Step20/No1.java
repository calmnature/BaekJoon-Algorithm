package Step20;

import java.io.*;
import java.util.*;

/*
    문제 접근
        - 진짜 약수 : 1과 자기 자신을 제외한 나머지 약수
        - 입력
            - 첫째 줄 : 진짜 약수의 개수 N(1<= N <= 50)
            - 둘째 줄 : N의 진짜 약수들이 공백으로 주어짐 ( 2 <= 진짜 약수 <= 1,000,000)
        - 출력
            - N 출력
            - 항상 32비트 부호있는 정수로 표현 가능(int 범위 이내라는 뜻)
* */

public class No1 {
    /*
        문제 해결
            - 첫 번째 값 * 마지막 값 / 두 번째 값 * 마지막 -1번째 값 / ... = N
            - 단, 진짜 약수가 랜덤으로 주어지기 때문에 정렬 필요
            - 둘 쨰줄을 배열로 만든 뒤 정렬해서 첫 번째 값 * 마지막 값을 출력
    * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        System.out.println(arr[0] * arr[arr.length -  1]);
    }
}
