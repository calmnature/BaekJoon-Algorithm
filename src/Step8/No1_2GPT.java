package Step8;

import java.util.Scanner;

public class No1_2GPT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        String N = scanner.next();
        int B = scanner.nextInt();

        // B진법 수 N을 10진법으로 변환
        int decimalValue = Integer.parseInt(N, B);

        // 결과 출력
        System.out.println(decimalValue);

        scanner.close();
    }
}
