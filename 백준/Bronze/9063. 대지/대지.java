import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫째 줄에 점의 개수 N이 주어짐
		int N = Integer.parseInt(br.readLine());
		if(N==1) {
			System.out.println(0);
		}else {
			// X 좌표들 배열 
			ArrayList<Integer> arrX = new ArrayList<Integer>();
			// Y 좌표들 배열
			ArrayList<Integer> arrY = new ArrayList<Integer>();
			
			for(int i=0; i<N; i++) {
				String[] input = br.readLine().split(" ");
				arrX.add(Integer.parseInt(input[0]));
				arrY.add(Integer.parseInt(input[1]));
			}
			
			// X, Y 좌표의 최소값 & 최대값 구하기 
			int minX = arrX.get(0), maxX = arrX.get(0);
			int minY = arrY.get(0), maxY = arrY.get(0);
			
			for(int i=1; i<N; i++) {
				if(arrX.get(i) < minX) {
					minX = arrX.get(i);
				}
				if(arrX.get(i) > maxX) {
					maxX = arrX.get(i);
				}
				if(arrY.get(i) < minY) {
					minY = arrY.get(i);
				}
				if(arrY.get(i) > maxY) {
					maxY = arrY.get(i);
				}
			}
			
			System.out.println((maxX-minX)*(maxY-minY));
		}		
		
		br.close();
	}
}