import java.util.HashSet;

class Solution {
	    public int solution(int[] nums) {
	    	// nums : N마리의 폰켓몬의 종류 번호가 담긴 배열 
	    	// N/2 마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법 찾기
	    	// 그때의 폰켓몬 종류 번호의 개수를 return 
	        int answer = 0;
	        
	        int N = nums.length;
	        
	        // 중복 없이 폰켓몬 종류 번호 저장 
	        HashSet<Integer> ponketmon = new HashSet<Integer>();
	        
	        for(int num : nums) {
	        	ponketmon.add(num);
	        }
	        
	        // 중복 없는 번호 수 & N/2 비교 
	        answer = (ponketmon.size() >= N/2)? N/2 : ponketmon.size();
	        
	        return answer;
	    }
	}