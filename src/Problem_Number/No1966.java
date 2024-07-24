package Problem_Number;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    - **문제 접근**
        - 중요도는 1 ~ 9까지 존재
        - 가장 처음 문서를 0번째로 시작
        - 테스트 케이스 첫 번째 줄에는 문서의 개수 N, 몇 번째로 출력 되었는지 궁금한 M번째 문서
        - 테스트 케이스 두 번째 줄에는 N개 문서의 중요도가 주어짐
* */
class Document{
    int number;
    int priority;

    public Document(int number, int priority){
        this.number = number;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "[" + number + ", " + priority + "]";
    }
}
public class No1966 {
    /*
        - **문제 해결**
            - 문서의 번호와 중요도를 저장하는 클래스를 만들어 Queue에 순차적으로 저장
            - 맨 앞의 문서의 중요도가 가장 높은 지 큐의 모든 데이터를 순회하며 확인
                - 가장 높은 중요도일 경우 꺼내고, 문서 출력 카운트 1증가, M번째 문서라면 반복문 종료
                - 가장 높은 중요도가 아닐 경우 가장 높은 중요도가 나올 때까지 뒤로 추가
    * */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < T; i++){
            Queue<Document> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            boolean findTarget = false;
            int count = 0;
            int docNum = 0;

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){ // [N번째 문서, 중요도] 저장
                queue.offer(new Document(docNum++, Integer.parseInt(st.nextToken())));
            }

            while(!findTarget){ // 타겟을 찾을 때까지 반복
                int maxPriority = 0;
                for(int j = 0; j < queue.size(); j++){ // 가장 높은 우선 순위 탐색
                    Document doc = queue.poll();
                    queue.add(doc);
                    if(maxPriority <= doc.priority) maxPriority = doc.priority;
                }

                for(int j = 0; j < queue.size(); j++){ // 가장 높은 우선 순위를 꺼냄
                    Document doc = queue.poll();
                    if(maxPriority != doc.priority) queue.add(doc);
                    else{
                        count++;
                        if(doc.number == target){ // 목표하는 target번째 문서와 같으면 반복문 종료
                            findTarget = true;
                        }
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
