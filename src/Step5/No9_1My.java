package Step5;

import java.util.Scanner;

public class No9_1My {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        scan.close();
        String reverseString = reverse(str);
        String[] split = reverseString.split(" ");
        int max = Math.max(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        System.out.println(max);
    }

    private static String reverse(String str){
        char[] charArr = str.toCharArray();
        int start = 0;
        int end = charArr.length - 1;
        while(start < end){
            char tmp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = tmp;
            start++; end--;
        }
        return new String(charArr);
    }
}
