import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr =new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int[] oper = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			oper[i]=Integer.parseInt(st.nextToken());
		}
		
		bfs(oper,arr[0],1);
		System.out.println(max+"\n"+min);
	}

	public static void bfs(int[]oper,int acc,int idx) {
		int new_acc=0;
		if(idx==n) {
			min = Math.min(min,acc);
			max = Math.max(max,acc);
		}
		
		if(oper[0]>0) {
			new_acc=acc+arr[idx];
			oper[0]--;
			bfs(oper,new_acc,idx+1);
			oper[0]++;
		}
		if(oper[1]>0) {
			new_acc=acc-arr[idx];
			oper[1]--;
			bfs(oper,new_acc,idx+1);
			oper[1]++;
		}
		if(oper[2]>0) {
			new_acc=acc*arr[idx];
			oper[2]--;
			bfs(oper,new_acc,idx+1);
			oper[2]++;
		}
		if(oper[3]>0) {
			new_acc=acc/arr[idx];
			oper[3]--;
			bfs(oper,new_acc,idx+1);
			oper[3]++;
		}
	}
}