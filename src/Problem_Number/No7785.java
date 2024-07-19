package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
    - **문제 접근**
        - 출입 기록의 수가 최대 10$^6$이므로 시간 복잡도가 O(N$^2$)이면 1조로 시간 초과
        - enter와 leave가 찍힌 사원은 퇴근한 사원
        - 대소문자가 다른 경우 다른 사람
* */
public class No7785 {
    /*
        - 동명이인이 없으니 Set으로 저장하고 한 번 더 나올 경우 삭제
        - 정렬을 하기 위해 Set → List로 변경
        - Comparator.reverseOrder를 이용하여 내림 차순 정렬
    * */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> overWork = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String employee = br.readLine().split(" ")[0];
            if(overWork.contains(employee)){ // set에 있을 경우 삭제
                overWork.remove(employee);
                continue;
            }
            overWork.add(employee); // 없을 경우 추가
        }
        List<String> overWorkList = new ArrayList<>(overWork); // 리스트로 변경
        overWorkList.sort(Comparator.reverseOrder()); // 역순 정렬
        StringBuilder sb = new StringBuilder();
        for (String emp : overWorkList) {
            sb.append(emp).append("\n");
        }
        System.out.println(sb);
    }
}
