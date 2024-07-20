package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


/*
    - **문제 접근**
        - ENTER가 입력된 후 처음 입력된 채팅은 곰곰티콘으로 인사
        - 그 외엔 곰곰티콘을 사용하지 않는 기록 ⇒ 곰곰티콘 인사 후 동일한 아이디가 채팅을 칠 수도 있음 → 입력 예제 3
*/
public class No25192 {
    /*
        - Set을 이용하여 유저의 아이디를 저장
        - ENTER가 입력되면 Set을 클리어 시킴
        - 셋에 추가하면서 곰곰티콘의 횟수를 1 증가 시키고, 이미 존재하면 무시
    * */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> greetingUser = new HashSet<>();
        int chatLogCount = Integer.parseInt(br.readLine());
        int GomGomCount = 0; // 곰곰티콘 사용 횟수
        for(int i = 0; i < chatLogCount; i++){
            String input = br.readLine();
            if(input.equals("ENTER")) {
                // 입장 시 곰곰티콘 새로 카운트해야 하기 때문에
                // Set을 클리어해서 새로 유저를 등록
                greetingUser.clear();
                continue;
            }
            if(!greetingUser.contains(input)){ // Set에 없을 경우
                greetingUser.add(input); // 유저 추가
                GomGomCount++; // 곰곰티콘 인사
            }
        }
        System.out.println(GomGomCount);
    }
}
