package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		ArrayList<Integer> num = new ArrayList();
		ArrayList<Character> oper = new ArrayList();

		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if(Character.isDigit(c)) {
				sb.append(c);
			}
			else {
				num.add(Integer.parseInt(sb.toString()));
				sb= new StringBuilder();
				oper.add(c);
			}
		}
		num.add(Integer.parseInt(sb.toString()));
		
		for(int i=0;i<oper.size();i++) {
			if(oper.get(i)=='+') {
				int sum = num.remove(i)+num.remove(i);
				num.add(i, sum);
				oper.remove(i);
				i--;
			}
		}
		
		int answer=num.get(0);
		for(int i=1;i<num.size();i++) {
			answer-=num.get(i);
		}
		System.out.println(answer);


	}
}
