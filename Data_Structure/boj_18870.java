package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		TreeMap<Integer,Integer> map = new TreeMap<>();
		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i]=num;
			map.put(num, 0);
		}

		int idx=0;
		for(int k : map.keySet()) {
			map.put(k, idx++);
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(map.get(arr[i])+" ");
		}
	}
}



