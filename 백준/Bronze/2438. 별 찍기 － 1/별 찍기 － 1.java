import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException  
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				bw.write("*");
			}
			bw.write("\n");
		}
		
		bw.close();
	}
}