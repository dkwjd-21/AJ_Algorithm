import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	static int cnt=0;
	static ArrayList<Integer> swap = new ArrayList<>();
	static int[] tmp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 배열 A의 크기 N
		// 저장횟수 K
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		// 배열 A의 원소 
		int[] arr = new int[N];
		input = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		} 
		
		tmp = new int[N];
		merge_sort(arr, 0, arr.length-1);
		
		// K번째 저장되는 수 출력
		// 저장 횟수가 K보다 작으면 -1을 출력한다. 		
		if(cnt<K) {
			bw.append("-1");
		} else {
			bw.append(swap.get(K-1)+"");
		}
		
		bw.close();
		br.close();
	}	
	
	// 배열 A를 오름차순 정렬한다. 
	public static void merge_sort(int[] A, int left, int right) {
		// left & right : 배열에 접근하기 위한 인덱스커서
		if(left < right) {
			// center는 left, right의 중간지점 
			int center = (left+right)/2;
			// 전반부 정렬
			merge_sort(A, left, center);
			// 후반부 정렬
			merge_sort(A, center+1, right);
			// 병합
			merge(A, left, center, right);
		}
	}
	
	// A(left ~ center)와 A(center+1 ~ right) 병합
	// A(left ~ right)를 오름차순 정렬된 상태로 만든다
	// A(left ~ center)와 A(center+1 ~ right)는 이미 오름차순 정렬되어있다. 
	public static void merge(int[] A, int left, int center, int right) {
		int i = left;
		int j = center + 1;
		int t = 0;
		
		while(i <= center && j <= right) {
			if(A[i] <= A[j]) {
				tmp[t++] = A[i++];
			} else {
				tmp[t++] = A[j++];
			}
		}
		
		// 왼쪽 배열 부분이 남은 경우
		while(i <= center) {
			tmp[t++] = A[i++];
		} 
		
		// 오른쪽 배열 부분이 남은 경우
		while(j <= right) {
			tmp[t++] = A[j++];
		}
		
		i=left; 
		t=0;
		
		// 결과를 A[]에 저장
		while(i<=right) {
			cnt++;
			swap.add(tmp[t]);
			A[i++] = tmp[t++];
		}
	}
} 