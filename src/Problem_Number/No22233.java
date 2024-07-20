package Problem_Number;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/*
    - **문제 접근**
        - N개의 키워드가 메모장에 적혀있음
        - 글 1개당 최대 10개의 키워드 사용 가능
        - 2 ~ N + 1번 줄까지는 메모장의 키워드
        - N + 2 ~ N + M + 1번 줄까지는 쓴 글과 관련된 키워드가 쉼표( , )로 입력
* */
public class No22233 {
    /*
        - **문제 해결**
            - N은 최대 20만으로 배열로 하면 메모리 초과가 나올 것으로 예상
            - 메모장의 키워드는 중복되지 않기에 Set으로 저장
            - 글에 사용된 키워드를 반복문을 사용하여 Set 안에 있는 키워드면 삭제
            - 글 하나 입력 시 마다 메모장에 남은 키워드(Set.size) 출력
    * */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> keyword = new HashSet<>();
        String[] input = br.readLine().split(" ");
        int memoCnt = Integer.parseInt(input[0]); // 메모장 키워드 개수
        int blogArticleCnt = Integer.parseInt(input[1]); // 게시글 개수
        for(int i = 0; i < memoCnt; i++){
            keyword.add(br.readLine()); // 메모장 키워드 Set에 저장
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < blogArticleCnt; i++){
            input = br.readLine().split(",");
            for(String word : input){
                keyword.remove(word);
            }
            sb.append(keyword.size()).append("\n");
        }
        System.out.println(sb);
    }
}
