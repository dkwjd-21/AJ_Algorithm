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
		
		String input = "";
		
		while((input=br.readLine()) != null) {
			// input = N 
			int N = Integer.parseInt(input);
			
			String str = "-".repeat((int) Math.pow(3, N));
			
			System.out.println(cantor(str));
		}
		
		bw.close();
		br.close();
	}	
	
	public static String cantor(String str) {
		if(str.length()==1) {
			return "-";
		} else if(str.length()==3) {
			return "- -";
		} else {
			String fir = str.substring(0, str.length()/3);
			String sec = str.substring(str.length()/3, 2*str.length()/3);
			String thr = str.substring(2*str.length()/3, str.length());
			sec = sec.replaceAll("-", " ");
			
			return cantor(fir)+sec+cantor(thr);
		}		
	}
} 