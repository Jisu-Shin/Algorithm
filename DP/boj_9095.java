package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {	
		int[] arr =new int[11];
		arr[1]=1; arr[2]=2; arr[3]=4;
		for(int i=4;i<arr.length;i++) {
			arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(arr[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.println(sb);
	}
}


