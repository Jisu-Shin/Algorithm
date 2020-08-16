import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> q = new ArrayDeque<>();

		while(n-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order=st.nextToken();
			int num;
			switch(order) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				if(!q.contains(num)) {
					q.add(num);
				}
				break;
			case "check":
				num = Integer.parseInt(st.nextToken());
				if(q.contains(num)) bw.write("1"+"\n");
				else bw.write("0"+"\n");
				break;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				if(q.contains(num)) {
					q.remove(num);
				}
				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				if(q.contains(num)) {
					q.remove(num);
				}
				else q.add(num);
				break;
			case "all":
				q.clear();
				for(int i=1;i<21;i++) {
					q.add(i);
				}
				break;
			case "empty":
				q.clear();
				break;
			}
		}
		bw.flush();
		bw.close();

	}
}