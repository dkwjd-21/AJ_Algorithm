import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 수의 개수 N (N은 홀수!)  
		int N = Integer.parseInt(br.readLine());
		
		// N개의 수
		int input[] = new int[N];
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		// 오름차순 정렬
		Arrays.sort(input);
		
		// 산술평균 : N개의 수들의 합을 N으로 나눈 값 
		// 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
		bw.append(ArithmeticMean(input)+"\n");
		
		// 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
		bw.append(Median(input)+"\n");
		
		// 최빈값 : N개의 수들 중 가장 많이 나타나는 값
		// 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
		bw.append(Mode(input)+"\n");
		
		// 범위 : N개의 수들 중 최댓값과 최솟값의 차이 
		bw.append((input[input.length-1]-input[0])+"");
		
		bw.close();
		br.close();
	}
	
	// 산술평균 
	public static long ArithmeticMean(int[] arr) {
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		
		double mean = (double)sum/arr.length;
		
		// Math.round() : 소수점 첫째 자리에서 반올림한다. 
		return Math.round(mean);
	}
	
	// 중앙값
	public static int Median(int[] arr) {		
		return arr[arr.length/2];
	}
	
	// 최빈값
	public static int Mode(int[] arr) {
		// 값의 범위는 -4000 ~ 4000 -> val.  
		// --> 0 ~ 8000 배열 -> 4000+val 인덱스로 접근 
		int[] cnt = new int[8001];
		
		for(int i=0; i<arr.length; i++) {
			int value = arr[i];
			 
			cnt[4000+value]++;
		}
		
		// 카운트가 큰 인덱스 찾기 
		ArrayList<Integer> max = new ArrayList<>();
		int maxVal = 0;
		for(int i=0; i<cnt.length; i++) {
			if(maxVal < cnt[i]) {
				maxVal = cnt[i];
				max.clear();
				max.add(i-4000);
			} else if(maxVal == cnt[i]) {
				max.add(i-4000);
			}
		}
		
		if(max.size()==1) {
			return max.get(0);
		} else {
			Collections.sort(max);
			
			// 최빈값이 여러 개 있을 때는 두 번째로 작은 값을 출력한다. 
			return max.get(1);
		}
	}
}