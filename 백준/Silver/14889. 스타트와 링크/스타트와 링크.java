import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// 축구를 하기 위해 모인 N명 
	static int N;
	// 능력치 표 [N][N]
	static int ability[][];
	// 스타트 팀에 들어갔는지 여부 확인 [N]
	static boolean[] isStart;
	// 능력치 차이의 최솟값 
	static int minVal = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 축구를 하기 위해 모인 N명 
		N = Integer.parseInt(br.readLine());
		
		// N명의 능력치 표 입력
		ability = new int[N][N];
		for(int i=0; i<N; i++) {
			String input[] = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				ability[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		// 팀에 들어갔는지 여부 확인
		isStart = new boolean[N];
		
		// 백트래킹을 이용해 N/2명의 팀 조합 탐색
		findTeam(0, 0);
		
		// 결과 출력
		System.out.println(minVal);
		
		br.close();
	}
	
	// N/2명의 팀원 조합을 찾는 함수
	// start : 다음 탐색을 시작할 인덱스
	// depth : 현재까지 뽑은 팀원의 수 
	static void findTeam(int start, int depth) {
		// 스타트팀 : N명 중 N/2명만 뽑으면 됨 
		// -> 남은 사람들끼리 링크팀을 이룸
		
		// N/2명을 모두 뽑음 -> 종료
		if(depth == N/2) {
			// 두 팀의 능력치 차이를 계산. 
			calcAbility();
			return;
		}
		
		for(int i=start; i<N; i++) {
			// 스타트팀에 속하지 않은 선수면 
			if(!isStart[i]) {
				// 스타트 팀에 포함시킨다. 
				isStart[i] = true;
				// 다음 팀원을 찾는다.
				findTeam(i+1, depth+1);
				// 백트래킹 : i번째 선수를 다시 무소속으로 만든다 
				isStart[i] = false;
			}
		}
		
		
	}
	
	// 두 팀의 능력치 차이를 계산하는 함수
	static void calcAbility() {
		// 스타트 팀의 능력치
		int startTeam = 0;
		// 링크 팀의 능력치
		int linkTeam = 0;
		
		// i번째 선수와 j번째 선수가 같은 팀인지 확인해야함!!
		// -> 1번째 선수와 2, 3, 4번째선수 
		// -> 2번째 선수와 3, 4번째 선수
		// -> 3번째 선수와 4번째 선수 
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				// i번, j번 모두 스타트팀(isStart == true)인지 확인 
				if(isStart[i] && isStart[j]) {
					startTeam += ability[i][j] + ability[j][i];
				}
				// i번, j번 모두 링크(isStart == false)인지 확인 
				if(!isStart[i] && !isStart[j]) {
					linkTeam += ability[i][j] + ability[j][i];
				}
			}
		}
		
		// 두 팀의 능력치 차이 계산
		int diff = Math.abs(startTeam - linkTeam);
		
		// 만약 차이가 0이면, 프로그램 즉시 종료 (나올 수 있는 최솟값이기 때문에)
		if(diff == 0) {
			System.out.println(diff);
			System.exit(0);
		} else {
			// 최솟값 갱신
			minVal = Math.min(minVal, diff);
		}
	}
	
}