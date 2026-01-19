import java.util.ArrayList;
import java.util.List;

class Solution {
		// 단어 사전
		List<String> dictionary = new ArrayList<String>();
		// 모음들 
		String[] vowel = new String[] {"A", "E", "I", "O", "U"};
		
		public int solution(String word) {
			// A,E,I,O,U 만을 사용해서 만들 수 있는 단어 사전에서
			// word가 몇 번째 단어인지 찾기 
			int answer = 0;
			
			// 사전 생성 
			generateDictionary("");
			
			// 사전에서 word의 인덱스 찾기 (0부터 시작하므로 +1)
			answer = dictionary.indexOf(word)+1;
			
			return answer;
		}
		
		// 사전에 단어를 추가하는 메서드
		// currWord : 현재 단어 (재귀를 위한 변수)
		public void generateDictionary(String currWord) {
			// 단어 길이가 5를 넘어가면 종료 
			if(currWord.length() > 5) return;
			
			if(!currWord.equals("")) {
				dictionary.add(currWord);
			}
			
			for(int i=0; i<vowel.length; i++) {
				String tmpWord = currWord + vowel[i];
				generateDictionary(tmpWord);
			}
		}
		
	}