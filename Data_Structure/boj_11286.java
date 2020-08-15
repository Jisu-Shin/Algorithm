import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> nega = new PriorityQueue<>();
		PriorityQueue<Integer> posi = new PriorityQueue<>();

		while(m-->0) {
			int x = Integer.parseInt(br.readLine());
			if(x<0) nega.add(x*-1);
			else if(x>0) posi.add(x);
			else {
				Integer ne = nega.peek();
				Integer po = posi.peek();
				if(ne==null&&po==null) System.out.println(0);
				else if(ne==null) System.out.println(posi.poll());
				else if(po==null) System.out.println(nega.poll()*-1);

				else{
					if(ne<=po) {
						System.out.println(nega.poll()*-1);
					}
					else {
						System.out.println(posi.poll());
					}
				}
			}

		}
	}

}