package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = br.readLine();
			if(s.equals(".")) break;
			Stack<Character> st = new Stack<>();
			
			for(char c : s.toCharArray()) {
				switch (c) {
				case '(':
					st.push(c);
					break;
				case ')':
					if(!st.isEmpty() && st.peek()=='(' ) st.pop();
					else st.push(c);
					break;
				case '[':
					st.push(c);
					break;
				case ']':
					if(!st.isEmpty() && st.peek()=='[') st.pop();
					else st.push(c);
					break;
				}
			}

			if(st.size()==0) sb.append("yes\n");
			else sb.append("no\n");
		}

		System.out.println(sb);
	}
}


