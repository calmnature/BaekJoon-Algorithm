package Step5;

import java.util.Scanner;
import java.util.StringTokenizer;

public class No8 {
    public static void main(String[] args) {
        // 간과한 부분
        // .split(" ")을 하게 되면 " "(공백 1개)만 입력이 들어왔을 때 split() 메서드는
        // ["", ""]으로 분리를 하고 마지막 빈 문자열은 무시를 하게 됨
        // 따라서 [""]가 남아 있어 공백 1개만 들어왔을 때 길이가 1이라고 출력
        // 방법1) 위처럼 str.isEmpty()일 경우 0을 출력하고, 빈 문자열이 아니라면 split의 length 출력
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine().trim();
//        System.out.println(str.split(" ").length); // 공백 1개 들어오울 경우 Error
        System.out.println(str.isEmpty() ? 0 : str.split(" ").length);
        // 방법2) StringTokenizer를 이용하여 공백을 구분자로 하고
        // .countTokens() 메서드로 Token의 개수를 셈
//        String str = scan.nextLine();
//        StringTokenizer st = new StringTokenizer(str, " ");
//        System.out.println(st.countTokens());
        scan.close();
    }
}
