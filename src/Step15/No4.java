package Step15;

import java.io.*;
import java.util.Arrays;

/*
    문제 접근
        입력
            - 첫째 줄 : 이미 심어져이쓴 가로수의 수를 나타내는 하나의 정수 N (3 <= N <= 100,000)
            - ~ N번째 줄 : 가로수의 위치가 양의 정수로 주어짐 ( <= 1,000,000,000)
            - 가로수 위치를 나타내는 정수는 모두 다름(중복 X)
            - 오름차순으로 주어짐
        출력
            - 모든 가로수가 같은 간격이 되도록 새로 심어야하는 가로수의 최소수를 첫 번째 줄에 출력
* */
public class No4 {
    /*
        문제 해결
            - 각각의 가로수 간격의 최대 공약수를 구함
            - (가장 큰 가로수 위치 - 가장 작은 가로수 위치) / 최대공약수 + 1 = 총 가로수의 개수
            - 총 가로수 개수 - N = 심어야하는 가로수 개수
    * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int gcd = arr[1] - arr[0];
        for(int i = 1; i < N - 1; i++){
            gcd = gcd(gcd, arr[i + 1] - arr[i]);
        }

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        System.out.println((max - min) / gcd + 1 - N);
    }

    private static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}
