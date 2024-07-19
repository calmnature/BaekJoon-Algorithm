package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/*
    - 문제 접근
        - 확장자를 기준으로 확장자 이름과 해당 확장자가 몇 개인지 출력
        - 무조건 온점( . )으로 확장자 구분
        - 확장자의 이름 순으로 내림차순 정렬
* */
public class No20291 {
    /*
        - 문제 해결
        - 트리맵으로 쉽게 풀릴 것 같음
        - N번만큼 반복문을 돌려서 확장자를 Map에 추가, 존재한다면 Value를 1증가
    * */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int fileCount = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> fileMap = new TreeMap<>(); // 트리맵 선언
        for(int i = 0; i < fileCount; i++){
            String fileName = br.readLine();
            String extension = fileName.substring(fileName.indexOf(".")+1); // 점 뒤의 확장자 추출
            if(fileMap.containsKey(extension)){ // 맵에 있는 확장자라면
                // 1증가(동일 Key라면 Value가 덮어씌워지는 것을 이용)
                fileMap.put(extension, fileMap.get(extension)+1);
            } else{ // 맵에 있는 확장자가 아니면 추가
                fileMap.put(extension, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : fileMap.entrySet()){
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }
        System.out.println(sb);
    }
}