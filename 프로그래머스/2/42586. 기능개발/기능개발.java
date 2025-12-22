import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
		public int[] solution(int[] progresses, int[] speeds) {
			// progresses : 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 배열 (%)  
			// speeds : 각 작업의 개발 속도가 적힌 배열
			// 뒤에 있는 기능이 먼저 개발된 경우, 앞에 기능이 배포될 때 함께 배포 
			// 각 배포마다 몇 개의 기능이 배포되는지 return 			
			
			List<Integer> answerList = new ArrayList<>();
			
			// 각 작업별 기능개발이 끝나는 데까지 며칠 걸리는지 계산
			Queue<Integer> days = new LinkedList<Integer>();
			for(int i=0; i<progresses.length; i++) {
				// 남은 진도 
				int remain = 100 - progresses[i];
				
				// 기능개발 소요 시간 계산 
				int day = (remain%speeds[i] == 0)? remain/speeds[i] : remain/speeds[i]+1;
			
				// 큐에 추가
				days.add(day);
			}
			
			// 큐를 순회하며, 맨 앞의 요소와 비교하여 배포되는 기능 수 카운팅
			while(!days.isEmpty()) {
				int cnt = 1;
				int day = days.poll();	// 맨 앞의 요소 - 기준 소요시간
				
				// 큐가 비어있지 않고, 기준이 되는 소요시간보다 적게 걸리면 추출
				while(!days.isEmpty() && days.peek() <= day) {
					days.poll();
					cnt++;
				}
				
				answerList.add(cnt);
			}
			
			int[] answer = new int[answerList.size()];
			for(int i=0; i<answer.length; i++) {
				answer[i] = answerList.get(i);
			}
			
			return answer;
		}
	}