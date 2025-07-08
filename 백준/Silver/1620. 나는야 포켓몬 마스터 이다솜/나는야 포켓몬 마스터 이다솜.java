import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// N과 M 입력
		String[] input = br.readLine().split(" ");
		// 도감에 수록되어 있는 포켓몬의 개수 N 
		int N = Integer.parseInt(input[0]);
		// 맞춰야 하는 문제의 개수 M 
		int M = Integer.parseInt(input[1]);
		
		// 1번부터 N번 포켓몬 입력
		LinkedHashMap<String, String> pokemon = new LinkedHashMap<>();
		LinkedHashMap<String, String> pokemonR = new LinkedHashMap<>();
		for(int i=1; i<=N; i++) {
			String tmp = br.readLine();
			pokemon.put(i+"", tmp);
			pokemonR.put(tmp, i+"");
		}
		
		// M개 문제 입력
		for(int i=1; i<=M; i++) {
			String target = br.readLine();
			
			// target을 key로 하는 value값이 있는 경우
			if(pokemon.containsKey(target)) {
				// value값 출력
				bw.append(pokemon.get(target)+"\n");
				
			// target을 value로 하는 값이 있는 경우 
			} else if(pokemonR.containsKey(target)) {
				// key값 출력 
				bw.append(pokemonR.get(target)+"\n");
			}
		}
		
		bw.close();
		br.close();
	}
}