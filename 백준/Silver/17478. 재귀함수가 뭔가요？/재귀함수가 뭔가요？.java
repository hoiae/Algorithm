
import java.util.*;
import java.io.*;
public class Main {
	
	static String[] scripts = {
			"\"재귀함수가 뭔가요?\"",
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"",
			"라고 답변하였지."
	};
	static String bar = "____";
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
		recursive(0,n);
		System.out.println(sb);
	}

	private static void recursive(int cur, int end) {
		if(cur >= end) {
			addBar(cur);
			sb.append(scripts[0]).append("\n");
			
			addBar(cur);
			sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
			addBar(cur);
			sb.append(scripts[4]).append("\n");
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			addBar(cur);
			sb.append(scripts[i]).append("\n");
		}
		
		//기준
		recursive(cur + 1, end);
		addBar(cur);
		sb.append(scripts[4]).append("\n");
	}

	private static void addBar(int cur) {
		for(int j = 0;  j < cur; j++) {
			sb.append(bar);
		}
	}

}
