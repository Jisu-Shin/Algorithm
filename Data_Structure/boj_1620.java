import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		TreeMap<String,Integer> tree = new TreeMap<>();
		String[] arr = new String[n];
		int cnt=0;
		while(n-->0) {
			String s = br.readLine();
			arr[cnt] = s;
			tree.put(s,++cnt);
		}
		
		while(m-->0) {
			String input = br.readLine();
			if(Character.isDigit(input.charAt(0))) {
				System.out.println(arr[Integer.parseInt(input)-1]);
			}
			else {
				System.out.println(tree.get(input));
			}
		}

	}
}