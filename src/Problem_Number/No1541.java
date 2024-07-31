package Problem_Number;

import java.io.*;

/*
    - **문제 접근**
        - 입력 ⇒ 피연산자와 연산자가 1줄에 모두 주어짐
        - 출력 ⇒ 괄호를 친다고 가정했을 때 가장 최솟값을 출력
* */
public class No1541 {
    /*
        - **문제 해결**
            - 괄호를 치려면 마이너스(-) 이후에 마이너스(-)가 다시 등장하기 전까지 그 범위 내의 플러스(+)들을 모두 더한 뒤 빼주는 것이 가장 최솟값을 만드는 방법
            - split을 이용하여 -를 기준으로 모두 나누고, 나뉘어진 상태에서 +를 기준으로 다시 나눠서 모두 더하기
            - 첫 번째값을 제외한 모든 값 빼기
    * */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // -를 기준으로 split
        String[] splitStr = br.readLine().split("-");
        // split한 문자열을 계산하여 int 배열로 변환
        int[] intArr = subSum(splitStr);

        // 향상 for문을 쓰려고 첫 번째값(무조건 양수)*2
        // 첫번째를 포함한 배열에 있는 모든 값을 뺄 것이기 때문
        int minValue = intArr[0] * 2;
        for(int num : intArr)
            minValue -= num;

        System.out.println(minValue);
    }

    private static int[] subSum(String[] strArr){
        int[] arr = new int[strArr.length];

        for(int i = 0; i < strArr.length; i++){
            // -로 나뉜 문자열 배열에서 i번째 있는 값을 +로 다시 나눔
            String[] sub = strArr[i].split("\\+");
            int sum = 0;
            for (String string : sub) // 모두 더하기
                sum += Integer.parseInt(string);
            // i번째 방에 모두 더한 값 추가
            arr[i] = sum;
        }

        return arr;
    }
}
