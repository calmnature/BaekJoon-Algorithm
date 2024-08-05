package Problem_Number;

import java.io.*;
import java.util.*;
/*
    - **문제 접근**
        - 입력
            - 헛간 N(노드), 소들의 길 M(간선)
            - M개의 줄만큼 A_i(start), B_i(end), C_i(소의 수, weight)
        - 출력
            - 찬홍이가 있는 위치 N을 목표로 하고, 1 → N까지 갈 때 필요한 최소 여물 개수
            → 1 ~ N까지의 최소 가중치 출력
            dist[연결노드] > dist[현재노드] + 연결노드까지의 가중치 
            → 갱신 및 Queue에 추가
* */
public class No5972 {
    /*
        - **문제 해결**
            - 간선은 양방향 그래프
            - 소의 수 C_i는 0 ~ 1,000까지로 음수 가중치가 없기 때문에 다익스트라로 풀이
            - dist[N+1] 배열을 사용, 출발지인 1번 헛간은 0, 나머지 헛간은 무한대로 초기화
    * */
    public static class Node implements Comparable<Node>{
        int target;
        int weight;
        public Node(int target, int weight){
            this.target = target;
            this.weight = weight;
        }

        @Override
        public String toString(){
            return "[" + target + ", " + weight + "]";
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int N, V;
    static List<List<Node>> nodeList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = getInput(br.readLine());
        N = input[0]; V = input[1];

        // 인접 리스트 초기화
        for (int i = 0; i <= N; i++) nodeList.add(new ArrayList<>());

        // 인접 리스트에 간선 정보 추가
        for(int i = 0; i < V; i++){
            input = getInput(br.readLine());
            int start = input[0], end = input[1], weight = input[2];
            nodeList.get(start).add(new Node(end, weight));
            nodeList.get(end).add(new Node(start, weight));
        }

        System.out.println(daijkstra());
    }

    private static int[] getInput(String str){
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int daijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 최단 경로를 저장할 배열 선언 및 초기화
        int[] dist = new int[N+1];
        // 시작 지점을 제외한 모든 노드는 무한대로 초기화
        Arrays.fill(dist, INF);
        dist[1] = 0;

        // 시작 노드와 가중치 queue에 추가
        pq.offer(new Node(1, 0) );

        while(!pq.isEmpty()){
            // queue에서 가중치가 가장 적은 순서대로 추출
            Node currentNode = pq.poll();
            // 현재 노드에 연결된 노드 추출
            List<Node> linkNodeList = nodeList.get(currentNode.target);
            for(Node linkNode : linkNodeList){
                // dist[연결노드] > dist[현재 노드] + 연결 노드까지의 가중치라면
                 if(dist[linkNode.target] > dist[currentNode.target] + linkNode.weight){
                     // dist[연결노드]의 최단 경로를 dist[현재 노드] + 연결 노드 가중치로 갱신
                    dist[linkNode.target] = dist[currentNode.target] + linkNode.weight;
                    // 큐에 해당 노드와 가중치 추가
                    pq.offer(new Node(linkNode.target, dist[linkNode.target]));
                 }
            }
        }

        return dist[N];
    }
}
