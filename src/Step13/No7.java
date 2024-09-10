package Step13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    - **문제 접근**
        - 입력
            - 좌표의 개수 N (1 ≤ N ≤ 100,000)
            - N개의 줄만큼 x와 y의 좌표
        - 출력
            - 좌표 정렬 결과를 출력
* */
public class No7 {
    /*
        - **문제 해결**
            - x좌표를 오름차순으로 정렬
            - x좌표가 동일하다면 y좌표를 비교하여 오름차순 정렬
            - Coordinate 클래스를 생성하여 Comparable 인터페이스를 상속 받아 정렬 기준 설정하여 풀이
    * */
    static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;

        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o){
            if(this.x == o.x)
                return this.y - o.y;
            return this.x - o.x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Coordinate[] coordinates = new Coordinate[N];

        for(int i = 0; i < N; i++){
            int[] input = getCoordinate(br.readLine());
            Coordinate coordinate = new Coordinate(input[0], input[1]);
            coordinates[i] = coordinate;
        }

        br.close();

        Arrays.sort(coordinates);

        for(Coordinate coordinate : coordinates)
            sb.append(coordinate.x).append(" ").append(coordinate.y).append("\n");

        System.out.println(sb);
    }

    private static int[] getCoordinate(String str) {
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
