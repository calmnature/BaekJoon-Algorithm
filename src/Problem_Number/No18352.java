package Problem_Number;

import java.io.*;
import java.util.*;
/*
    - **문제 접근**
        - 입력
            - 도시의 개수 N = Node (2 ~ 300,000)
            - 도로의 개수 M = Edge (1 ~ 1,000,000)
            - 거리 정보 K = 목표 도시 (1 ~ 300,000)
            - 출발 도시 번호 = X (1 ~ N)
        - 출력
            - X에서 출발하여 최단 거리가 K인 도시 오름차순 출력
            - 최단 거리 K인 도시가 하나도 없으면 -1
* */
public class No18352 {
    /*
        - **문제 해결**
            - 거리가 최대 30만까지 주어질 수 있기 때문에 BFS로 1개씩 늘리면서 최단 거리를 확인해야할 것으로 예상
            - 노드의 수가 30만개나 되기 때문에 인접 행렬로 하게 되면 힙 스페이스 에러가 발생
            - 인접 리스트로 N과 M을 저장하고 시작점으로부터 거리가 K가 되면 리스트에 저장
    * */
    static List<List<Integer>> edgeList = new ArrayList<>();
    static List<Integer> city = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = parse(st); // 정점의 개수
        int M = parse(st); // 간선의 개수
        int K = parse(st); // 거리 정보
        int X = parse(st); // 시작 정점

        visited = new boolean[N + 1]; // 방문 배열 선언
        dist = new int[N + 1]; // 시작점 X로부터 떨어진 거리를 저장할 배열
        Arrays.fill(dist, -1);

        for(int i = 0; i <= N; i++) edgeList.add(new ArrayList<>());

        for(int i = 0; i < M; i++){ // 방향 그래프로 인접리스트 추가
            st = new StringTokenizer(br.readLine());
            int start = parse(st);
            int end = parse(st);
            edgeList.get(start).add(end);
        }

        BFS(K, X);

        Collections.sort(city); // 도시 오름차순 정렬

        if(city.isEmpty()) sb.append(-1);
        for(int c : city)
            sb.append(c).append("\n");

        System.out.println(sb);
    }

    private static void BFS(int distance, int currentNode){
        // 시작 정점을 Queue에 넣고, 시작 정점의 거리는 0, 방문 True로 체크
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(currentNode);
        dist[currentNode] = 0;
        visited[currentNode] = true;

        while(!queue.isEmpty()) {
            // 현재 큐에 있는 값을 추출
            currentNode = queue.remove();

            // N번 노드에 연결된 노드들을 꺼냄
            List<Integer> list = edgeList.get(currentNode);
            int size = list.size();

            // N번 노드에 연결된 노드 개수만큼 반복
            for(int i = 0; i < size; i++){
                int nextNode = list.get(i);
                if(!visited[nextNode]){ // 방문하지 않은 노드라면
                    visited[nextNode] = true; // 방문으로 표시
                    queue.offer(nextNode); // Queue에 추가
                    // 현재 노드에서 이동 됐기 때문에 현재 노드 거리 + 1을 다음 노드 거리에 저장
                    dist[nextNode] = dist[currentNode] + 1;

                    // 다음 노드의 거리가 목표(K)거리와 같다면 리스트에 추가
                    if(dist[nextNode] == distance) //
                        city.add(nextNode);
                }
            }
            // BFS이기 때문에 거리가 K보다 커지면 이후 모든 도시들은 K보다 큰 거리의 도시들로 BFS 종료
            if(dist[currentNode] > distance) return;
        }
    }


    private static int parse(StringTokenizer st){
        return Integer.parseInt(st.nextToken());
    }
}
