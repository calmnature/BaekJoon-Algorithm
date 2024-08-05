package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 입력
            - 회원 수 (Node)
            - 친구 사이(Vertex)
            - -1 -1 입력 시 종료
        - 출력
            - 회장 후보 점수와 후보 수 출력
            - 회장 후보 오름 차순 출력
        - 직접적인 친구 관계 ⇒ 1점
        - 친구의 친구 관계 ⇒ 2점
        - 친구의 친구의 친구 관계 ⇒ 3점
        - 친구 관계 중 제일 낮은 점수가 가까운 사이의 친구가 많다는 의미 ⇒ 회장 후보
        → 건너 건너 친구인 게 길면 길 수록 회장 후보가 아니라는 것
* */
public class No2660 {
    /*
        - **문제 해결**
            - 1번 친구 ~ 2번, 3번, 4번, … , N번 친구까지 관계 점수
              …
            - N번 친구 ~ 1번, 2번, 3번, …, N-1번 친구까지 관계 점수
            - 플로이드 워셜로 관계 점수(코스트)를 구해야 함
            - 제일 낮은 관계 점수를 기준으로 1 ~ N번까지의 친구들을 리스트에 모두 넣고 오름차순 정렬
    * */
    static int people, minScore = Integer.MAX_VALUE;
    static int[][] relationShip;
    static final int INF = 1000000;
    static List<Integer> candidateList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        people = Integer.parseInt(br.readLine());
        relationShip = new int[people][people];
        // 모두 무한대로 초기화 + 자기 자신은 0으로 초기화
        for(int i = 0; i < people; i++){
            for(int j = 0; j < people; j++){
                relationShip[i][j] = i == j ? 0 : INF;
            }
        }

        // -1이 입력될 때까지 반복
        while(true){
            int[] input = parseInt(br.readLine());
            if(input[0] == -1) break;

            int friend1 = input[0] - 1;
            int friend2 = input[1] - 1;
            // 무방향 그래프
            relationShip[friend1][friend2] = 1;
            relationShip[friend2][friend1] = 1;
        }

        FlyodWarshall();
        // 혹시 모를 오름 차순 정렬
        Collections.sort(candidateList);

        sb.append(minScore).append(" ").append(candidateList.size()).append("\n");
        for(int friend : candidateList) sb.append(friend).append(" ");

        System.out.println(sb);

    }

    private static int[] parseInt(String str){
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static void FlyodWarshall() {
        // 플로이드 워셜 점화식
        // relationShip[i][j] = relationShip[i][k] + relationShip[k][j];
        for(int k = 0; k < people; k++)
            for(int s = 0; s < people; s++)
                for(int e = 0; e < people; e++)
                    relationShip[s][e] = Math.min(relationShip[s][e], relationShip[s][k] + relationShip[k][e]);

        for(int i = 0; i < people; i++){
            int maxScore = 0;
            // i번 사람의 최고 관계 점수를 구함
            for(int j = 0; j < people; j++)
                maxScore = Math.max(maxScore, relationShip[i][j]);
            // 최고 점수 중 가장 낮은 점수(회장 후보 점수)를 구함
            minScore = Math.min(maxScore, minScore);
        }

        for(int i = 0; i < people; i++){
            int maxRelationScore = 0;
            // i번 사람의 최고 점수를 구함
            for(int j = 0; j < people; j++)
                maxRelationScore = Math.max(maxRelationScore, relationShip[i][j]);

            // i번 사람의 최고 점수가 minScore와 같다면 회장 후보로 리스트에 추가
            if(minScore == maxRelationScore)
                candidateList.add(i + 1);
        }

    }
}
