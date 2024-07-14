package Step12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] chess = new char[N][M];
        for(int i = 0; i < N; i++){
            chess[i] = br.readLine().toCharArray();
        }
        char[][] blackChess = new char[8][8];
        char[][] whiteChess = new char[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if((i + j) % 2 == 0){
                    blackChess[i][j] = 'B';
                    whiteChess[i][j] = 'W';
                } else{
                    blackChess[i][j] = 'W';
                    whiteChess[i][j] = 'B';
                }
            }
        }
        int minCount = Integer.MAX_VALUE;
        for(int row = 0; row <= N - 8; row++){
            for(int col = 0; col <= M - 8; col++){
                int blackCount = 0;
                int whiteCount = 0;
                for(int x = 0; x < 8; x++){
                    for(int y = 0; y < 8; y++){
                        if(chess[row + x][col + y] != blackChess[x][y]){
                            blackCount++;
                        }
                        if(chess[row + x][col + y] != whiteChess[x][y]){
                            whiteCount++;
                        }
                    }
                }
                minCount = Math.min(minCount, Math.min(blackCount, whiteCount));
            }
        }
        System.out.println(minCount);
    }
}
