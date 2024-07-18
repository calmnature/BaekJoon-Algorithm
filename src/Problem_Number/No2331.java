package Problem_Number;

import java.util.*;
/*
    - 문제 접근
        - 처음 입력받은 수에서 각 자리마다 P제곱을 하여 모두 더함
        - 수열을 계속하여 진행하다보면 반복되는 수열이 등장
        - 반복되는 부분을 제외한 반복되지 않은 부분의 개수를 출력하는 문제
* */
public class No2331 {
    /*
        - 문제 해결
            - 무한대로 저장할 ArrayList 한 개 생성
            - 반복된 수를 저장할 반복ArrayList 생성
            - 무한 반복 List에서 마지막 값을 뽑아 String으로 받고, 문자열의 길이 만큼 반복
                - 0~length-1번까지 charAt() - ‘0’을 하여 정숫값을 저장
                - 해당 정수값을 Math.pow() 함수로 P만큼 제곱한 값을 sum에 누적
            - 무한 반복 리스트에 포함이 된다면 반복 리스트에 저장
                - 단, 반복 리스트에도 포함이 된다면 이미 1번의 루프를 돌았기에 반복문 종료
    * */
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        int firstNum = scan.nextInt();
        int square = scan.nextInt();
        List<Integer> list = new ArrayList<>();
        List<Integer> duplicateList = new ArrayList<>();
        list.add(firstNum);
        int idx = 0;
        while(true){
            String str = list.get(idx).toString();
            int sum = 0;
            // 각 자리를 square만큼 제곱하여 누적
            for(int i = 0; i < str.length(); i++){
                int num = str.charAt(i) - '0';
                sum += (int) Math.pow(num, square);
            }
            // list에 포함되는 값이라면
            if(list.contains(sum)){
                // duplicateList에 포함되는 값이라면 1루프가 돌았으므로 반복문 종료
                if(duplicateList.contains(sum)) break;
                // 포함되지 않으면 리스트에 추가
                duplicateList.add(sum);
            }
            list.add(sum); // 리스트에 추가
            idx++; // 인덱스 1증가
        }
        // List to Set
        Set<Integer> set = new HashSet<>(list);
        // set.removeAll(duplicateList)와 동일
        duplicateList.forEach(set::remove);
        // 사이즈 출력
        System.out.println(set.size());
    }
}
