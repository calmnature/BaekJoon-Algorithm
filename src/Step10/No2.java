package Step10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int minX = Integer.parseInt(st.nextToken()); // X값 저장
        int minY = Integer.parseInt(st.nextToken()); // Y값 저장
        minX = Math.min(minX, Math.abs(minX - Integer.parseInt(st.nextToken()))); // X값 vs |X - W| 중 작은 값 저장
        minY = Math.min(minY, Math.abs(minY - Integer.parseInt(st.nextToken()))); // Y값 vs |Y - W| 중 작은 값 저장
        System.out.println(Math.min(minX, minY)); // X, Y 값 중 최솟값 출력
    }
}
