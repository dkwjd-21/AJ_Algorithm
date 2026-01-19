import java.util.LinkedList;
import java.util.Queue;

class Solution {
		// 두 전력망이 가지고 있는 송전탑 개수의 차이 (최솟값)
		int answer = Integer.MAX_VALUE;
		
		public int solution(int n, int[][] wires) {
			// n : 송전탑의 개수
			// wires : 전선 정보 
			
			// 송전탑이 연결된 정보를 저장하는 행렬 
			// ex) 1번 3번 연결 -> connect[1][3] == connect[3][1] = 1
			int[][] connect = new int[n+1][n+1];
			for(int i=0; i<wires.length; i++) {
				int[] wire = wires[i];
				connect[wire[0]][wire[1]] = 1;
				connect[wire[1]][wire[0]] = 1;
			}
			
			// 모든 전선을 하나씩 끊어보기 
			for(int i=0; i<wires.length; i++) {
				// ex) 1번 3번 끊기 -> v1=1, v2=3
				int v1 = wires[i][0];
				int v2 = wires[i][1];
				connect[v1][v2] = 0;
				connect[v2][v1] = 0;
				
				// 두 전력망이 가진 송전탑의 개수 세기
				int count = count(1, n, connect);
				int diff = Math.abs(count - (n - count));
				
				// 전력차이의 최소값 
				answer = Math.min(answer, diff);
				
				// 전선 복구
				connect[v1][v2] = 1;
				connect[v2][v1] = 1;
			}
			
			return answer;
		}
		
		// 전력망이 가진 송전탑의 개수를 세는 메서드
		// 시작 송전탑 번호, 전체 송전탑 개수, 연결정보행렬
		public int count(int start, int n, int[][] connect) {
			// 송전탑 체크 여부
			boolean[] isCheck = new boolean[n+1];
			// 연결된 송전탑 큐
			Queue<Integer> connectedQueue = new LinkedList<Integer>();
			// 연결된 송전탑 개수 
			int count = 1;
			
			// start번쨰의 송전탑부터 시작
			isCheck[start] = true;
			connectedQueue.add(start);
			
			while(!connectedQueue.isEmpty()) {
				int current = connectedQueue.poll();
				
				for(int next=1; next<=n; next++) {
					// 다음 송전탑 체크 
					// 체크한 적 없고, 현재 송전탑과 연결되어 있다면 진행
					if(!isCheck[next] && connect[current][next] == 1) {
						// 방문 
						isCheck[next] = true;
						connectedQueue.add(next);
						count++;
					}
				}
			}
			
			
			return count;
		}
	}