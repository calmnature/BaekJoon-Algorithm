package Problem_Number;

import java.io.*;

/*
    - **문제 접근**
        - 조건
            - 해당 단어의 내에서 재 배열
            - 첫글자와 마지막 글자는 동일
            - 각 단어의 모음을 제거 시 문자열이 동일해야 함
        - 입력
            - 단어의 길이
            - 문자열1
            - 문자열2
        - 출력 ⇒ 조건 만족 시 YES, 불만족 시 NO
* */
public class No25178 {
    /*
        - **문제 해결**
            - 첫 번째와 마지막 글자가 동일한 지 확인하는 메서드
            - 모음의 개수를 카운팅 하는 메서드 → 단어 내에서 재배열
                - 단어 내에서 재배열이기 때문에 원래 문자열에 a가 1개 있는데 비교할 문자열에 a가 2개 있어서는 안 됨
            - 모음을 모두 제거 했을 때 문자열이 동일한 지 확인하는 메서드 → 모음 제거 시 동일
    * */
    static int length;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        length = Integer.parseInt(br.readLine());
        String str1 = br.readLine();
        String str2 = br.readLine();

        boolean flcFlag = firstAndLastCheck(str1, str2); // 처음과 마지막 글자 확인 Flag
        boolean vccFlag = vowelCountCheck(str1, str2); // 모음 개수 확인 Flag
        boolean vdcFlag = vowelDeleteCheck(str1, str2); // 모음 삭제 시 문자열 동일 확인 Flag

        System.out.println(flcFlag && vccFlag && vdcFlag ? "YES" : "NO");
    }

    private static boolean firstAndLastCheck(String str1, String str2){
        // 첫 번째와 마지막 글자가 같으면 true, 아니면 false
        return str1.charAt(0) == str2.charAt(0) && str1.charAt(length - 1) == str2.charAt(length - 1);
    }

    private static boolean vowelCountCheck(String str1, String str2){
        int[] str1VowelCount = vowelCount(str1);
        int[] str2VowelCount = vowelCount(str2);

        // 각 문자열의 모음의 개수가 다를 경우 false
        for(int i = 0; i < 5; i++)
            if(str1VowelCount[i] != str2VowelCount[i]) return false;

        return true;
    }

    private static int[] vowelCount(String str){
        int[] vowelCount = new int[5];

        // 문자열의 각 자리마다 모음을 확인하여 aeiou -> 0~4번방에 카운트
        for(int i = 0; i < length; i++){
            switch (str.charAt(i)){
                case 'a' : vowelCount[0]++; break;
                case 'e' : vowelCount[1]++; break;
                case 'i' : vowelCount[2]++; break;
                case 'o' : vowelCount[3]++; break;
                case 'u' : vowelCount[4]++; break;
            }
        }

        return vowelCount;
    }

    private static boolean vowelDeleteCheck(String str1, String str2){
        str1 = str1.replaceAll("[aeiou]","");
        str2 = str2.replaceAll("[aeiou]","");

        // 모음을 모두 제거한 뒤 문자열을 비교, 같으면 true
        return str1.equals(str2);
    }
}
