package Step14;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/*
    문제 접근
        입력
            - 첫째 줄 : 도감에 저장된 포켓몬 개수 N, 맞춰야하는 문제 개수 M(1 <= N, M <= 100,000)
            - ~N개 줄 : 포켓몬의 이름이 알파벳으로 된 문자열 (2 <= 이름 M <= 20)
            - ~M개 줄 : 맞춰야하는 문제로 아래와 같이 출력
                - 포켓몬 이름 → 숫자
                - 숫자 → 포켓몬 이름
                - 포켓몬 이름 : 반드시 도감에 있는 포켓몬 이름만 주어짐
                - 숫자 : 1 <= 숫자 <= N
        출력
            - 한 줄에 한 개씩 M개 줄에 대한 출력
* */
public class No4 {
    /*
        문제 해결
            - N개의 줄을 1번 index부터 증가하여 저장을 하는데, Map<String, Integer>로 하게 되면 숫자로 들어왔을 때 반복문을 사용하여 최대 100,000번의 반복이 필요하고 제네릭이 그 반대인 Map<Integer, String>을 해도 마찬가지로 포켓몬 이름이 들어왔을 때도 최대 100,000번의 반복이 필요
            - 그렇다면, Map<Integer, String>으로 숫자용 Map을 저장하고 제네릭을 바꿔서 Map<String, Integer>도 생성
            - String용 Map, Integer용 Map 두 가지를 사용하여 들어오는 값(String, Integer)에 따라 Map.getKey()를 한 값을 StringBuilder에 저장
            - 들어오는 값이 숫자인지 String인지 알 수 없기 때문에 정규표현식 사용
    * */
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);

        List<String> nameList = br.lines()
                .limit(N)
                .collect(Collectors.toList());

        Map<Integer, String> numberMap = IntStream.range(0, N)
                .boxed()
                .collect(Collectors.toMap(i -> i + 1, nameList::get));

        Map<String, Integer> alphaMap = IntStream.range(0, N)
                .boxed()
                .collect(Collectors.toMap(nameList::get, i -> i + 1));

        for(int i = 0; i < M; i++){
            String problem = br.readLine();
            if(problem.matches("\\d+"))
                sb.append(numberMap.get(Integer.parseInt(problem))).append("\n");
            else
                sb.append(alphaMap.get(problem)).append("\n");
        }

        System.out.println(sb);
    }
}
