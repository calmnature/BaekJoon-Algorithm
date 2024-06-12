package Step5;

import java.util.Arrays;
import java.util.Scanner;

public class No6 {
    public static void main(String[] args) {
        // 알파벳 찾기
        // a : 97, b : 98
        // 각 글자에 -97을 하고 현재 Index를 new int[26] 배열에 index를 저장
        // 첫 등장 위치만 잡기 때문에 배열의 인덱스가 -1이 아니라면 contiue
        // new int[26] -> -1로 초기화
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        scan.close();
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for(int i = 0; i < str.length(); i++){
            int index = (int)str.charAt(i) - 97;
            if(arr[index] != -1) continue;
            arr[index] = i;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            if(sb.length() > 0)
                sb.append(" ");
            sb.append(i);
        }
        System.out.println(sb);
    }
}
