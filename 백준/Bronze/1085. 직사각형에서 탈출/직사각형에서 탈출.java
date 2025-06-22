import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[] = br.readLine().split(" ");
		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);
		int w = Integer.parseInt(input[2]);
		int h = Integer.parseInt(input[3]);
		
		// min 값을 x와 y중 작은 값으로 설정 
		int min = (x<y)? x:y;
		
		// w-x 값이 min 보다 작으면 그 값으로 설정 
		min = (w-x)<min? (w-x):min; 
		// h-y 값이 min 보다 작으면 그 값으로 설정
		min = (h-y)<min? (h-y):min;
		
		System.out.println(min);
		
		br.close();		
	}
}