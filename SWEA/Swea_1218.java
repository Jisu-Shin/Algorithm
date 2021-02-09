package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Swea_1218 {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1;tc<=10;tc++) {
			Stack<Character> st = new Stack();
			
			sb.append("#"+tc+" ");

			int len = Integer.parseInt(br.readLine());			
			if(len%2==1) sb.append("0\n");//홀수이면 짝 안맞음
			else {				
				char[] arr = br.readLine().toCharArray();
				
				for(int i=0;i<arr.length;i++) {
					if (arr[i]==')'&& st.peek()=='('){
						st.pop();
					} else if(arr[i]==']'&&st.peek()=='[') {
						st.pop();
					} else if (arr[i]== '}' && st.peek()=='{') {
						st.pop();
					} else if (arr[i]=='>'&& st.peek()=='<') {
						st.pop();
					}else {
						st.add(arr[i]);
					}			
				}
				if(st.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
			}
		}
		System.out.println(sb);
	}

}
