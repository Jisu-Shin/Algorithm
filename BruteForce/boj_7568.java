import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Man{
	int height,weight,rank;
	Man(int w,int h){
		weight = w;
		height = h;
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Man[] arr = new Man[n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			Man m = new Man(w,h);
			arr[i] = m;
		}
		for(int i = 0 ;i <arr.length;i++) {
			int r = 1;
			for(int j=0;j<arr.length;j++) {
				if(arr[i].weight<arr[j].weight&&arr[i].height<arr[j].height) {
					r++;
				}
			}
			System.out.print(r+" ");
		}
	}
}