import java.util.Arrays;

class Solution {
	    public int solution(int[] citations) {
	    	// citations : 논문의 인용횟수를 담은 배열 
	    	// h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용됨
	    	// -> h의 최댓값이 H-Index 
	    	int answer = 0;
	        
	    	// 인용횟수를 오름차순 정렬 
	    	Arrays.sort(citations);
	    	
	    	// 인용횟수 순회
	    	// ex) [3, 0, 6, 1, 5] -> [0, 1, 3, 5, 6] 
	    	for(int i=0; i<citations.length; i++) {
	    		// h : i번째 논문보다 인용수가 많거나 같은 논문의 개수 (i번째 논문 포함)
	    		// ex) i=2. 인용횟수:3. h=3 
	    		int h = citations.length - i;
	    		
	    		// i번째 논문의 인용횟수가 h보다 많거나 같으면 반환 
	    		// 인용횟수(3) >= h(3) 
	    		if(citations[i] >= h) return h;
	    	}
	    	
	    	return answer;
	    }
	}