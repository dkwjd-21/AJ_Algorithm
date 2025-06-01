import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
    
    String input;
    
    // 입력받은 그대로 출력하기
    while((input=br.readLine()) != null) {
    	System.out.println(input);
    }
    
    br.close();
  }
}