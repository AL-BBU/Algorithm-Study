package week2.G5_14567_선수과목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_14567_선수과목_minseo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, A, B, semester;
	static ArrayList<Integer>[] list;
	static int[] depth, answer;
	static Queue<Integer> q = new ArrayDeque();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		depth = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			list[A].add(B);  // 인접리스트 연결
			depth[B]++;  // 과목 B가 나올 때 마다 증가 => 선수과목 수를 나타냄 
		}
		
		carc_program();
		
		for(int i = 1; i <= N; i++) {
			sb.append(answer[i] + " ");
		}
		
		System.out.println(sb);

	}

	static void carc_program() {
		for (int i = 1; i <= N; i++) {
			if (depth[i] == 0)
				q.offer(i);
		}
		answer = new int[N + 1];  // 출력을 위한 answer 배열 생성 index = 과목번호, value는 학기
		semester = 1;   // 학기 저장을 위한 변수
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {  // 그래프로 생각했을 때, depth를 나타냄 즉, 같은 depth를 먼저 탐색
				int current = q.poll();
				answer[current] = semester;

				for (int next : list[current]) {  
					if (--depth[next] == 0) {  // depth => 선수과목을 다 들었으면 0 
						q.offer(next);
					}
				}

			}

			semester++; // 같은 depth 과목들을 다 탐색 후 학기 증가 
		}

	}

}
