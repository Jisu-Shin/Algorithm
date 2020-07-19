import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class Main {

	static Deque<String> deque;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		while(n-->0){
			String function = br.readLine();
			int cnt = Integer.parseInt(br.readLine());
			String s = br.readLine();
			String[]sarr=s.substring(1,s.length()-1).split(",");

			deque = new ArrayDeque<>();
			for(int i=0;i<cnt;i++) {
				deque.add(sarr[i]);
			}

			System.out.println(AC(function,s));

		}
	}

	public static String AC(String function, String s) {
		int order = -1;
		for(char c : function.toCharArray()) {
			switch(c) {
			case 'R':
				order*=-1;
				break;
			case 'D':
				if(deque.isEmpty()) {
					return "error";
				}
				if(order<0 && !deque.isEmpty()) deque.removeFirst();
				else if (order>0 && !deque.isEmpty()) deque.removeLast();
				break;
			}
		}

		StringBuilder sb = new StringBuilder();

		sb.append("[");
		while(!deque.isEmpty()) {
			if(order<0) {
				sb.append(deque.removeFirst());	
			}
			else {
				sb.append(deque.removeLast());
			}
			if(!deque.isEmpty()) {
				sb.append(",");
			}

		}
		sb.append("]");
		return sb.toString();
	}
}