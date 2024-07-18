package Problem_Number;

import java.util.Arrays;
import java.util.Scanner;

public class No1614 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hurtFinger = scan.nextInt();
        int limitCount = scan.nextInt();
        int[] pattern = new int[]{1,2,3,4,5,4,3,2};
        int patternInCount = (int)Arrays.stream(pattern).filter(finger -> finger == hurtFinger).count();
        int fullPatternCount = limitCount / patternInCount;
        int remainder = limitCount % patternInCount;
        long num = (long) fullPatternCount * pattern.length;
        for(int i = 0; i < pattern.length; i++){
            if(pattern[i] == hurtFinger){
                if(remainder == 0) break;
                remainder--;
            }
            num++;
        }
        System.out.println(num);
    }
}
