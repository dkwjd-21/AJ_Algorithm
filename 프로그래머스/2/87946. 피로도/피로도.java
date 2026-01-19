class Solution {
		// answer : 유저가 탐험할 수 있는 최대 던전 수 
		int answer = -1;
		// 던전별 탐험 여부
		boolean[] isVisited;
		
		public int solution(int k, int[][] dungeons) {
			// k : 유저의 현재 피로도
			// dungeons : 각 던전별 [최소 필요 피로도, 소모 피로도] 
			isVisited = new boolean[dungeons.length];
			
			// 던전별 탐험 시작
			adventure(k, 0, dungeons);
			
			return answer;
		}
		
		// k:피로도 / count:현재까지의탐험수 / 던전배열
		public void adventure(int k, int count, int[][] dungeons) {
			// 탐험수 갱신
			answer = Math.max(answer, count);
			
			// 던전별 백트래킹을 활용하여 탐험진행
			for(int i=0; i<dungeons.length; i++) {
				// i번째 던전 탐험
				if(!isVisited[i] && k >= dungeons[i][0]) {
					isVisited[i] = true;	// 탐험여부 갱신
					// 다음 던전 탐험
					// 피로도, 카운트 갱신한 값으로 대입 
					adventure(k-dungeons[i][1], count+1, dungeons);
					// i번째 던전 탐험여부 복구 (백트래킹)
					isVisited[i] = false;
				}				
			}
			
		}
		
	}