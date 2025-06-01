import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String input = br.readLine().trim();
    String res[] = input.split(" ");
    if(res[0] == "") {
    	System.out.println("0");
    }else {
    	System.out.println(res.length);
    }       
  }
}