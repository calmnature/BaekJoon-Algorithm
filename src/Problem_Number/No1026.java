package Problem_Number;

import java.util.*;
import java.io.*;

/*
    - **문제 접근**
        - A의 배열을 재배치하여 같은 인덱스끼리 곱한 값의 최소값을 구해야 함
        - A 배열만 재배치가 가능하고, B 배열은 재배치를 하지 말라는 말에 현혹되면 안 됨
        - 서로의 인덱스를 곱했을 때 최소값이 나오려면 다음과 같음
            - A배열에서 제일 큰 값 * B배열에서 제일 작은 값
            - A배열에서 제일 작은 값 * B배열에서 제일 큰 값
        - 즉, 서로가 반대로 정렬이 될 경우 S의 최솟값을 구할 수 있음
* */
public class No1026 {
    /*
        - **문제 해결**
            - A배열은 오름차순으로 Selection Sort로 구현
            - B배열은 내림차순으로 Insertion Sort로 구현
            - 두 정렬 모두 시간 복잡도는 O(N^2) → 2N^2이지만 시간 복잡도에서 상수는 무시 되기 때문에 O(N^2)
            - N의 최댓값은 50으로 2500번의 연산 ⇒ 0.000025초 (1억번의 연산 = 1초)로 시간 제한 내에 충분
    * */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        selection_sort_asc(A);
        insertion_sort_desc(B);

        System.out.println(calcMinSum(A, B));
    }

    private static void swap(int[] arr, int idx1, int idx2){
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    private static void selection_sort_asc(int[] A){
        // 선택 정렬은 현재 인덱스를 기준으로
        // 가장 마지막 인덱스까지 중 제일 작은 값을 찾아
        // 현재 인덱스와 제일 작은 값의 인덱스를 바꾸어주어야 함
        for(int i = 0; i < A.length - 1; i++){
            int min_idx = i;
            for(int j = i + 1; j < A.length; j++){
                // 최소 값의 인덱스보다 A[j]가 더 작으면
                // min_idx에 j를 저장
                if(A[min_idx] > A[j]) min_idx = j;
            }
            // 위의 반복문에서 배열의 끝까지 탐색하여
            // 가장 작은 값의 인덱스와 현재 인덱스를 변경
            swap(A, i, min_idx);
        }
    }

    private static void insertion_sort_desc(int[] B) {
        // 삽입 정렬은 현재 target을 기준으로 그 앞의 값들과 비교
        // target보다 앞의 값이 더 작으면 변경
        for(int i = 1; i < B.length; i++){
            // 0번째 인덱스는 앞에 비교할 것이 없기에 1부터 시작
            // 현재 인덱스를 target으로 설정
            int target_idx = i;
            for(int j = i - 1; j >= 0; j--){
                // target 인덱스의 값이 B[j]보다 더 크다면 변경 필요 -> 오름차순이기 떄문에
                if(B[target_idx] > B[j]){
                    swap(B, target_idx, j);
                    // 변경 후 target_idx는 한 칸 땡겨주어야 함
                    target_idx = j;
                }
                else break; // target_idx의 값이 j보다 작을 경우 그 앞과 비교할 필요가 없음
            }
        }
    }

    private static int calcMinSum(int[] A, int[] B) {
        int sum = 0;
        for(int i = 0; i < A.length; i++)
            sum += A[i] * B[i];
        return sum;
    }
}
