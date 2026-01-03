import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
		public int[] solution(String[] operations) {
			// I 숫자 : 큐에 주어진 숫자를 삽입
			// D 1 : 큐에서 최댓값을 삭제
			// D -1 : 큐에서 최솟값을 삭제

			// 모든 연산 처리 후 큐가 비어있으면 [0, 0] 리턴
			// 비어있지 않으면 [최댓값, 최솟값] 리턴
			int[] answer = {};

			// 최소힙, 최대힙 사용 (이중 힙으로 구현)
			PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
			PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
			// 이중 힙을 보조하기 위한 맵 [숫자, 힙에 있는지 여부(1, 0)]
			HashMap<Integer, Integer> helpMap = new HashMap<Integer, Integer>();

			// 힙에 저장된 숫자의 개수 
			int totalSize = 0;
			
			for (String str : operations) {
				String operation = str.split(" ")[0];
				int num = Integer.parseInt(str.split(" ")[1]);

				if (operation.equals("I")) {
					// 큐에 주어진 숫자를 삽입
					minHeap.offer(num);
					maxHeap.offer(num);
					helpMap.put(num, helpMap.getOrDefault(num, 0) + 1);
					totalSize++;
					
				} else if (operation.equals("D") && totalSize>0) {
					// 데이터 삭제 연산은 힙이 비어있지 않을 때에만 진행한다.
					if (num == 1) {
						// 최댓값 삭제 전 동기화 
						syncHeap(maxHeap, helpMap);
						if(!maxHeap.isEmpty()) {
							// 최댓값 삭제
							int max = maxHeap.poll();
							helpMap.put(max, helpMap.getOrDefault(max, 0) - 1);
							totalSize--;
						}					
						
					} else if (num == -1) {
						// 최솟값 삭제 전 동기화
						syncHeap(minHeap, helpMap);
						// 최솟값 삭제
						int min = minHeap.poll();
						helpMap.put(min, helpMap.getOrDefault(min, 0) - 1);
						totalSize--; 
						
					}
				}
			}

			// 최종 동기화 
			syncHeap(maxHeap, helpMap);
			syncHeap(minHeap, helpMap);

			if(totalSize == 0) {
				// 힙이 비어있다면
				answer = new int[] {0,0};
			} else {
				// 힙이 비어져 있지 않다면
				answer = new int[] {maxHeap.peek(), minHeap.peek()};
			}

			return answer;
		}

		// 유령 데이터를 제거하는 공통 함수 (이중 힙 동기화)
		// lazy deletion 으로 구현
		private void syncHeap(PriorityQueue<Integer> heap, HashMap<Integer, Integer> map) {
			// 힙이 비어있지 않고, 맨 위의 숫자가 이미 지워진 수라면 힙에서 제거
			while (!heap.isEmpty() && map.getOrDefault(heap.peek(), 0) <= 0) {
				heap.poll();
			}
		}
	}