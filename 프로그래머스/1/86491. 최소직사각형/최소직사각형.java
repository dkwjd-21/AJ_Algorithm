class Solution {
	    public int solution(int[][] sizes) {
	    	// sizes : [가로, 세로] 2차원 배열 
	    	// 모든 명함을 수납할 수 있는 가장 작은 지갑의 크기 return 
	        int answer = 0;
	        
	        // 지갑의 가로, 세로 
	        int width=0, length=0;
	        
	        for(int i=0; i<sizes.length; i++) {
	        	int size[] = sizes[i];
	        	int card_width, card_length;
	        	if(size[0] > size[1]) {
	        		// 명함 사이즈의 더 큰 값이 가로, 작은 값이 세로 
	        		card_width = size[0];
	        		card_length = size[1];
	        	} else {
	        		card_width = size[1];
	        		card_length = size[0];
	        	}
	        	
	        	// 기존값과 비교하여 더 큰값으로 저장
	        	width = Math.max(width, card_width);
	        	length = Math.max(length, card_length);	        	
	        }
	        
	        // 지갑의 크기 return 
	        return answer = width*length;
	    }
	}