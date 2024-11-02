package Step14;

import java.io.*;
import java.util.*;
/*
    문제 접근
        입력
            첫째 줄 : 숫자 카드의 개수(1 <= N <= 500,000)
            둘째 줄 : 숫자 카드에 적혀있는 정수(-10,000,000 ~ 10,000,000)
            셋째 줄 : M(1 <= M <= 500,000)
            넷째 줄 : 상근이가 가진 숫자카드인지 아닌지를 구해야할 M개의 정수(-10,000,000~10,000,000)
        출력
            첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 가지고 있으면 1, 아니면 0으로 공백으로 구분해 출력
* */
public class No1 {
    /*
        문제 해결
            상근이가 가진 카드의 숫자들(둘째 줄)을 N번(첫째 줄)만큼 Set에 추가
            주어진 숫자 카드(넷째 줄)을 M번 반복하여 Set에 있으면 1, 없으면 0을 StringBuilder에 추가하여 출력
    * */
    public static void main(String[] args) throws IOException{
        Set<Integer> numberSet = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            numberSet.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int number = Integer.parseInt(st.nextToken());
            if(numberSet.contains(number))
                sb.append("1").append(" ");
            else
                sb.append("0").append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
    }
}
