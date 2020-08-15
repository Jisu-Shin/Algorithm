import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int m = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> prio = new PriorityQueue<>();
		while(m-->0) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				if(prio.isEmpty()) bw.write("0\n");
				else bw.write(String.valueOf(prio.poll())+"\n");
			}
			else {
				prio.add(n);
			}
		}
		bw.flush();
		bw.close();
	}
}