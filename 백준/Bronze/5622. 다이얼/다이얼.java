import java.io.*;
import java.util.LinkedHashMap;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    // 1: 2초 / 2:3초 ~ ... ~ 0: 11초
    // 2: ABC / 3: DEF ~ ... ~ 9: WXYZ
    
    // 대문자로 이루어진 단어 입력
    String input = br.readLine();
    
    // 링크드해쉬맵으로 key=알파벳, value=걸리는 시간
    // 일반 해쉬맵은 순서를 기억하지 못함. 
    LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
    map.put("ABC", "3");
    map.put("DEF", "4");
    map.put("GHI", "5");
    map.put("JKL", "6");
    map.put("MNO", "7");
    map.put("PQRS", "8");
    map.put("TUV", "9");
    map.put("WXYZ", "10");
    
    // 전체 시간
    int totalTime = 0;
    
    // input 길이만큼 반복
    for(int i=0; i<input.length(); i++) {
    	char ch = input.charAt(i);
    	
    	// map의 key 개수만큼 반복
    	for(String key : map.keySet()) {
    		if(key.contains(String.valueOf(ch))) {
    			totalTime += Integer.parseInt(map.get(key));
    			break;
    		}
    	}
    }    
    
    System.out.println(totalTime);
    br.close();
  }
}