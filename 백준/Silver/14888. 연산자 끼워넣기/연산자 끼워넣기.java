import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] numbers;
	static int[] operators = new int[4];
	static int max_value = Integer.MIN_VALUE;
	static int min_value = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 수의 개수 N
		N = Integer.parseInt(br.readLine());
		
		// N개의 수 
		numbers = new int[N];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		
		// 합이 N-1인 4개의 정수 
		// +의 개수, -의 개수, x의 개수, ÷의 개수
		input = br.readLine().split(" ");
		for(int i=0; i<4; i++) {
			operators[i] = Integer.parseInt(input[i]);
		}
		
		caculate(1, numbers[0]);
		
		System.out.println(max_value);
		System.out.println(min_value);
		br.close();
	}
	
	static void caculate(int index, int current_value) {
		// index번째 숫자까지 계산한 결과 = current_value
		// 1번째 숫자까지 계산한 결과 = numbers[0]
		
		// N번째 숫자까지 계산을 마쳤다면
		if(index == N) {
			max_value = Math.max(max_value, current_value);
			min_value = Math.min(min_value, current_value);
			return;
		}
		
		// 4가지 연산자에 대한 계산 
		for(int i=0; i<4; i++) {
			// 연산자 개수가 남아있다면
			if(operators[i] > 0) {
				// 연산자 사용 
				operators[i]--;
				
				// 연산자에 따라 계산 
				int next_value = 0;		// 계산값
				switch(i) {
					case 0:			// +
						// 현재까지 계산한 값 + 다음 인덱스에 해당하는 숫자 값
						next_value = current_value + numbers[index];
						break;
					case 1:			// -
						// 현재까지 계산한 값 - 다음 인덱스에 해당하는 숫자 값
						next_value = current_value - numbers[index];
						break;
					case 2:			// x
						// 현재까지 계산한 값 x 다음 인덱스에 해당하는 숫자 값
						next_value = current_value * numbers[index];
						break;
					case 3:			// ÷
						// 현재까지 계산한 값 ÷ 다음 인덱스에 해당하는 숫자 값
						// 음수를 나누는 경우
						if(current_value < 0) {
							next_value = -1 * (Math.abs(current_value)/numbers[index]);
						} else {
							next_value = current_value / numbers[index];
						}
						break;
				}
				
				// 다음 인덱스로 계산 (재귀 호출)
				caculate(index+1, next_value);	
				// 백트래킹 - 사용한 연산자 복구 
				operators[i]++;
			}
		}
		
	}
}