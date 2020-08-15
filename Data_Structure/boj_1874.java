package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2 {
	static Stack<Integer> st = new Stack<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		st.push(0);
		StringBuilder sb = new StringBuilder();
		int max=0;
		
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(br.readLine());
			
			if(st.peek()<=num) {
				sb=push(num,sb,max);
			}
			else {
				System.out.println("NO");
				return;
			}
			
			max=Math.max(max,st.pop());
			sb.append("-\n");
		}
		System.out.println(sb);
	}
	
	public static StringBuilder push(int num,StringBuilder sb,int max) {
		for(int i=max+1;i<=num;i++) {
			st.push(i);
			sb.append("+\n");
		}
		return sb; 
	}
}

