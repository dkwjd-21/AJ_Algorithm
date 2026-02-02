import java.util.Stack;

class Solution {
		public String solution(String number, int k) {
			// number에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자
			// 현재까지 cnt개 제거
			int cnt = 0;

			Stack<Integer> stack = new Stack<Integer>();
			for (int i = 0; i < number.length(); i++) {
				int tmp = Integer.parseInt(number.charAt(i) + "");

				while (!stack.isEmpty() && cnt < k && tmp > stack.peek()) {
					stack.pop();
					cnt++;
				}

				stack.push(tmp);
			}

			// 아직 k개를 제거하지 못한 경우
			if (cnt < k) {
				for (int i = cnt; i < k; i++) {
					stack.pop();
				}
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}

			return sb.toString();
		}
	}