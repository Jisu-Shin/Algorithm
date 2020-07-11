package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		LinkedList<String> que = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());

		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push":
				que.add(st.nextToken());
				break;
			case "pop":
				if(que.isEmpty()) bw.write("-1\n");
				else bw.write(que.remove()+"\n");
				break;
			case "size":
				bw.write(que.size()+"\n");
				break;
			case "empty":
				if(que.isEmpty()) bw.write("1\n");
				else bw.write("0\n");
				break;
			case "front":
				if(que.isEmpty()) bw.write("-1\n");
				else bw.write(que.peek()+"\n");
				break;
			case "back":
				if(que.isEmpty()) bw.write("-1\n");
				else bw.write(que.peekLast()+"\n");
				break;
			}
		}
		bw.flush();
		bw.close();

	}
}


