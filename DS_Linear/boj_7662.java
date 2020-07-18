import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		while(n-->0) {
			TreeMap<Integer,Integer> map = new TreeMap<>();
			int m = Integer.parseInt(br.readLine());
			while(m-->0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String oper = st.nextToken();
				int num=Integer.parseInt(st.nextToken());
				switch(oper) {
				case "I":
					Integer val = map.get(num);
					map.put(num,val==null?1:val+1);
					break;
				case "D":
					if(map.isEmpty()) continue;
					int key = num==-1?map.firstKey():map.lastKey();
					val = map.get(key);
					if(val>1) {
						map.put(key,val-1);
					}
					else map.remove(key);

					break;
				}
			}

			if(map.isEmpty()) {
				bw.write("EMPTY\n");
			}
			else {
				bw.write(String.valueOf(map.lastKey())+" "+String.valueOf(map.firstKey())+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
}