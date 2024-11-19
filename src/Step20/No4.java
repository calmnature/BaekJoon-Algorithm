package Step20;

import java.io.*;
import java.util.*;

/*
    문제 접근
        - 입력
            - 첫째 줄 : 수의 개수 N (1 <= N <= 500,000)
            - ~ N번째 줄 : 정수( -4,000 <= 정수 <= 4,000)
        - 출력
            - 첫째 줄 : 산술평균 출력 (소수점 첫째 자리 반올림)
            - 둘째 줄 : 중앙값 출력
            - 셋째 줄 : 최빈값 출력 (여러 개 있을 경우 두 번째로 작은 값)
            - 넷째 줄 : 범위 출력
* */
public class No4 {
    /*
        문제 해결
            - 배열로 저장 후 정렬
            - 산술 평균 : 모두 더한 값 / N = 결과 반올림
            - 중앙값 : 배열 길이(N) / 2 인덱스의 값
            - 최빈값 : 배열의 최빈값을 ArrayList에 저장, 두 번째로 작은 값 출력
            - 범위 : 가장 큰 값 - 가장 작은값
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int sum = Arrays.stream(arr).sum();
        int avg = (int) Math.round(sum * 1.0 / N);
        sb.append(avg).append("\n");

        sb.append(arr[N / 2]).append("\n");

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int maxFreq = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            maxFreq = maxFreq < value ? value : maxFreq;
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value == maxFreq) list.add(entry.getKey());
        }
        Collections.sort(list);
        sb.append(list.size() == 1 ? list.get(0) : list.get(1)).append("\n");

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        sb.append(max - min);

        System.out.println(sb);
    }
}
