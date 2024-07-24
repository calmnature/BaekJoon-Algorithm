package Problem_Number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
    - **문제 접근**
        - 제목대로 Queue를 이용하여 구현
        - 문제는 예제의 명령어는 모두 Queue의 메서드로 가능하지만, back의 명령을 처리할 메서드는 존재하지 않음
* */
public class No10845 {
    /*
        - **문제 해결**
            - Queue와 switch-case문을 이용하여 구현
            - back 명령의 경우 다음의 순서로 구현이 필요
                1. 가장 마지막에 데이터의 앞에 있는 데이터들, 즉 n-1개의 데이터를 꺼냄(poll)
                2. 다시 넣음(offer)
                3. 가장 마지막의 데이터가 오면 출력(peek)
                4. 가장 마지막 데이터도 다시 꺼내고 넣음 (poll and offer)
    * */
    public static void main(String[] args) throws Exception{
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String[] command = br.readLine().split(" ");
            Integer output = -999;
            switch(command[0]){
                case "push" :
                    queue.offer(Integer.parseInt(command[1]));
                    break;
                case "pop" :
                    output = queue.poll();
                    break;
                case "size" :
                    output = queue.size();
                    break;
                case "empty" :
                    output = queue.isEmpty() ? 1 : 0;
                    break;
                case "front" :
                    output = queue.peek();
                    break;
                case "back" :
                    if(queue.isEmpty()) output = -1;
                    else {
                        for(int j = 0; j < queue.size()-1; j++)
                            queue.offer(queue.poll());
                        output = queue.poll();
                        queue.offer(output);
                    }
                    break;
            }
            if(output == null) output = -1;
            if(output != -999)
                sb.append(output).append("\n");
        }
        System.out.println(sb);
    }
}
