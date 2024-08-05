package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 입력
            - 방의 수 n이 주어짐 (1 ~ 50)
            - n의 줄만큼 1과 0으로 이루어진 길이 n 입력
            → 0 : 검은방 / 1 : 흰방
        - 출력
            - 흰 방으로 바꾸어야 할 최소 검은 방의 개수
* */
public class No2665 {
    /*
        - **문제 해결**
            - 시작 : 0, 0 ~ 목표 : n-1, n-1
            - dx, dy 배열로 이동할 좌표 저장 필요
            - dist 배열에 0, 0을 제외한 나머지 무한대로 초기화
            - 현재 좌표(x, y)에 dx, dy를 더했을 때 배열의 범위가 벗어나면 무시
            - map[nextX][nextY]가 검은방(0)이라면 1, 흰 방(1)이라면 0을 change 변수에 저장
            - dist[다음X][다음Y] > dist[현재X][현재Y] + change라면, dist[다음X][다음Y]에 dist[현재X][현재[Y] + change를 저장하고 다음 좌표(nextX, nextY)를 현재 좌표에 저장
    * */
    public static class Node {
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map, dist;
    static final int INF = Integer.MAX_VALUE;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dist = new int[n][n];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = str.charAt(j) - '0';
                dist[i][j] = INF; // 무한대로 초기화
            }
        }

        System.out.println(BFS());
    }

    private static int BFS(){
        Queue<Node> queue = new LinkedList<>();
        // 시작 좌표 0, 0을 큐에 추가
        queue.offer(new Node(0, 0));
        // 시작점 값 0
        dist[0][0] = 0;
        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            int currentX = currentNode.x;
            int currentY = currentNode.y;

            for(int i = 0; i < 4; i++){
                int nextX = currentNode.x + dx[i];
                int nextY = currentNode.y + dy[i];

                // 이동할 수 없는 좌표라면 무시
                if(isImpossible(nextX, nextY)) continue;

                // 이동할 곳이 검은 방이라면 change에 1, 흰방이면 0
                int change = map[nextX][nextY] == 0 ? 1 : 0;

                // 이동할 곳의 코스트(방을 변경한 횟수) > 현재 코스트 + change라면
                if(dist[nextX][nextY] > dist[currentX][currentY] + change){
                    // 다음 이동할 곳의 코스트 갱신
                    dist[nextX][nextY] = dist[currentX][currentY] + change;
                    // 큐에 추가
                    queue.offer(new Node(nextX, nextY));
                }
            }
        }

        return dist[n-1][n-1];
    }

    private static boolean isImpossible(int x, int y){
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}
