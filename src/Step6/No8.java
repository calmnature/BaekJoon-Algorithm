package Step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class No8 {
    private static final Map<String, Double> map = Map.of(
            "A+", 4.5, "A0", 4.0, "B+", 3.5, "B0", 3.0, "C+", 2.5, "C0", 2.0, "D+", 1.5, "D0", 1.0, "F", 0.0
    );

    private static double total_score = 0;
    private static double total_multi = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 20;
        for(int i = 0; i < count; i++){
            subjectCalc(br.readLine());
        }
        br.close();
        System.out.println(total_multi / total_score);
    }

    private static void subjectCalc(String str){
        // 과목명 무시
        // 학점 저장, 등급 저장
        // 만약 등급이 P일 경우 continue
        StringTokenizer st = new StringTokenizer(str);
        st.nextToken();
        double score = Double.parseDouble(st.nextToken());
        String grade = st.nextToken();
        if(grade.equals("P"))
            return;
        total_score += score;
        total_multi += (score * map.get(grade));
    }
}
