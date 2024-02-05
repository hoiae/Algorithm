import java.util.*;
import java.io.*;

public class Main {
	private static final String Node = null;
	static int N, K;
	static List<Integer> ans = new ArrayList<>();

	static class Node {
		int number;
		Node next;

		public Node() {

		}

		public Node(int number) {
			this.number = number;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		solve();
		print();

	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i = 0;  i < ans.size(); i++) {
			sb.append(ans.get(i));
			if(i != ans.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append(">");
		System.out.println(sb);
	}

	private static void solve() {

		// 첫번째 노드
		Node firstNode = new Node(1);

		Node temp = firstNode;
		Node lastNode = firstNode; //입력이 1 1인 경우 예외처리
		for (int i = 2; i <= N; i++) {
			lastNode = new Node(i);
			temp.next = lastNode;
			temp = lastNode;
		}

		// 마지막 노드에 첫번째 노드 연결
		lastNode.next = firstNode;

		makePermutation(firstNode);
	}

	private static void makePermutation(Node firstNode) {
		Node currentNode = firstNode;

		while (ans.size() != N) {
			// k번만큼 이동
			Node preNode = currentNode;
			for (int i = 0; i < K - 1; i++) {
				preNode = currentNode;
				currentNode = currentNode.next;
			}

			// 현재 노드의 number을 ans에 추가한 후, 노드를 삭제함
			ans.add(currentNode.number);
			currentNode = currentNode.next;
			preNode.next = currentNode;

		}
	}

}