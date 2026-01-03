import java.util.PriorityQueue;

class Solution {
	    public int solution(int[] scoville, int K) {
	    	// scoville : Leo가 가진 음식의 스코빌 지수 배열 
	    	// 모든 음식의 스코빌 지수를 K 이상으로 만들기
	    	// 스코빌 지수가 가장 낮은 두 개의 음식을 섞어 새로운 음식을 만듦
	    	// 섞은 음식 스코빌 지수 = 스코빌 최솟값 + (두번째 스코빌 최솟값 * 2)
	        // answer : 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수 
	    	//			만들 수 없는 경우 -1을 return
	    	int answer = 0;
	    	
	    	// 최소 힙 
	    	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	    	
	    	// 모든 음식의 스코빌 지수를 힙에 저장 
	    	for(int val : scoville) {
	    		minHeap.add(val);
	    	}
	    	
	    	// 힙이 비어있지 않고, 최솟값이 K보다 작은 경우 반복 
	    	while(!minHeap.isEmpty() && minHeap.peek() < K) {
	    		int min, minNext;	// 최솟값, 두번째 최솟값
	    		try {
	    			min = minHeap.poll();		// 최솟값
		    		minNext = minHeap.poll();	// 두번째 최솟값
				} catch (Exception e) {
					// 예외가 발생한 경우 = 더 이상 음식을 섞을 수 없는 경우 
					return answer = -1;
				}
	    		
	    		// 새로운 음식의 스코빌지수
	    		int newFood = min + (minNext*2);
	    		
	    		minHeap.add(newFood);	  
	    		answer++;
	    	}
	    
	        return answer;
	    }
	}