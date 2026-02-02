class Solution {
	    public int solution(int n, int[] lost, int[] reserve) {
	        // n : 전체 학생의 수
	    	// lost : 도난당한 학생들의 번호가 담긴 배열
	    	// reserve : 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 
	    	// answer : 체육수업을 들을 수 있는 학생의 최댓값
	    	int answer = 0;
	    	
	    	// n명의 학생들의 체육복 현황 (0번 제외) - 1로 초기화
	    	int[] clothes = new int[n+1];
	    	for(int i=0; i<clothes.length; i++) {
	    		clothes[i] = 1;
	    	}
	    	for(int student : lost) {		// 도난상황 적용 
	    		clothes[student]--;
	    	}
	    	for(int student : reserve) {	// 여벌옷 적용
	    		clothes[student]++;
	    	}
	    	
	    	// 여벌옷 나눠주기 
	    	for(int i=1; i<clothes.length; i++) {
	    		if(clothes[i] > 1) {
	    			if(i!=1 && clothes[i-1]==0) {
	    				clothes[i-1]++;
	    				clothes[i]--;
	    			} else if(i!=n && clothes[i+1]==0) {
	    				clothes[i+1]++;
	    				clothes[i]--;
	    			}	    			
	    		}
	    	}
	    	
	    	// 체육수업을 들을 수 있는 학생 수
	    	for(int i=1; i<clothes.length; i++) {
	    		if(clothes[i] > 0) {
	    			answer++;
	    		}
	    	}
	    	
	        return answer;
	    }
	}