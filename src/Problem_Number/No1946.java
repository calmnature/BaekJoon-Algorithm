package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 첫 째줄에 테스트 케이스의 개수가 주어짐
        - 테스트 케이스의 첫째줄에는 지원자 수가 주어지고, 이후 지원자 수만큼 [서류 성적, 면접 성적] 두 개가 공백으로 주어짐
        - 현재의 지원자가 다른 지원자 단 한명이라도, 서류 성적 또는 면접 성적이 떨어질 경우 선발되지 않음
        - 출력 ⇒ 테스트 케이스마다 선발할 수 있는 신입 사원의 수
* */
public class No1946 {
    /*
        - **문제 해결**
            - [서류 성적, 면접 성적]을 멤버 변수로 갖는 클래스를 선언
            - 지원자 수 만큼 클래스의 배열을 생성
            - 클래스 배열을 서류 성적 순으로 정렬
            - 최소 면접 점수를 저장하는 변수를 선언하여, 현재 지원자의 면접 점수가 더 낮다면 최소 면접 점수를 갱신하고 신입 사원 카운팅
    * */

    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TestCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < TestCase; i++){
            // 지원자 수 입력
            int applicantCount = Integer.parseInt(br.readLine());
            // 지원자 수 만큼 배열 생성
            Applicant[] applicant = new Applicant[applicantCount];
            // 신입사원 숫자 체크 변수
            int new_worker_count = 0;

            for(int j = 0; j < applicantCount; j++){
                st = new StringTokenizer(br.readLine());
                int document_grade = Integer.parseInt(st.nextToken());
                int interview_grade = Integer.parseInt(st.nextToken());
                applicant[j] = new Applicant(document_grade, interview_grade);
            }

            // 서류 등수를 기준으로 정렬
            Arrays.sort(applicant);

            // 현재까지의 최소 면접 점수를 저장할 변수
            int min_interview_grade = Integer.MAX_VALUE;
            for(Applicant app : applicant){
                // 최소 면접 등수보다 현재 지원자가 더 낮다면(더 높은 등수)
                if(min_interview_grade > app.interview_grade){
                    // 최소 면접 등수 갱신
                    min_interview_grade = app.interview_grade;
                    // 신입 사원으로 채용
                    new_worker_count++;
                }
            }

            sb.append(new_worker_count).append("\n");
        }

        System.out.println(sb);
    }
}

class Applicant implements Comparable<Applicant>{
    int document_grade;
    int interview_grade;

    public Applicant(int document_socre, int interview_score){
        this.document_grade = document_socre;
        this.interview_grade = interview_score;
    }

    @Override
    public String toString(){
        return "[" + document_grade + ", " + interview_grade + "]";
    }

    // 정렬 기준 => 서류 점수를 기준으로 오름차순
    @Override
    public int compareTo(Applicant applicant) {
        return Integer.compare(this.document_grade, applicant.document_grade);
    }
}