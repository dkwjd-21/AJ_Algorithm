import java.util.LinkedList;
import java.util.Queue;

class Solution {
		public int solution(int bridge_length, int weight, int[] truck_weights) {
			// 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는가? 
			// bridge_length : 다리길이 = 트럭이 다리에 올라갈 수 있는 최대값 
			// weight : 다리가 견딜 수 있는 무게 
			// truck_weights : 트럭 별 무게 
			
			int answer = 0;	// 소요시간
			
			// 다리 길이 만큼의 queue 
			Queue<Integer> bridge = new LinkedList<Integer>();
			for(int i=0; i<bridge_length; i++) {
				// 다리 길이 만큼 0kg 추가
				bridge.add(0);
			}
			
			// 현재 다리 위에 있는 차들의 무게합
			int currentWeight = 0;
			// 트럭무게 인덱스 
			int truckIdx = 0;
			
			// 모든 트럭이 다리를 건널 때까지 반복 
			while(truckIdx < truck_weights.length) {
				// 소요시간 ++
				answer++;
				// 다리 맨 앞의 차량 빼기 (+무게감소)
				currentWeight -= bridge.poll();
				
				// 다음 트럭의 무게
				int nextTruck = truck_weights[truckIdx];
				
				// 다음 트럭이 다리에 올라갈 수 있는지 체크 
				if(currentWeight + nextTruck <= weight) {
					// 트럭 추가
					bridge.add(nextTruck);
					// 다리 위의 총 무게 추가 
					currentWeight += nextTruck;
					// 트럭 인덱스 ++ 
					truckIdx++;
				} else {
					// 현재 다리 위에 있는 트럭 밀어주기
					bridge.add(0);
				}
			}
			
			// 마지막 트럭이 탈출하기 위해 다리 길이만큼 시간 추가
			return answer + bridge_length;
		}
	}