package Step5;

import java.util.Scanner;
import java.util.StringTokenizer;

public class No9_1GPT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        scan.close();
        String[] split = str.split(" ");
        int n1 = reverse(split[0]);
        int n2 = reverse(split[1]);
        System.out.println(Math.max(n1, n2));
        // StringBuilder에는 문자열을 뒤집는 .reverse() 메서드 존재
        // 이걸 이용하여 문자열을 모두 뒤집고 .toString()으로 String 형태로 반환
        // Integer.parseInt()를 이용하여 Integer로 형변환하면 더 간단히 풀이 가능
    }

    private static Integer reverse(String str){
        return Integer.parseInt(new StringBuilder(str).reverse().toString());
    }
}
