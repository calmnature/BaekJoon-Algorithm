package Problem_Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    - 각 케이스마다 배열을 생성하여 ArrayList에 저장
    - 각 케이스의 평균을 배열로 저장
    - 평균과 각 점수를 비교하여 초과하는 학생 수만 카운트
    - 평균 초과 학생 / 배열 길이 * 100 ⇒ 소수점 셋째자리 표현
* */
public class No4344 {
    static int T; // 테스트 케이스 개수
    static int[] avgArr; // 테스트 케이스별 평균 저장
    static double[] avgPercent; // 테스트 케이스별 평균 초과 학생 백분율 계산
    static List<int[]> list = new ArrayList<>(); // 테스트 케이스 저장 리스트
    public static void main(String[] args) {
        inputInit(); // 입력 받는 메서드
        calcAvgPercent(); // 평균 넘는 학생 비율 계산 메서드
        for(int i = 0; i < T; i++){
            System.out.println(String.format("%.3f",avgPercent[i]) + "%");
        }
    }
    private static void inputInit(){
        Scanner scan = new Scanner(System.in);
        T = scan.nextInt();
        avgArr = new int[T];
        avgPercent = new double[T];
        for(int i = 0; i < T; i++){
            int N = scan.nextInt();
            int[] A = new int[N];

            int sum = 0;
            for(int j = 0; j < N; j++){
                A[j] = scan.nextInt(); // 학생 점수 배열에 저장
                sum += A[j]; // 합계 저장
            }
            list.add(A); // List에 배열 추가
            avgArr[i] = sum / A.length; // 각 테스트케이스별 평균 저장
        }
        scan.close();
    }
    private static void calcAvgPercent(){
        for(int i = 0; i < T; i++){
            int[] A = list.get(i); // 테스트 케이스별 배열 추출
            int count = 0; // 평균 넘는 학생 카운트
            int avg = avgArr[i]; // 평균 점수 추출
            for (int j : A) {
                if (j > avg) { // 학생 점수가 평균 초과일 경우
                    count++;
                }
            }
            avgPercent[i] = count * 1.0 / A.length * 100; // 백분율로 저장
        }
    }
}
