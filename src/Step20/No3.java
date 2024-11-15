package Step20;

import java.io.*;
import java.util.*;

public class No3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> rainbowSet = new HashSet<>();
        final String origin = "ChongChong";
        rainbowSet.add(origin);

        int logCount = Integer.parseInt(br.readLine());
        for(int i = 0; i < logCount; i++) {
            String[] log = br.readLine().split(" ");
            String A = log[0];
            String B = log[1];
            if(rainbowSet.contains(A) || rainbowSet.contains(B)){
                rainbowSet.add(A);
                rainbowSet.add(B);
            }
        }

        System.out.println(rainbowSet.size());
    }
}
