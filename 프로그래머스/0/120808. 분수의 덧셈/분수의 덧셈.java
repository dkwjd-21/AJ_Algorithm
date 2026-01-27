class Solution {
	    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
	        int[] answer = new int[2];
	        
	        answer[0] = numer1*denom2 + numer2*denom1;
	        answer[1] = denom1*denom2;
	        
	        int gcd = GCD(answer[0], answer[1]);
	        answer[0] = answer[0]/gcd;
	        answer[1] = answer[1]/gcd;
	        
	        return answer;
	    }
	    
	    // 최대공약수 계산
	    public int GCD(int num1, int num2) {
	    	int gcd = 1;
	    	
	    	for(int i=2; i<=Math.min(num1, num2); i++) {
	    		if(num1%i == 0 && num2%i == 0) {
	    			gcd = Math.max(gcd, i);
	    		}	    		
	    	}
	    	
	    	return gcd;
	    }
	}