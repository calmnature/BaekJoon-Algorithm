package Step6;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class No7 {
    public static void main(String[] args) throws IOException {
        // 그룹단어 체커
        // 모두 소문자로 입력, 연속되어야 함
        // 문제는 이전에 나왔던 알파벳이면 그룹단어가 아님
        // abca => 그룹단어 X / aabc => 그룹단어
        Scanner scan = new Scanner(System.in);
        // 조건1 : 현재 index == 이전 index => 통과(무시)
        // 조건2 : 현재 index != 이전 index => 이전에 나왔던 알파벳이면 => 그룹단어 X + break
        int N = scan.nextInt();
        scan.nextLine();
        int cnt = 0;
        for(int i = 0; i < N; i++){
            char[] arr = scan.nextLine().toCharArray();
            boolean[] bool = new boolean[26];
            if(arr.length == 1){
                cnt++; continue;
            }
            bool[arr[0]-97] = true;
            for(int j = 1; j < arr.length; j++){
                if(arr[j-1] != arr[j] && bool[arr[j]-97]){ // 이전 != 현재 일 때, 나왔던 알파벳?
                    break;
                } else if(j + 1 == arr.length){
                    cnt++;
                }
                bool[arr[j]-97] = true;
            }
        }
        scan.close();
        System.out.println(cnt);
    }
}
