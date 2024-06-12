package Step5;

import java.util.Map;
import java.util.Scanner;

public class No10_2GPT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String alpha = scan.nextLine();
        scan.close();

        int[] dial = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};

        int sum = 0;
        for(char ch : alpha.toCharArray()){
            sum += dial[ch - 'A'];
        }
        System.out.println(sum);
        // 문자열에서 각각 char 뽑은 뒤 - 'A'(65)를 해주면 A~Z까지 - 'A'를 하면
        // 0~25번 배열에 저장을 할 수 가 있고,
        // 각 배열에 시간을 맵핑하면 내 풀이처럼 불필요한 반복문을 줄일 수도 있고
        // 코드가 훨씬 간결해져 가독성이 좋아짐
    }
}
