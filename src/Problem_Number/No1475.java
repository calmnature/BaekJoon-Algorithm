package Problem_Number;

import java.util.Arrays;
import java.util.Scanner;

/*
    - 한 세트 = 0 ~ 9번
    - 6번과 9번은 서로 바꿔 사용 가능
    - 방 번호는 100만 이하의 숫자 ⇒ 동일한 숫자로 나오면 999,999 같은 식으로 플라스틱 세트는 최대 6개
* */
public class No1475 {
    /*
    - 0 ~ 9번까지의 배열 생성
    - Counting sort 하는 것처럼 입력받은 숫자를 각 방번호 index에 추가
        - 단, 6과 9일 경우 더한 뒤 /2 + %2를 한 값을 동일하게 저장
        - 6이 6개, 9가 0개일 경우 9로 대체하여 3개의 세트면 되기 때문
    - 배열에서 가장 숫자가 큰 것의 인덱스를 저장
    * */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String roomNumber = scan.next();
        int[] frequency = new int[10]; // 0 ~ 9번방 배열 생성
        for(int i = 0; i < roomNumber.length(); i++){
            int idx = roomNumber.charAt(i) - '0'; // 각 방번호 값에 따른 인덱스 증가
            frequency[idx]++;
        }
        int sum = frequency[6] + frequency[9]; // 6과 9가 나온 값 합침
        int set = sum / 2 + sum % 2; // 홀수일 경우 +1도 해주어야 하기 때문에 % 연산까지 더해 넣기
        frequency[6] = set; frequency[9] = set; // 6과 9에 동일하게 셋팅
        int max = Arrays.stream(frequency).max().getAsInt(); // 가장 많이 필요한 숫자 추출
        System.out.println(max);
    }
}
