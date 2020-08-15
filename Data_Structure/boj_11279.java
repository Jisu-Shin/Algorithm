import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int m = Integer.parseInt(br.readLine());
		TreeMap<Integer,Integer> tree = new TreeMap();
		
		while(m-->0) {
			int n = Integer.parseInt(br.readLine());
			
			if(n==0) {
				if(tree.isEmpty()) bw.write("0\n");
				else {
					int key = tree.lastKey();
					int val = tree.get(key);
					bw.write(String.valueOf(key)+"\n");
					
					if(val==1) {
						tree.remove(key);
					}
					else tree.put(key,val-1);
				}
			}
			else {
				Integer val = tree.get(n);
				tree.put(n, val=val==null?1:val+1);
			}
		}
		bw.flush();
		bw.close();
	}
}