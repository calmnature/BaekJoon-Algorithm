package Step5;

import java.util.Scanner;

public class No7_2GPT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine(); // 개행 문자 소비

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
//            String str = scan.nextLine();
//            String[] split = str.split(" ");
//            int R = Integer.parseInt(split[0]);
//            String P = split[1];
            // scan.next()는 개행문자를 포함하지 않고 입력을 받기 때문에
            // 내 풀이 처럼 split을 굳이 해주지 않아도 됨
            int R = scan.nextInt();
            String P = scan.next();
//            for(int j = 0; j < P.length(); j++){
//                for(int k =0; k < R; k++){
//                    sb.append(P.charAt(j));
//                }
//            }
//            sb.append("\n");
            // 문자열 P를 Char 배열로 만들어줌(P의 길이만큼 반복)
            // String.valueOf(c) -> char c를 String으로 반환
            // String.repeat(int count) -> N번만큼 문자열 반복
            for (char c : P.toCharArray()) {
                sb.append(String.valueOf(c).repeat(R));
            }
            sb.append("\n");
        }
        scan.close();
        System.out.print(sb);
    }
}
