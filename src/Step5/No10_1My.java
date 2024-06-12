package Step5;

import java.util.Map;
import java.util.Scanner;

public class No10_1My {
    private static Map<String, Integer> map = Map.ofEntries(
            Map.entry("ABC", 3),
            Map.entry("DEF", 4),
            Map.entry("GHI", 5),
            Map.entry("JKL", 6),
            Map.entry("MNO", 7),
            Map.entry("PQRS", 8),
            Map.entry("TUV", 9),
            Map.entry("WXYZ", 10)
    );
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String alpha = scan.nextLine();
        scan.close();
        int sum = 0;
        for(int i = 0; i < alpha.length(); i++){
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                boolean contain = entry.getKey().contains(String.valueOf(alpha.charAt(i)));
                if(contain){
                    sum += entry.getValue();
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
