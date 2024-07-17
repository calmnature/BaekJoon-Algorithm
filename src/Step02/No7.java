package Step02;

import java.util.Arrays;
import java.util.Scanner;
/*
            - Counting sort를 이용하여 문제를 풀 수 있을 것 같음
            - 각 나온 수의 인덱스를 1씩 증가 시킴
            - 특정 인덱스의 값이 3일 경우 같은 눈 3
            - 특정 인덱스의 값이 2일 경우 같은 눈 2
            - 인덱스의 Max 값이 1일 경우 가장 높은 인덱스 출력
        * */
public class No7 {
    public static void main(String[] args) {
        int[] A = new int[7];
        final int DICE_COUNT = 3;
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < DICE_COUNT; i ++){
            A[scan.nextInt()]++;
        }
        scan.close();
        int max = Arrays.stream(A).max().getAsInt(); // 배열에서 가장 높은 값 저장
        int diceValue = searchDiceValue(A, max); // 계산할 dice 값 추출 함수
        int res = 0;
        if(max == 1)
            res = diceValue * 100;
        else if(max == 2)
            res = 1000 + (diceValue * 100);
        else
            res = 10000 + (diceValue * 1000);
        System.out.println(res);
    }

    private static int searchDiceValue(int[] A, int max){
        // 모두 다른 눈일 경우 최댓값을 구해야하기 때문에
        // i = 배열의 마지막 인덱스부터 탐색
        for(int i = A.length-1; i >= 1; i--){
            if(A[i] == max)
                return i;
        }
        return -1;
    }
}
