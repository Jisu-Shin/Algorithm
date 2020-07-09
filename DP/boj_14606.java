package backjun;

import java.io.*;
import java.util.*;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int top=Integer.parseInt(br.readLine());

		int[] arr = new int[11];
		for(int i=2;i<arr.length;i++) {
			int a = i/2; 
			int b= i-a; //최대의 값을 뽑기 위해 '/2'를 한다
			arr[i]=a*b+arr[a]+arr[b]; // 그 아래로 내려가지 않기 위해 배열에 값을 저장해놓은다
		}
		
		System.out.println(arr[top]);
		
	}
}


