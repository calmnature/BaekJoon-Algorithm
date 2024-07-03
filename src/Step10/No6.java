package Step10;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class No6 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int[] triangle = new int[3];
        for(int i = 0; i < triangle.length; i++){
            triangle[i] = scan.nextInt();
        }
        scan.close();
        int sum = Arrays.stream(triangle).sum();
        if(sum != 180){
            System.out.println("Error"); return;
        }
        if(triangle[0] == triangle[1] && triangle[0] == triangle[2])
            System.out.println("Equilateral");
        else if(triangle[0] != triangle[1] && triangle[0] != triangle[2] && triangle[1] != triangle[2])
            System.out.println("Scalene");
        else
            System.out.println("Isosceles");
    }
}
