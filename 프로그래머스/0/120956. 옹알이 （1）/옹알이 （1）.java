class Solution {
	    public int solution(String[] babbling) {
	    	// 조카가 할 수 있는 발음
	    	String[] canSpeak = new String[] {"aya", "ye", "woo", "ma"};
	        int answer = 0;
	        
	        for(String word : babbling) {
	        	String curr = word;
	        	
	        	
	        	for(String compare : canSpeak) {
	        		if(curr.contains(compare)) {
	        			curr = curr.replaceAll(compare, " ");
	        		}
	        	}
	        	
	        	curr = curr.replaceAll(" ", "");
	        	
	        	if(curr.length() == 0) {
	        		answer++;
	        	}
	        }
	        
	        return answer;
	    }
	}