package Step6;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No6 {
    // 굳이 Set을 사용하지 않고, String 배열로 반복문을 사용하여 replace해도 됐음
    private static final Set<String> set = new LinkedHashSet<>(Arrays.asList("c=","c-","dz=","d-","lj","nj","s=","z="));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        for(String s : set){
            str = str.replace(s, "R");
        }
        System.out.println(str.length());
    }
}
