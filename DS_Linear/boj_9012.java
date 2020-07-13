import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			Stack<Character> st = new Stack<>();
			for(char c :s.toCharArray()) {
				switch(c) {
				case '(': 
					st.push(c);
					break;
				case ')':
					if(!st.isEmpty()&&st.peek()=='(') st.pop();
					else st.push(c);
					break;
				}
			}
			if(st.size()==0) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.println(sb);
		
	}
}