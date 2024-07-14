package Step11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for(int i = 0; i < N-2; i++){
            if(max == M) break; // max의 값이 M과 같다면 더 이상 비교의 핋요성이 없음
            for(int j = i+1; j < N-1; j++){
                for(int k = j+1; k < N; k++){
                    int tmp = A[i] + A[j] + A[k];
                    if(tmp <= M && tmp > max){
                        max = tmp;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
