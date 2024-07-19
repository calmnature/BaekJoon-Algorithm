package Problem_Number;

import java.util.Scanner;

// 한 번 재귀가 호출될 때마다 반복되는 구절에서 언더바 4개(____)가 앞에 추가
public class No17478 {
    /*
        - “어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.”는 단 1번 출력 되기 때문에 재귀함수 호출 전에 1번 실행
        - 재귀 함수 호출 후 항상 반복되는 부분은 아래와 같음
            - "재귀함수가 뭔가요?"
            - "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
            - 마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
            - 그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
        - 재귀를 N번 하게 되면, "재귀함수는 자기 자신을 호출하는 함수라네"를 출력하고 더 이상 재귀 호출이 되지 않음
        - count 변수를 선언하여 재귀 호출 횟수 * 언더바 4개(____)를 추가
    * */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursion(N, 0);
    }

    private static void recursion(int n, int count) {
        String prefix = "____".repeat(count);
        System.out.println(prefix + "\"재귀함수가 뭔가요?\"");
        if(n == 0){
            System.out.println(prefix + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
        } else {
            System.out.println(prefix + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
            System.out.println(prefix + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
            System.out.println(prefix + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
            recursion(n-1, count+1);

        }
        System.out.println(prefix + "라고 답변하였지.");
    }
}
