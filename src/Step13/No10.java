package Step13;

import java.io.*;
import java.util.Arrays;

/*
    - **문제 접근**
        - 입력
            - 회원수 N (1 ≤ N ≤ 10,000)
            - N개의 줄만큼 회원의 나이와 이름이 공백으로 가입한 순서대로 입력

                → 나이 : 1 ~ 200

                → 이름 : 알파벳 대소문자

        - 출력
            - 나이 오름 차순
            - 나이가 같을 경우 가입 순서
            - 한 줄에 한 명씩 나이와 이름을 공백으로 출력
* */
public class No10 {
    /*
        - **문제 해결**
            - 가입한 순서로 정렬도 하기 때문에 입력 받은 순서대로 인덱스가 필요
            - 회원 클래스를 생성하여 index, age, name을 매개 변수로 가지고 Comparable을 상속 받아 정렬
    * */
    static class Member implements Comparable<Member>{
        int index;
        int age;
        String name;

        public Member(int index, int age, String name){
            this.index = index;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member m){
            if(this.age == m.age)
                return this.index - m.index;
            return this.age - m.age;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];

        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            members[i] = new Member(i, Integer.parseInt(input[0]), input[1]);
        }

        Arrays.sort(members);

        for(Member m : members)
            sb.append(m.age).append(" ").append(m.name).append("\n");

        System.out.println(sb);
    }

}
