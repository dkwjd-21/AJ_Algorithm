import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException  
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();		
		while(str!=null && !str.isEmpty())
		{
			String arr[] = str.split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			
			bw.write((a+b)+"\n");			
			str = br.readLine();
		}	
		
		bw.close();
	}
}