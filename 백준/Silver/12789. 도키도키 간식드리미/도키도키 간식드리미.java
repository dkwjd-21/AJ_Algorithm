import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 학생들의 수 N
		int N = Integer.parseInt(br.readLine());

		// N명의 학생들의 번호표
		String input[] = br.readLine().split(" ");
		Stack<Integer> line = new Stack<>();
		for (int i = input.length - 1; i >= 0; i--) {
			line.push(Integer.parseInt(input[i]));
		}

		// 대기열
		Stack<Integer> waiting = new Stack<>();

		// 간식을 받은 학생들의 수
		int cnt = 0;
		
		// N번 반복
		for(int i=1; i<=N; i++) {
			if(line.contains(i)) {
				// i번째 간식을 받을 학생이 줄에 서있는 경우
				// 사이즈가 가변되므로 따로 저장해둔다.
				int size = line.size();
				
				for(int j=line.indexOf(i)+1; j<size; j++) {
					// i번째 학생 앞에 서있는 학생들을 대기열로 이동시킨다. 
					waiting.push(line.pop());
				}
				// i번째 학생에게 간식을 준다.
				line.pop();
				cnt++;
				
			} else if(waiting.peek() == i) {
				// i번째 학생이 대기열의 맨 위에 서 있을 경우 
				// i번째 학생에게 간식을 준다. 
				waiting.pop();
				cnt++;
				
			} else {
				// i번째 학생이 간식을 받을 수 없는 경우
				break;
			}			
		}
		
		// 모든 학생이 간식을 받았을 경우
		if(cnt == N) {
			bw.append("Nice");
		} else {
			bw.append("Sad");
		}
		

		bw.close();
		br.close();
	}
}