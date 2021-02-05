package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17478 {

	static StringBuilder sb = new StringBuilder("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\r\n");
	static StringBuilder sb2 = new StringBuilder("\"재귀함수가 뭔가요?\"\r\n"); 
	static StringBuilder sb3 =new StringBuilder("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\r\n");
	static StringBuilder sb4 =new StringBuilder("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\r\n");
	static StringBuilder sb5 =new StringBuilder("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\r\n");
	static StringBuilder sb6 = new StringBuilder("라고 답변하였지.\r\n");

	static StringBuilder ans = new StringBuilder();


	public static void recur(int start, int end) {
		
		StringBuilder line = new StringBuilder();
		for(int i=0;i<start;i++) {
			line.append("____");
		}
		
		if(start==end) {
			ans.append(line).append(sb2);
			ans.append(line).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\r\n");
			ans.append(line).append(sb6);
			return;
		}
		else {
			ans.append(line).append(sb2);
			ans.append(line).append(sb3);
			ans.append(line).append(sb4);
			ans.append(line).append(sb5);
		}

		recur(start+1,end);
		ans.append(line).append(sb6);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int end = Integer.parseInt(br.readLine());
		ans.append(sb);
		recur(0,end);
		//System.out.println(ans);
		StringBuilder sb = new StringBuilder("a\n");
		System.out.print(sb.length());
		System.out.print(sb);
		sb.setLength(sb.length()-1);
		System.out.print(sb);

		

	}

}