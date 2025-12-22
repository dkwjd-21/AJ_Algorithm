import java.util.LinkedList;
import java.util.Queue;

class Solution {
		public int solution(int[] priorities, int location) {
			/* <운영체제의 프로세스 관리 규칙> 
			 * 1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
			 * 2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
			 * 3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
			 * 3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
			 * */
			
			// priorities : 프로세스의 중요도가 순서대로 담긴 배열 
			// 			    ex) [2, 1, 3, 2]  (A, B, C, D)  
			// location : 몇 번째로 실행되는지 알고싶은 프로세스의 위치 
			//			    ex) 0 (=A) 
			// priorities[0]의 실행순서 return 
			
			int answer = 0;
			
			// 큐에 priorities 저장 {중요도, 원래 인덱스}
			Queue<int[]> queue = new LinkedList<>();
			for(int i=0; i<priorities.length; i++) {
			    queue.add(new int[]{priorities[i], i});
			}
			
			while(!queue.isEmpty()) {
				// 상위 요소
				int[] current = queue.poll();
				// 상위 요소보다 중요한 프로세스가 있는지 여부
				boolean hasHigher = false;
				
				for(int[] tmp : queue) {
					if(current[0] < tmp[0]) {
						hasHigher = true;
						break;
					}
				}
				
				if(hasHigher) {
					// 상위 요소를 다시 add
					queue.add(current);
				} else {
					// 카운팅 
					answer++;
					if(current[1] == location) {
						// 만약 타겟 프로세스라면 answer 반환 
						return answer;
					}
				}
			}
			
			return answer;
		}
	}