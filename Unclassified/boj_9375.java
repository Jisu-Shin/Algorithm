import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			HashMap<String,Integer>map = new HashMap<>();
			int clothes = Integer.parseInt(br.readLine());
			for(int j=0;j<clothes;j++) {
				String s = br.readLine();
				String kind = s.split(" ")[1];
				if(map.containsKey(kind)){
					map.put(kind,map.get(kind)+1);
				}
				else {
					map.put(kind, 2);
				}
			}
			int answer=1;
			for(String s : map.keySet()) {
				answer*=map.get(s);
			}
			System.out.println(answer-1);
		}
		
	}
}