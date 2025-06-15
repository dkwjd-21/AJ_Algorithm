import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			
			if(A==0 && B==0) {
				break;
			}else {
				// A가 B의 약수이다. 
				boolean factor = (B%A == 0);
				// A가 B의 배수이다. (B가 A의 약수이다) 
				boolean multiple = (A%B == 0);
				
				if(factor) {
					System.out.println("factor");
				}else if(multiple) {
					System.out.println("multiple");
				}else {
					System.out.println("neither");
				}				
			}			
		}
		
		br.close();
	}
}