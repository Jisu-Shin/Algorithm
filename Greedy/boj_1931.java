import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}

		Comparator<int[]> c1 = (o1,o2)->{
			if(o1[1]==o2[1]) return o1[0]-o2[0];
			else return o1[1]-o2[1];
		};
		Arrays.sort(arr,c1);

		int y = arr[0][1];
		int answer=1;
		for(int i=1;i<n;i++) {
			if(arr[i][0]>=y){
				answer++;
				y=arr[i][1];
			}
		}
		System.out.println(answer);
	}
}