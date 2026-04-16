import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] years = new int[n];

		String[] input = br.readLine().split(" ");

		for(int i=0; i<n; i++) {
			years[i] = Integer.parseInt(input[i]);
		}

		int d = years[1] - years[0];
		bw.append(String.valueOf(years[n-1] + d));

		bw.close();
		br.close();
	}

}