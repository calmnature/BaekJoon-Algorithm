package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 입력
            - 숫자의 개수 N가 홀수개로 주어짐
            - N개의 숫자들 입력
        - 출력
            1. 평균 출력 → 소수점 첫째자리 반올림
            2. 중앙값 출력
            3. 최빈값 출력 → 여러 개일 경우 두 번째로 작은 값
            4. 범위 출력
* */
public class No2108 {
    /*
        - **문제 해결**
            - 입력 받은 후 정렬
            - 평균 → 스트림 사용
            - 중앙값 → 중앙 인덱스 출력
            - 최빈값들을 리스트에 저장하여 정렬, 1번째 인덱스 출력
            - 범위 → MAX, MIN 값을 구해서 차이를 구함
    * */
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int[] countArr = new int[8001];
        List<Integer> frequencyList = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
            if (value <= 0)
                countArr[Math.abs(value)]++;
            else
                countArr[value + 4000]++;
            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        Arrays.sort(arr);

        // 평균
        long avg = Math.round(Arrays.stream(arr).average().getAsDouble());
        sb.append(avg).append("\n");

        // 중앙값
        sb.append(arr[arr.length/2]).append("\n");

        // 빈도 수
        int maxFrequency = Arrays.stream(countArr).max().getAsInt();
        for(int i = 0; i < countArr.length; i++){
            if(maxFrequency == countArr[i]){
                if(i <= 4000)
                    frequencyList.add(i * -1);
                else
                    frequencyList.add(i - 4000);
            }
        }
        Collections.sort(frequencyList);
        int secondFreequency = frequencyList.size() == 1 ? frequencyList.get(0) : frequencyList.get(1);
        sb.append(secondFreequency).append("\n");

        // 범위
        sb.append(Math.abs(max - min)).append("\n");

        System.out.println(sb);
    }
}
