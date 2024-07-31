package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 입력 ⇒ 20줄에 걸쳐 과목명 / 학점 / 등급이 주어짐
        - 출력 ⇒ 전공 평점(학점 * 과목평점의 총 합 / 학점의 총합)
* */
public class No25206 {
    /*
        - **문제 해결**
            - 과목 평점을 Map으로 선언하여 저장
            - 등급이 P인 경우 계산에서 제외
            - 학점의 총합과 학점  * 과목 평점의 총합을 구해야 함
    * */
    // 과목 평점
    static Map<String, Double> subjectScore = Map.of("A+",4.5, "A0", 4.0, "B+", 3.5, "B0", 3.0, "C+", 2.5,
            "C0", 2.0, "D+", 1.5, "D0", 1.0, "F", 0.0);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double totalCredit = 0; // 학점의 총합
        double totalMajorScore = 0; // 전공 평점의 총합

        for(int i = 0; i < 20; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 과목명 필요 없음

            // 학점
            double credit = Double.parseDouble(st.nextToken());
            // 등급
            String grade = st.nextToken();

            // 등급이 P면 계산에서 제외
            if(grade.equals("P")) continue;

            totalCredit += credit;
            totalMajorScore += credit * subjectScore.get(grade);
        }

        System.out.println(totalMajorScore / totalCredit);
    }
}
