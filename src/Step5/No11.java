package Step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class No11 {
    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);
//        while(scan.hasNext()){
//            System.out.println(scan.nextLine());
//        }
//        scan.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            System.out.println(str);
        }
        br.close();
        // 속도, 메모리적인 차원에서 BufferedReader를 더 많이 활용해볼 것
    }
}
