import java.util.HashSet;

class Solution {
		// 조합된 수를 저장할 set (중복 저장X)  
		HashSet<Integer> numSet = new HashSet<Integer>();
		
	    public int solution(String numbers) {
	    	// numbers : 종이 조각에 적힌 숫자가 적힌 문자열 
	        int answer = 0;
	        
	        // 문자열을 이용해서 숫자 조합하기 
	        combination("", numbers);
	        
	        // numSet에 있는 모든 숫자를 대상으로 소수인지 판별
	        for(int num : numSet) {
	        	// 소수이면 카운트 증감 
	        	if(isPrime(num)) answer++;
	        }	        
	        
	        return answer;
	    }
	    
	    // 모든 숫자 조합을 만드는 메서드 (재귀함수)
	    public void combination(String comb, String others) {
	    	// comb : 지금까지 조합된 문자열
	    	// others : comb에 조합을 해야하는 문자열 
	    	
	    	if(!comb.equals("")) {
	    		// 지금까지 조합된 문자열이 비어있지 않다면 set에 추가
	    		numSet.add(Integer.parseInt(comb));
	    	}
	    	
	    	// others와 조합해서 숫자 만들기 
	    	for (int i = 0; i < others.length(); i++) {
	    		// 현재까지 조합된 문자열에 붙이기
	    		// comb + others.charAt(i) 
	    		
	    		// 조합되지 않은 부분을 다시 문자열로 넣어서 재귀
	    		// others.substring(0, i) + others.substring(i + 1) 
	    		combination(comb + others.charAt(i), 
                            others.substring(0, i) + others.substring(i + 1));
            }
	    	
	    }
	    
	    // num이 소수인지 아닌지 확인하는 메서드
	    public boolean isPrime(int num) {
	    	// 소수 : 1보다 큰 자연수 중에서 1과 자기 자신만을 약수로 갖는 수
	    	if(num <= 1) return false;
	    	
	    	// 어떤 수의 약수는 제곱근을 기준으로 대칭을 이룬다
	    	for(int i=2; i*i<=num; i++) {
	    		if(num%i == 0) return false;
	    	}
	    	
	    	return true;
	    }
	}