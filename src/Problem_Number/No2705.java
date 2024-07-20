package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
    - **문제 접근**
        - 중앙값을 기준으로 좌우가 동일해야 함
        - 1 2 3 2 1 ⇒ 1 2 와 2 1로 일치하지 않아 팰린드롬 파티션이 아님
        - 1 2 1 3 1 2 3 ⇒ 1 2 1과 1 2 1로 일치하여 팰린드롬 파티션
* */
public class No2705 {
    /*
        - N - 2의 값의 중앙값에 +2를 더한 것과, N / 2의 경우의 수를 더해주면 N의 값이 나옴
        - 즉, N[6] = N[4] + N[3]의 식이 도출
        - 메모리제이션 기법으로 Map을 이용하여 N[i]의 값(경우의 수)을 Map에 저장하고 Map에 있는 값이라면 get으로 리턴
    * */
    static Map<Integer, Integer> memorization = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            System.out.println(Partition(Integer.parseInt(br.readLine())));
        }
        br.close();
    }

    private static int Partition(int N) {
        if(N == 0 || N == 1) return 1;
        if(memorization.containsKey(N)) // Map에 N이 있다면
            return memorization.get(N); // 해당 value를 리턴하여 불필요한 연산 방지

        for(int i = 2; i <= N; i++){
            int res = Partition(i - 2) + Partition(i / 2); // N = (N-2) + (N/2)
            memorization.put(i, res); // i번의 경우의 수를 저장
        }
        return memorization.get(N); // N의 값 반환
    }
}