package Step10;

import java.util.Scanner;

public class No4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 입력 최대 숫자는 10억
        // 10억이 들어올 경우 결과는 40억으로 int의 범위를 벗어나기에 Long으로 저장
        Long res = scan.nextLong() * 4;
        System.out.println(res);
        scan.close();
    }
}
