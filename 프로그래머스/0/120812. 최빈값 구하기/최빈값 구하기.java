import java.util.Arrays;

class Solution {
		public int solution(int[] array) {
			int answer = 0;
			
			Arrays.sort(array);
			int tmp = array[array.length - 1];
			
			int[] count = new int[tmp+1];
			
			for(int num : array) {
				count[num]++;
			}			
			
			int max = 0;
			for(int num : count) {
				max = Math.max(max, num);
			}
			
			for(int i=1; i<count.length; i++) {
				if(count[i] == max) {
					answer = (answer==0)? i : -1;
				}
			} 
			
			return answer;
		}
	}