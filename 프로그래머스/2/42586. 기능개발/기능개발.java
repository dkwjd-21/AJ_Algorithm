import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // progresses : 배포되어야 하는 순서대로 작업의 진도 배열
        // speeds : 작업의 개발 속도가 적힌 속도 배열 
        // 각 배포마다 몇 개의 기능이 배포되는지 return
        // int[] answer = {};
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 작업의 인덱스와 진도를 저장하는 큐 {번호, 진도}
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            int[] arr = {i, progresses[i]};
            queue.add(arr);
        }
        
        // 큐가 빌 때까지 작업진행 
        while(!queue.isEmpty()) {
            for(int i=0; i<queue.size(); i++) {
                int[] arr = queue.poll();
                arr[1] += speeds[arr[0]];
                queue.add(arr);
            }
            
            // 배포할 수 있는 기능의 수
            int count = 0;
            
            while(!queue.isEmpty() && queue.peek()[1] >= 100) {
                queue.poll();
                count++;
            }
            
            if(count != 0) {
                answer.add(count);
            }
        }
        
        
        return answer.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}