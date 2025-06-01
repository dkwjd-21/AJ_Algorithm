import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    // 첫째 줄에 두 수 A와 B 
    String input[] = br.readLine().split(" ");
    // StringBuffer의 reverse() 메소드 
    String A = new StringBuffer(input[0]).reverse().toString();
    String B = new StringBuffer(input[1]).reverse().toString();
    
    if(Integer.parseInt(A) > Integer.parseInt(B)) {
    	System.out.println(A);
    }else {
    	System.out.println(B);
    }      
  }
}