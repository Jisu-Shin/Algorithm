package backjun;

import java.io.*;
import java.util.*;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		int n=Integer.parseInt(br.readLine());

		Stack<String> st = new Stack<>();
		String answer="";
		for(int i=0;i<n;i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			switch(token.nextToken()) {
			case "push" :
				st.push(token.nextToken());
				break;
				
			case "pop" :
				if(st.isEmpty()) bw.write("-1\n");
				else bw.write(st.pop()+"\n");
				break;
				
			case "size":
				bw.write(st.size()+"\n");
				break;
			
			case "empty":
				if(st.isEmpty()) bw.write("1\n");
				else bw.write("0\n");
				break;
				
			case "top":
				if(st.isEmpty()) bw.write("-1\n");
				else bw.write(st.peek()+"\n");
				break;
			}
		}
		bw.flush();
		bw.close();
	}
}


