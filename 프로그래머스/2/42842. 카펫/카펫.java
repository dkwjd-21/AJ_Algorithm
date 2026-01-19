class Solution {
		public int[] solution(int brown, int yellow) {
			// brown : 카펫의 갈색 격자의 수 
			// yellow : 카펫의 노란색 격자의 수 
			int[] answer = {};
			
			// 카펫의 넓이 = brown + yellow 
			int carpet = brown + yellow;
			
			// 카펫의 가로의 최소 길이는 3. 
			for(int w=3; w<carpet; w++) {
				int h;	// 세로
				
				if(carpet%w == 0) {	// w가 넓이의 약수일 때만 h 계산 가능
					h = carpet/w;		// 세로는 카펫넓이/가로 
					if(w >= h) {		// 단, 가로보다 작아야됨
						// (w-2) * (h-2) = yellow 넓이여야만 조건 충족
						if((w-2)*(h-2) == yellow) {
							answer = new int[] {w, h};
						}
					}					
				}				
			}		
			
			return answer;
		}
	}