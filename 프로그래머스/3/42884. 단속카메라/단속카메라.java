import java.util.Arrays;

class Solution {
	    public int solution(int[][] routes) {
	    	// 고속도로를 이용하는 차량의 경로 routes 
	    	//	routes[i][0] : i번째 차량이 고속도로에 진입한 지점
	    	//	routes[i][1] : i번째 차량이 고속도로에서 나간 지점
	    	// 모든 차량이 단속용 카메라를 한번은 만나려면 필요한 카메라 개수의 최소값
	        int answer = 0;
	        
	        // 나간 지점이 빠른 순서로 오름차순 정렬 
	        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
	       
	        // 첫번째 차가 나간 지점에 카메라 설치 
	        int tmp = routes[0][1];
	        answer++;
	        
	        for(int i=1; i<routes.length; i++) {
	        	if(routes[i][0] > tmp) {
	        		// i번째 차가 카메라 설치 지점 이후에 진입한 경우
	        		tmp = routes[i][1];		// 카메라 지점 업데이트
	        		answer++;				// 카메라 설치
	        	}
	        }
	        
	        return answer;
	    }
	}