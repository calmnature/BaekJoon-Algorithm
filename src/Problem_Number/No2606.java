package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 입력
            - 첫째줄 = 컴퓨터의 수 (1 ~ 100)
            - 둘째줄 = 네트워크 상 연결된 컴퓨터 쌍의 수
        - 출력
            - 1번 컴퓨터가 웜 바이러스에 감염될 경우 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수 출력
* */
public class No2606 {
    /*
        - **문제 해결**
            - 컴퓨터의 수 = 노드, 네트워크 연결 = 간선
            - 무방향 그래프이고 BFS, DFS 어떤 것으로 풀어도 상관 없을 것으로 예상 됨
            - DFS로 풀이 ⇒ Base Condition ⇒ 현재 노드가 방문 노드면 리턴
    * */
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int count = 0; // 감염된 PC 개수
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int V = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) list.add(new ArrayList<>());

        for(int i = 0; i < V; i++){ // 무방향 그래프 추가
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start);
        }

        DFS(1);

        System.out.println(count);
    }

    private static void DFS(int node){
        if(visited[node]) return; // 현재 노드를 방문했다면 종료 
        visited[node] = true; // 방문 안했다면 방문한 것으로 체크
        //현재 노드에 연결된 노드들의 리스트
        List<Integer> nodeList = list.get(node); 
        for(int n : nodeList){
            if(!visited[n]){ // 방문 안했다면
                count++; // 감염 수 1 증가
                DFS(n); // 재귀 호출
            }
        }
    }
}
