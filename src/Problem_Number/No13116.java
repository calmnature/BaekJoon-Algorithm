package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 해당 문제는 완전 이진 트리이기 때문에 배열 없이 풀이 가능
        - 1부터 순차적으로 증가하기 때문에 정점의 숫자에 따라 깊이를 찾을 수 있음
        - 두 개의 정점의 깊이를 맞춘 뒤 동일한 부모 노드가 나타날 때까지 반복
        - 출력 ⇒ 같은 부모 노드 * 10
* */
public class No13116 {
    /*
        - **문제 해결**
            - 두 정수 A와 B의 깊이를 각각 구함
            - 깊이가 다를 경우 더 큰 값을 작은 값에 맞췄을 때의 정점을 구함
            - 두 정점이 같지 않을 경우 1단계 위의 부모 정점 탐색(나누기 2)
            - 두 정점이 같아졌을 때 공통 조상 발견
    * */
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TestCase = Integer.parseInt(br.readLine());
        for(int i = 0;  i < TestCase; i++){
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            int commonParent = getCommonParent(vertex1, vertex2);

            // 출력 => 10 * k
            sb.append(commonParent * 10).append("\n");
        }

        System.out.println(sb);
    }

    private static int getCommonParent(int vertex1, int vertex2) {
        // 두 정점의 깊이를 탐색
        int v1Depth = searchDepth(vertex1);
        int v2Depth = searchDepth(vertex2);

        // 두 정점 깊이의 차이를 구함
        int gap = Math.abs(v1Depth - v2Depth);
        // 더 큰 값(깊은 값)의 정점을 2^차이 만큼 나누었을 때
        // 해당 정점이 같은 깊이의 정점
        if(v1Depth < v2Depth)
            vertex2 /= (int)Math.pow(2, gap);
        else if(v1Depth > v2Depth)
            vertex1 /= (int)Math.pow(2, gap);

        int commonParent;
        // 두 정점이 같은 값이 될 때까지 부모 탐색(/2)
        while(vertex1 != vertex2){
            vertex1 /= 2; vertex2 /= 2;
        }
        commonParent = vertex1;
        return commonParent;
    }

    private static int searchDepth(int v){
        int depth = 0;
        int range = 1;
        // 정점이 2^n 보다 작아졌을 때가 깊이
        while(range <= v){
            range = (int)Math.pow(2, ++depth);
        }
        return depth;
    }
}
