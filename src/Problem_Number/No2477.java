package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
    - 방향과 길이를 저장한 배열을 각각 생성
    - 길이가 가장 긴 가로 길이, 인덱스 / 길이가 가장 긴 세로 길이, 인덱스 저장
    - 길이가 가장 긴 가로, 세로 인덱스에 +3을 하면 제외할 직사각형의 가로 세로 인덱스
* */
public class No2477 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());
        int size = 6;
        int[] direction = new int[size];
        int[] length = new int[size];
        for(int i = 0; i < size; i++){
            st = new StringTokenizer(br.readLine());
            direction[i] = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        int maxX = 0, maxX_idx = 0;
        int maxY = 0, maxY_idx = 0;
        for(int i = 0; i < size; i++){
            if(direction[i] <= 2){ // 방향이 1 or 2일 경우(가로)
                if(maxX < length[i]){
                    maxX = length[i];
                    maxX_idx = i;
                }
            }else {
                if(maxY < length[i]){ // 방향이 3 or 4일 경우(세로)
                    maxY = length[i];
                    maxY_idx = i;
                }
            }
        }
        int exceptX = length[(maxX_idx+3) % size]; // 배열 범위 초과 방지
        int exceptY = length[(maxY_idx+3) % size]; // 배열 범위 초과 방지
        int res = ((maxX * maxY) - (exceptX * exceptY)) * K;
        System.out.println(res);
    }
}
