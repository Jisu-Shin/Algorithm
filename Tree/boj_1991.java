import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	char left,right;
	Node(char left,char right){
		this.left = left;
		this.right = right;
	}
}

public class Main {
	
	static Node[] tree;

	public static void preorder(char c) {
		int idx = c-'A';
		System.out.print(c);
		if(tree[idx].left!='.') preorder(tree[idx].left);
		if(tree[idx].right!='.') preorder(tree[idx].right);
	}

	public static void inorder(char c) {
		int idx = c-'A';
		if(tree[idx].left!='.') inorder(tree[idx].left);
		System.out.print(c);
		if(tree[idx].right!='.') inorder(tree[idx].right);
	}

	public static void postorder(char c) {
		int idx = c-'A';
		if(tree[idx].left!='.') postorder(tree[idx].left);
		if(tree[idx].right!='.') postorder(tree[idx].right);
		System.out.print(c);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		tree = new Node[num];
		
		while(num-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			tree[root-'A']=new Node(left,right);
		}
		
		preorder('A');
		System.out.println();
		inorder('A');
		System.out.println();
		postorder('A');
	}

}