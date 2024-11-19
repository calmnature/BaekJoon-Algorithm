package Step20;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
    문제 접근
        - 영어 단어장의 순서는 다음의 우선 순위를 차례로 적용
            1. 자주 나오는 단어일수록 앞에 배치
            2. 해당 단어의 길이가 길 수록 앞에 배치
            3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치
        - M 보다 짧은 길이의 단어는 외울 수 있어, 길이가 M 이상인 단어만 외움
        - 입력
            - 첫째 줄 : 단어의 개수 N과 외울 단어의 길이가 기준이 되는 M (1 <= N <= 100,000, 1 <= M <= 10)
            - ~ N번째 줄 : 외울 단어 입력
            - 단어장에 단어가 반드시 1개 이상 존재
            - 단어는 알파벳 소문자로만 주어지며 길이가 10을 넘지 않음
        - 출력
            - 단어장에 들어있는 단어를 단어장의 앞에 위치한 단어부터 한 줄에 한 단어씩 출력
* */

public class No5 {
    /*
        문제 해결
            - 알파벳(alphabet) / 나온 횟수(count) / 길이(length)를 가지는 Word 클래스 생성
            - 다음의 과정을 통해 Map에 추가
                1. N번을 반복
                2. 길이가 M 이하인 단어는 무시
                3. 길이가 M 이상의 단어는 Map<String, Word>에 추가
                4. Map의 value를 List로 변경
            - List 정렬 조건
                - count, length가 같을 경우 알파벳 오름차순
                - count가 같을 경우 length 내림차순
                - count의 내림차순
    * */
    static class Word {
        private String alphabet;
        private int count;
        private int length;

        public Word(String alphabet) {
            this.alphabet = alphabet;
            this.length = alphabet.length();
        }

        public String getAlphabet() {
            return alphabet;
        }

        public int getCount() {
            return count;
        }

        public int getLength() {
            return length;
        }

        public Word plusCount() {
            count++;
            return this;
        }
    }

    public static void main(String[] args) throws IOException{
        Map<String, Word> english = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            if(word.length() < M) continue;
            english.put(word, english.getOrDefault(word, new Word(word)).plusCount());
        }

        List<Word> englishList = new ArrayList<>(english.values().stream().collect(Collectors.toList()));
        Collections.sort(englishList, (o1, o2) -> {
            if(o1.getCount() == o2.getCount() && o1.getLength() == o2.getLength()) return o1.getAlphabet().compareTo(o2.getAlphabet());
            if(o1.getCount() == o2.getCount()) return Integer.compare(o2.getLength(), o1.getLength());
            return Integer.compare(o2.getCount(), o1.getCount());
        });

        for(Word word : englishList) {
            sb.append(word.getAlphabet()).append("\n");
        }

        System.out.println(sb);
    }
}
