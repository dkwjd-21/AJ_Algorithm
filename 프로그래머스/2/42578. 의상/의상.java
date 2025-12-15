import java.util.HashMap;

class Solution {
		public int solution(String[][] clothes) {
			// clothes : [의상이름][의상종류]
			// 서로 다른 옷의 조합의 수 return
			int answer = 1;
			
			// <의상종류, 의상수> HashMap
			HashMap<String, Integer> clothMap = new HashMap<String, Integer>();
			
			for(String[] item : clothes) {
				// item[0] : 의상이름
				// item[1] : 의상종류
				String type = item[1];
				
				clothMap.put(type, clothMap.getOrDefault(type, 0)+1);
			}
			
			// 의상종류 별 경우의 수 : 의상 수 + 1(입지않음) 
			// 전체 경우의 수 : 의상종류 별 경우의 수의 곱 
			for(String key : clothMap.keySet()) {
				answer *= clothMap.get(key) + 1;
			}
			
			// 아무것도 입지 않은 경우의 수는 제외해야 한다.
			return answer-1;
		}
	}