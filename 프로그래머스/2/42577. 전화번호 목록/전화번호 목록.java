import java.util.HashSet;

class Solution {
		public boolean solution(String[] phone_book) {
			// phone_book : 전화번호부에 적힌 전화번호 배열 
			// 다른 번호의 접두어인 경우가 있으면 false, 없으면 true 
			boolean answer = true;
			
			// 전화번호 HashSet 
			HashSet<String> phoneNumbers = new HashSet<String>();
			
			for(String phone_number : phone_book) {
				phoneNumbers.add(phone_number);
			}
			
			// 전화번호 하나씩 순회하며 접두어인 경우가 있는지 체크
			for(String phone_number : phone_book) {
				for(int i=0; i<phone_number.length(); i++) {
					if(phoneNumbers.contains(phone_number.substring(0, i))) {
						answer = false;
						return answer;
					}
				}				
			}
			
			return answer;
		}
	}