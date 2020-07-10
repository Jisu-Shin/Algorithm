package backjun;

import java.io.*;
import java.util.*;

public class Main2 {

	static class Member implements Comparable<Member>{
		int age;
		String name;
		public Member(int age,String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Member o1) {
			// TODO Auto-generated method stub
			return this.age-o1.age;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		int n=Integer.parseInt(br.readLine());

		Member[] arr = new Member[n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Member(Integer.parseInt(st.nextToken()),st.nextToken());
		}

		Arrays.sort(arr);

		for(Member m : arr) {
			bw.write(m.age+" "+m.name+"\n");
		}

		bw.flush(); 
		bw.close();
	}
}


