package backjun;

import java.io.*;
public class Main2 { 
	public static void main(String[] args) throws IOException { 
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		long[] arr = new long[num+1];
		arr[0]=0;
		arr[1]=1;
		
		for(int i=2;i<arr.length;i++) {
			arr[i]=arr[i-1]+arr[i-2];
		}
		
		System.out.println(arr[num]+" "+Long.MAX_VALUE);
	}
}





