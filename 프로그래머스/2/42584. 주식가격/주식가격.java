import java.util.LinkedList;
import java.util.Queue;

class Solution {
		public int[] solution(int[] prices) {
			// prices : 초 단위로 기록된 주식가격 
			// 가격이 떨어지지 않은 기간은 몇 초인지 return 
			int[] answer = new int[prices.length];
			
			// prices -> 큐로 변환
			Queue<Integer> queue = new LinkedList<Integer>();
			for(int price : prices) {
				queue.add(price);
			}
			
			// answer에 값을 추가하기 위한 인덱스
			int idx = 0;
			
			while(!queue.isEmpty()) {
				// 상위 요소의 가격 
				int currentPrice = queue.poll();
				// 시간 카운트 변수
				int time = 0;
				
				for(int price : queue) {
					if(currentPrice <= price) {
						// 상위 요소의 가격이 다음 요소들보다 작거나 같으면 가격이 떨어지지 않음
						time++;
					} else {
						// 가격이 떨어지면 반복문 종료 
                        time++;
						break;
					}
				}
				
				answer[idx++] = time;
			}
			
			return answer;
		}
	}