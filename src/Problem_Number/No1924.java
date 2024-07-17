package Problem_Number;

import java.util.Scanner;

/*
    - 배열 week = [일,월,화,수,목,금,토,일]
    - 2월 5일 = 1월(31일) + 5일 ⇒ 36일 % 7 = 1(월요일)
    - 3월 14일 = 1월(31일) + 2월(28일) + 14일 ⇒ 73일 % 7 = 3(수요일)
    - 입력받은 x(월)를 일자로 환산 + y(일) % 7(일주일) = index ⇒ week[index] 출력
* */
public class No1924 {
    public static void main(String[] args) {
        String[] week = new String[]{"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"}; // 요일 배열 선언
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt(), y = scan.nextInt(); // 월, 일 저장
        scan.close();
        int totalDay = calcMonth(x) + y; // x-1월까지의 총 Day 계산 + 일 저장
        int idx = totalDay % week.length; // 총 날짜 % 7의 값 저장
        System.out.println(week[idx]); // week의 idx를 출력하면 해당 요일
    }

    private static int calcMonth(int x) {
        int[] month = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 0~12월 Day 배열 선언
        int sumDay = 0;
        for(int i = 1; i < x; i++){ // 사용자 입력 월 - 1이전 월까지의 총 날짜 계산
            sumDay += month[i];
        }
        return sumDay;
    }
}
