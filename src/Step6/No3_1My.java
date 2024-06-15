package Step6;


import java.util.Scanner;

public class No3_1My {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int repeat = 2 * N - 1;
        for(int i = 0; i < repeat; i++){
            if(i < repeat / 2){
                for(int j = i; j < N - 1; j++){
                    System.out.print(" ");
                }

                for(int j = 0; j < i * 2 + 1 ; j++){
                    System.out.print("*");
                }
            }else if(i == repeat / 2){
                for(int j = 0; j < repeat; j++){
                    System.out.print("*");
                }
            }else { // i = 5부터 시작
                for(int j = 0; j < (i*2-repeat) / 2 + 1; j++){
                    System.out.print(" ");
                }

                for(int j = 0; j < (repeat - i) * 2 - 1; j++){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
