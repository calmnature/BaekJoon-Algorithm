package Problem_Number;

import java.io.*;
import java.util.*;

/*
    - **문제 접근**
        - 입력
            - 학생의 수 N
            - N개의 줄만큼 1 ~ 5학년의 반이 공백으로 입력
        - 출력
            - 같은 반이 가장 많았던 학생이 임시 반장
                → 수가 같으면 가장 작은 번호
* */

public class No1268 {
    /*
        - **문제 해결**
            - 총 N번의 반복문으로 검증
            - 같은 번호의 학생이 중복 카운팅 되지 않도록 boolean 배열 사용
            - i번 학생의 같은 반이였던 학생들의 숫자를 저장하기 위한 배열 사용
            - 같은 반 친구가 가장 많았던 학생을 1번 학생부터 확인하여 출력 후 종료
    * */
    static int student;
    static int[] friendCount;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        student = Integer.parseInt(br.readLine());
        // 1~5학년 반을 저장할 배열
        map = new int[student+1][student+1];

        for(int i = 1; i <= student; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // input의 0번인덱스부터 5개를 -> map[i]번의 1번인덱스부터 5개까지 복사 (?)
            System.arraycopy(input, 0, map[i], 1, 5);
        }

        // 같은 학년이였던 친구를 체크할 배열
        friendCount = new int[student+1];
        setFriendCount();

        // 같은 학년이였던 친구가 가장 높은 숫자 추출
        int maxFriend = Arrays.stream(friendCount).max().getAsInt();

        // 가장 낮은 번호를 출력하면 되기 때문에 maxFriend와 일치하면 출력하고 종료
        for(int i = 1; i <= student; i++){
            if(maxFriend == friendCount[i]){
                System.out.println(i);
                break;
            }
        }
    }

    private static void setFriendCount(){
        // 학생 번호 1번부터 ~ N번까지 반복
        for(int studentNumber = 1; studentNumber <= student; studentNumber++){
            // 중복 체크하지 않도록 boolean 배열 생성
            boolean[] check = new boolean[student + 1];
            // 자기 자신을 체크하지 않도록 true로 변경
            check[studentNumber] = true;
            // 1학년부터 5학년까지 시작
            for(int grade = 1; grade <= 5; grade++){
                // N번 학생의 ?학년에 몇반이였는지 저장
                int classNumber = map[studentNumber][grade];
                // 1번 학생부터 N번 학생까지 반복
                for(int friendNumber = 1; friendNumber <= student; friendNumber++){
                    // 친구 번호가 나랑 같으면 무시
                    if(friendNumber == studentNumber) continue;
                    // 나의 A학년 반과 친구의 A학년 반이 같고 / 이미 체크된 친구가 아니라면 (처음 등장한 친구라면)
                    if(classNumber == map[friendNumber][grade] && !check[friendNumber]){
                        check[friendNumber] = true; // 체크 표시
                        friendCount[studentNumber]++; // 친구 + 1
                    }
                }
            }
        }
    }
}
