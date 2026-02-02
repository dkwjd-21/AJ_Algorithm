class Solution {
		public int solution(String name) {
			// name : 만들고자 하는 이름
			/* ▲ - 다음 알파벳 
			 * ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로) 
			 * ◀ - 커서를 왼쪽으로 이동 
			 *     (첫 번째 위치에서 왼쪽으로이동하면 마지막 문자에 커서) 
			 * ▶ - 커서를 오른쪽으로 이동 
			 *     (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서) */
			// answer : 조이스틱 조작 횟수의 최솟값
			int answer = 0;

			String current = "A".repeat(name.length());
			// 상하 조작 먼저 카운트 
			for(int i=0; i<current.length(); i++) {
				char tmp = current.charAt(i);
				char target = name.charAt(i);
				
				// target 알파벳으로 조작 
				if(tmp != target) {
					int forward = forward(target);
					int reverse = reverse(target);
					if(forward < reverse) {
						answer += forward;
					} else {
						answer += reverse;
					}
				}				
			}
			
			// 커서 조작 카운트 (최소값) 
			int len = name.length();
			int move = len - 1;	// 기본값 : name길이만큼 
			for (int i = 0; i < len; i++) {
				// i번째까지 처리하고 유턴하는게 빠를지 확인 
				
			    // 현재 글자 다음에 연속된 A가 어디서 끝나는지 찾기 (연속된 A가 아닌 인덱스) 
			    // ex) BBAAAAAC, i=1 -> next=6. 
				int next = i + 1;
			    while (next < len && name.charAt(next) == 'A') {
			        next++;
			    }

			    // 위에서 말한 3가지 시나리오 중 최솟값을 찾기
			    // 1) 직진
			    //	-> len - 1
			    // 2) i까지 오른쪽으로 가다가 유턴(앞글자부터 A나올때까지 처리 후 유턴)
			    //	-> i*2 + (len-next)
			    // 3) i까지 왼쪽으로 가다가 유턴(뒤글자부터 A나올때까지 처리 후 유턴)
			    //	-> (len-next)*2 + i
			    
			    // *2는 돌아오는 것(유턴)을 의미함
			    
			    // move : 현재까지 찾은 최단 거리
			    move = Math.min(move, Math.min(i*2+(len-next), (len-next)*2+i));
			}
			answer += move;
			
			return answer;
		}

		// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
		// A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
		// A -> J 순방향 : 10-1 = 9번 (= J-A)
		// A -> J 역방향 : 26-10 17번 (= Z-J +1)

		// 순방향으로 했을 때, 몇 번 조작
		public int forward(char target) {
			return target-'A';
		}

		// 역방향으로 했을 때, 몇 번 조작
		public int reverse(char target) {
			return 'Z'-target+1;
		}
	}