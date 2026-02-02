import java.util.Arrays;

class Solution {
		public int solution(int[] people, int limit) {
			// people : 사람들의 몸무게를 담은 배열
			// limit : 구명보트의 무게 제한
			// 모든 사람을 구출하기 위해 필요한 구명보트 개수
			int answer = 0;

			// 오름차순 정렬
			Arrays.sort(people);
			int heavy = people.length - 1; // 가장무거운사람 인덱스
			int light = 0; // 가장가벼운사람 인덱스

			while (heavy > light) {
				// 가장 가벼운 사람과 가장 무거운 사람이 같이 탈 수 있는지
				if (people[heavy] + people[light] <= limit) {
					// 둘을 구명보트에 태움
					heavy--;
					light++;
					answer++;
				} else {
					// 가장 무거운 사람은 혼자 타야함
					heavy--;
					answer++;
				}
			}

			// 만약 heavy == light인 경우 한 사람이 남았다는 것
			if (heavy == light)
				answer++;

			return answer;
		}
	}