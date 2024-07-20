package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    - **문제 접근**
        - N이 1인 경우에는 순서대로 0, 1, 2, 3을 출력하도록 설정
        - N이 2이상인 경우 2^(N-1)의 크기로 4등분을 한 후 재귀 함수
* */
public class No1074 {
    /*
        - 하나 하나 순차적으로 진행을 하게 되면 N의 최대값이 15로  2^15이 되어 Stack Overflow가 발생
        - 핵심은 구해야 할 row, col을 가지고 몇 사분면에 포함이 되는 지 확인
        - 사분면이 확인 되면 다시 사분면을 나누고 계속하여 사분면을 쪼개고 사분면 위치에 따른 값을 더해주는 것이 재귀 함수의 포인트
        - 사분면의 시작 값은 다음과 같다
            - 1사분면 시작값 ⇒ (2^N / 2) * (2^N / 2) * 0
            - 2사분면 시작값 ⇒ (2^N / 2) * (2^N / 2) * 1
            - 3사분면 시작값 ⇒ (2^N / 2) * (2^N / 2) * 3
            - 4사분면 시작값 ⇒ (2^N / 2) * (2^N / 2) * 4
    * */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream((br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        int N = input[0], targetRow = input[1], targetCol = input[2];
        System.out.println(Z(N, targetRow, targetCol));
    }

    private static int Z(int N, int row, int col){
        if(N == 1)
            return row == 0 ? col == 0 ? 0 : 1 : col == 0 ? 2 : 3;
        int size = (int)Math.pow(2, N-1); // 전체 길이의 절반으로 row, col을 확인하여 몇 사분면인지 확인
        if(row < size){ // 행이 절반 사이즈보다 작다면 -> 가운데 기준 윗쪽 -> 1, 2사분면
            if(col < size){ // 열이 절반 사이즈보다 작다면 -> 가운데 기준 왼쪽 -> 1사분면
                // 1사분면
                // 1사분면을 다시 사분면으로 나누기 위해 N - 1 전달
                return Z(N-1, row, col) + size * size * 0;
            }else { // 열이 절반 사이즈보다 크다면 -> 가운데 기준 오른쪽 -> 2사분면
                // 2사분면
                // N-1을 보내 사이즈가 1/2로 더 줄게 되면,
                // 현재 size보다 큰 col은 IndexOutOfBoundsException이 발생
                // 따라서, col에서 size만큼을 뺴주어야 함
                return Z(N-1, row, col - size) + size * size * 1;
            }
        }else {// 행이 절반 사이즈보다 크다면 -> 가운데 기준 아래쪽 -> 3, 4사분면
            if(col < size){ // 열이 절반 사이즈보다 작다면 -> 가운데 기준 왼쪽 -> 3사분면
                return Z(N-1, row - size, col) + size * size * 2;
            } else { // 열이 절반 사이즈보다 크다면 -> 가운데 기준 왼쪽 -> 4사분면
                return Z(N-1, row - size, col- size) + size * size * 3;
            }

        }
    }
}
