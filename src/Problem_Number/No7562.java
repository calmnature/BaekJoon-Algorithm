package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 입력
            - 테스트 케이스
            - 각 테스트 케이스
                - 첫째줄 ⇒ 체스판 한 변의 길이 (4 ~ 300)
                - 둘째줄 ⇒ 현재 위치
                - 셋째줄 ⇒ 목표 위치
        - 출력
            - 최소 이동 수
* */
public class No7562 {
    /*
        - **문제 해결**
            - 나이트의 이동 가능 좌표 8칸을 선언
            - 최소 이동이기 때문에 BFS가 더 적합하다고 판단
                - DFS를 할 경우 300 x 300 체스판이 주어지면, 모든 경우를 다 탐색해야하기 때문
            - 방문 여부 확인 배열 반드시 필요
                → 없을 경우 무한 루프에 빠짐
    * */
    // 체스판 크기, 목표 X 인덱스, 목표 Y 인덱스
    static int chessLength, targetX, targetY;
    // 나이트 이동 가능한 좌표
    static int[] dx = {-1, -2, -2, -1, 1, 2, 1, 2};
    static int[] dy = {-2, -1, 1, 2, -2, -1, 2, 1};
    // chess에 이동 경로 수를 입력
    static int[][] chess;
    // 방문 배열 사용하지 않을 경우 무한 루프
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TestCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < TestCase; i++){
            chessLength = Integer.parseInt(br.readLine());
            chess = new int[chessLength][chessLength];
            visited = new boolean[chessLength][chessLength];

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            BFS(startX, startY);

            sb.append(chess[targetX][targetY]).append("\n");
        }

        System.out.println(sb);
    }

    private static void BFS(int x, int y) {
        // 처음 시작값을 큐에 넣고, 방문으로 체크 하고 시작
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            // 큐에 있는 값 추출
            int[] coordinate = queue.remove();
            // 현재 이동 횟수 저장
            int currentMove = chess[coordinate[0]][coordinate[1]];
            for(int i = 0; i < 8; i++){
                // 다음 이동 X, Y 저장
                int nextX = coordinate[0] + dx[i];
                int nextY = coordinate[1] + dy[i];

                // 이동이 불가능한 곳이라면, 방문한 곳이라면 무시
                if(!isPossibleMove(nextX, nextY)) continue;
                if(visited[nextX][nextY]) continue;

                // 해당 좌표 방문 으로 체크
                visited[nextX][nextY] = true;
                // 현재 이동 횟수에서 1 증가
                chess[nextX][nextY] = currentMove + 1;

                // 타겟 X, Y라면 BFS 종료
                if(isTarget(nextX, nextY)) return;

                // 아직 타겟이 아니라면 queue에 추가
                queue.offer(new int[]{nextX, nextY});
            }
        }
    }

    // 체스판 이내의 범위인지 체크하는 함수
    private static boolean isPossibleMove(int x, int y){
        return x >= 0 && y >= 0 && x < chessLength && y < chessLength;
    }

    // 목표한 좌표에 도달했는지 체크하는 함수
    private static boolean isTarget(int x, int y){
        return x == targetX && y == targetY;
    }
}
