package Problem_Number;

import java.io.*;
import java.util.*;
/*
    - **문제 접근**
        - 가장 작은 값을 0으로 설정하고 그 다음 작은 값을 1로 설정하면서 멀리 떨어진 좌표들을 0~?까지 압축하는 것으로 예상 됨
        - 동일한 값이 주어진다면 같은 좌표로 취급
        - **N은 최대 100만**개의 숫자가 주어질 수 있으므로 **시간 복잡도가 O(N$^2$)인 알고리즘을 선택 시** **1조번 연산(10000초)가 되어 시간 초과**가 나올 것
        - 출력 ⇒ 압축한 좌표를 공백으로 출력
* */
public class No18870 {
    /*
        - **문제 해결**
            - 입력받은 X좌표를 오름차순으로 정렬
                - 선택, 삽입, 버블 정렬 사용 시 시간 초과
                - **최소 O(NlogN)이상의 알고리즘 사용 필요 (Heap, Quick)
                →** log1000000 = 20 → 100만 * 20(NlogN) = 2000만 ⇒ 0.2초
                - Arrays.sort() 정렬은 Dual-pivot quick sort라고 하는데, 시간의 복잡도가 최악의 경우 O(N$^2$)이 나온다고 함
                - Collections.sort() 정렬은 Tim-sort로 삽입 정렬 + 합병 정렬로 **최선의 경우 O(n), 최악의 경우 O(nlogn)**이기에 Collections.sort() 사용
            - 가장 작은 숫자를 0으로 설정하여 순차적으로 1씩 증가 시켜야 함
                → 단, 같은 값의 좌표는 동일
            1. 같은 숫자가 입력될 수 있어 Set에 넣어 중복을 제거
            2. Set을 List로 변환하여 오름차순 정렬
            3. List에 있는 값을 Key, 압축 좌표를 0부터 1씩 증가 ⇒ Map에 저장
            4. 입력받았던 배열의 값을 Key로 추출한 Value값을 StringBuilder에 추가
    * */
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        // 입력값의 중복을 제거할 set
        Set<Integer> set = new HashSet<>();
        // 압축 좌표를 저장할 Map
        Map<Integer, Integer> compressMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Set에 값을 추가하여 중복 제거
        for(int i = 0; i < N; i++)
            set.add(arr[i]);

        // Set -> List로 변환 후 오름차순 정렬
        int[] nonDuplicate = new int[set.size()];
        int idx = 0;
        for(int num : set)
            nonDuplicate[idx++] = num;
        heapsort(nonDuplicate);

        // 이전 좌표
        int prevCoordinate = 0;
        // List에 있는 값을 순차적으로 Value를 넣고 1씩 증가
        for(int key : nonDuplicate)
            compressMap.put(key, prevCoordinate++);

        // 결과 저장
        for(int i = 0; i < N; i++)
            sb.append(compressMap.get(arr[i])).append(" ");

        System.out.println(sb);
    }

    private static void heapsort(int[] arr) {
        int size = arr.length;
        if(size < 2) return;

        int parentIdx = getParent(size);
        for(int i = parentIdx; i >= 0; i--){
            heapify(arr, i, size - 1);
        }

        for(int i = size - 1; i > 0; i--){
            swap(arr, i, 0);
            heapify(arr, 0, i - 1);
        }
    }

    private static void heapify(int[] arr, int parentIdx, int lastIndex) {
        while(parentIdx * 2 + 1 <= lastIndex){
            int leftChildIdx = parentIdx * 2 + 1;
            int rightChildIdx = parentIdx * 2 + 2;
            int largestIdx = parentIdx;

            if(arr[leftChildIdx] > arr[largestIdx])
                largestIdx = leftChildIdx;

            if(rightChildIdx <= lastIndex && arr[rightChildIdx] > arr[largestIdx])
                largestIdx = rightChildIdx;

            if(parentIdx != largestIdx){
                swap(arr, parentIdx, largestIdx);
                parentIdx = largestIdx;
            } else return;
        }
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    private static int getParent(int idx) {
        return (idx - 1) / 2;
    }
}
