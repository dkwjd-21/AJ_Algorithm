import java.io.*;
import java.util.StringTokenizer;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    // 숫자의 개수 n
    int n = Integer.parseInt(br.readLine());
    String input = br.readLine();
    int sum = 0;
    // 숫자 n개 입력
    for(int i=0; i<n; i++) {
    	sum += Character.getNumericValue(input.charAt(i));
    }
    System.out.println(sum);
  }
}