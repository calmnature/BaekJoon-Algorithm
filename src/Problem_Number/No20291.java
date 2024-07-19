package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class No20291 {
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