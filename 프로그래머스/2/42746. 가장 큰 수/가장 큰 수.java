import java.util.Arrays;

class Solution {
		public String solution(int[] numbers) {
			// 주어진 정수로 만들 수 있는 가장 큰 수를 반환 
			
			// numbers를 String 배열로 변환한다 
			String[] strNums = new String[numbers.length];
			for(int i=0; i<strNums.length; i++) {
				strNums[i] = numbers[i]+"";
			}
			
			// String 배열을 정렬한다
			// ex) 80, 9 비교 -> 809 vs 980 
			// -> 980이 더 큰값을 가지므로 9가 앞에 오도록 정렬
			Arrays.sort(strNums, (a, b) -> (b+a).compareTo(a+b));
			
			// 첫번째 수가 0이면 0을 반환한다. 
			if(strNums[0].equals("0")) return "0";
			
			// 하나로 합치기 
			String answer = "";			
			for(String num : strNums) {
				answer += num;
			}		
			
			return answer;
		}
	}