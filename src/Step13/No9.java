package Step13;

import java.io.*;
import java.util.*;
/*
    - **문제 접근**
        - 짧은 길이부터 출력 + 같은 길이라면 사전 순 출력
        - 중복된 단어는 1번만 출력
        - 최대 길이는 20,000으로 시간복잡도가 O(n^2) 알고리즘일 경우 4억번의 연산(4초)로 시간 초과 예상
* */
public class No9 {
    /*
        - **문제 해결**
            - 중복 단어가 있기 때문에 Set으로 중복 제거 또는 Stream을 이용한 배열 중복 제거 후 정렬
            - 정렬 시 최소 O(nlogn) 방식 사용
            - 단순 길이 정렬이 아니라, 같은 길이일 경우 사전 순 출력을 해야 하기 때문에
              클래스를 생성 Comparable 상속  →  길이 오름차순 → 길이가 같다면 글자 오름차순 필요
    * */
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 모든 입력 배열에 저장
        int count = Integer.parseInt(br.readLine());
        String[] input = new String[count];
        for(int i = 0; i < count; i++)
            input[i] = br.readLine();
        // 동일한 문자 중복 제거
        String[] deleteDuplication = Arrays.stream(input).distinct().toArray(String[]::new);
        // Word 클래스 배열 생성
        Word[] words = new Word[deleteDuplication.length];
        for(int i = 0; i < deleteDuplication.length; i++){
            String str = deleteDuplication[i];
            int length = str.length();
            words[i] = new Word(str, length);
        }
        // Word 배열 정렬
        Arrays.sort(words);
        // 정렬된 문자열 StringBuilder에 저장
        for(Word word : words)
            sb.append(word.str).append("\n");

        System.out.println(sb);
    }
}

class Word implements Comparable<Word> {
    String str;
    int length;

    public Word(String str, int length){
        this.str = str;
        this.length = length;
    }

    @Override
    public String toString(){
        return "[" + str + ", " + length + "]";
    }

    @Override
    public int compareTo(Word word) {
        if(this.length != word.length)
            return Integer.compare(this.length, word.length);
        else
            return this.str.compareTo(word.str);
    }
}