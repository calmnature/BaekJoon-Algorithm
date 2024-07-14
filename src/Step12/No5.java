package Step12;

import java.util.Scanner;

public class No5 {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.close();
        int target = 1;
        int num = 666;
        while(target != N){
            num++;
            if(String.valueOf(num).contains("666")){
                target++;
            }
        }
        System.out.println(num);
    }
}
