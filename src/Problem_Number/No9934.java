package Problem_Number;

import java.io.*;
import java.util.*;
/*
    - **문제 접근**
        - 완전 이진 트리에서 중위 순회로 방문을 함
        - 왼쪽 서브 트리 → 중간(루트 노드) → 오른쪽 서브 트리
        - 완전 이진 트리의 사이즈는 최대 2^깊이-1
* */
public class No9934 {
    /*
        - **문제 해결**
            - ArrayList의 배열을 트리의 깊이 만큼 생성
            - 입력값을 저장할 일차원 배열 생성
            - (시작값 + 마지막값) / 2를 하면 중간의 값(루트 노드)를 구할 수 있음
            - 1 깊이부터 시작하여 루트 노드를 저장하면서 K깊이가 될 때가지 재귀 호출
    * */
    static StringBuilder sb = new StringBuilder();
    static int K, size;
    static int[] input;
    static List<Integer>[] treeList;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 깊이 입력
        K = Integer.parseInt(br.readLine());
        // K 깊이의 최대 사이즈
        size = (int)Math.pow(2, K) - 1;
        input = new int[size + 1];

        // 0은 사용하지 않고, 1 ~ K 깊이까지 저장할 리스트 선언 및 초기화
        treeList = new ArrayList[K + 1];
        for (int i = 0; i < K + 1; i++)
            treeList[i] = new ArrayList<>();

        // 입력받은 수를 1 ~ K번째 인덱스까지 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= size; i++)
            input[i] = Integer.parseInt(st.nextToken());

        // treeList로 이진 트리를 만들 메서드
        makeTree(1, 1, size);

        // List 배열의 0번째는 사용하지 않아, 처음만 스킵시킬 변수
        int one_off = 0;
        for(List<Integer> list : treeList){
            if(one_off++ == 0) continue;
            for(int num : list){
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void makeTree(int depth, int start, int end){
        // (시작값 + 마지막값) / 2를 한 중간값이 루트 노드
        int mid = (start + end) / 2;
        // 현재 깊이(뎁스)의 ArrayList에 입력받은 배열에서 mid 인덱스에 해당하는 값 추기
        treeList[depth].add(input[mid]);
        // 리프노드 라면 자식이 없으므로 그 아래를 수행하지 않아도 됨
        if(K == depth) return;
        // 현재 루트노드를 기준으로 왼쪽을 탐색
        makeTree(depth + 1, start, mid - 1);
        // 현재 루트노드를 기준으로 오른쪽을 탐색
        makeTree(depth + 1, mid + 1, end);
    }
}
