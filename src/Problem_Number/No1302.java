package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/*
    - N개의 책의 제목이 입력 됨
    - 입력된 책의 제목 중 가장 많이 입력된 것을 출력
    - value가 동일할 경우 사전 순 이름 출력
* */
public class No1302 {
    /*
        - TreeMap을 이용하여 책 이름(Key)을 추가
        - 이미 존재한다면 수량(Value) 증가
        - MaxValue를 가장 많이 팔린 양 저장
    * */
    static TreeMap<String, Integer> bookMap = new TreeMap<>(); // 오름 차순 정렬
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sellCount = Integer.parseInt(br.readLine());
        int maxValue = 0; // 가장 많이 팔린 값 저장
        String bestSeller = null; // 가장 많이 팔린 책 이름 저장
        for(int i = 0; i < sellCount; i++){
            String bookName = br.readLine();
            if(bookMap.containsKey(bookName)){ // 이미 존재하는 책 이름이면
                int value = bookMap.get(bookName) + 1;
                bookMap.put(bookName, value); // 해당 책의 value를 1 증가
                if(maxValue < value) maxValue = value;
                continue;
            }
            bookMap.put(bookName, 1);
            if(bestSeller == null){ // bestSeller가 null인 1번만 실행
                // sellCount가 1일 경우 해당 책이 베스트 셀러
                bestSeller = bookName;
                maxValue = 1;
            }
        }
        if(maxValue >= 2) // 최고 판매량이 2개 이상이라면
            bestSeller = searchBestSeller(maxValue);

        System.out.println(bestSeller);
    }

    private static String searchBestSeller(int value) {
        for(Map.Entry<String, Integer> entry : bookMap.entrySet()){
            // 오름차순 정렬이기 때문에 가장 처음 나온 Key이름이 사전순 정렬된 이름
            if(entry.getValue() == value)
                return entry.getKey();
        }
        return null;
    }
}
