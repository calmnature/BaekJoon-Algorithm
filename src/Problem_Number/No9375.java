package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 중복되지 않는 경우의 수를 구해야하기 때문에 조합으로 접근 필요
        - 첫 번째 테스트 케이스는 다음과 같은 경우의 수를 가짐
        → hat, sunglasses, turban, (hat, sunglasses), (turban, sunglasses)
        - headgear의 경우의 수 ⇒ hat, turbun, null(안 썼을 때) ⇒ 3개
        - eyewear의 경우의 수 ⇒ sunglasses, null(안 썼을 때) ⇒ 2개
        - 3C1(headgear 경우의 수 중 1개 선택) * 2C1(eyewear 경우의 수 중 1개 선택)
        ⇒ 3 * 2 - 1(headgear, eyewear 모두 안 쓴 경우 = 알몸) = 5
* */
public class No9375 {
    /*
        - **문제 해결**
            - Map을 이용하여 저장
            - 같은 종류의 옷 끼리는 조합할 수 없으므로 앞의 옷 이름은 필요 없이 뒤의 옷 종류(headgear, eyewear)만 필요
            - 옷 종류마다 수량을 저장하고 최종적으로 옷 종류마다의 경우의 수를 모두 곱한 뒤 - 1(아무것도 입지 않은 경우 제외)
    * */
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++){
            Map<String, Integer> fassion = new HashMap<>();
            int count = Integer.parseInt(br.readLine());

            for(int j = 0; j < count; j++){
                String kind = br.readLine().split(" ")[1]; // 옷의 종류만 저장
                fassion.put(kind, fassion.getOrDefault(kind, 0) + 1); // 옷의 종류(key)의 value 1 증가
            }

            int combination = 1;
            for(int value : fassion.values()) combination *= value + 1; // 모든 경우의 수 곱셈
            sb.append(combination - 1).append("\n"); // 아무 것도 입지 않은 경우(알몸) 제외
        }

        System.out.println(sb);
    }
}
