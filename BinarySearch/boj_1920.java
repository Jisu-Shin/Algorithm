package backjun;

import java.io.*;
import java.util.*;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		int n=Integer.parseInt(br.readLine());
		HashSet <String> map = new HashSet<String>();
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			map.add(st.nextToken());
		}
		
		n = Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			if(map.contains(st.nextToken())) {
				bw.write("1\n");
			}
			else {
				bw.write("0\n");
			}
		}
		bw.flush(); 
		bw.close();
	}
}


