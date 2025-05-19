import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException  
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		
		do
		{
			bw.write(a+b+"\n");
			
			String str2[] = br.readLine().split(" ");
			a = Integer.parseInt(str2[0]);
			b = Integer.parseInt(str2[1]);
		}while(a!=0 && b!=0);
		
		bw.close();
	}
}