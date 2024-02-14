package week2.S2_18352_특정거리의도시찾기;

/**
 * @author 강민서
 * @date 2024.02.07
 * @link https://www.acmicpc.net/problem/18352
 * @keyword_solution  최단 거리가 정확히 K인 모든 도시들의 번호를 출력하는 프로그램을 작성 => 다익스트라
 * @input (2 ≤ N ≤ 300,000, 1 ≤ M ≤ 1,000,000, 1 ≤ K ≤ 300,000, 1 ≤ X ≤ N) 
 * @output 최단 거리가 K인 모든 도시의 번호를 한 줄에 하나씩 오름차순으로 출력 주의! 단 거리가 K인 도시가 하나도 존재하지 않으면 -1
 * @time_complex O(ElogV)
 * @perf 278260	1376
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 사실 이번 문제는 가중치가 모드 1이라 Edge 클래스 부분은 필요없음
class Edge implements Comparable<Edge> {

	int vertex;
	int value;

	Edge(int vertex, int value) {
		this.vertex = vertex;
		this.value = value;
	}

	@Override
	public int compareTo(Edge o) {
		if (this.value > o.value)
			return 1;
		else
			return -1;

	}

}

public class S2_18352_특정거리의도시찾기_minseo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, K, X, A, B;
	static PriorityQueue<Edge> q = new PriorityQueue<>();
	static ArrayList<Edge>[] list;
	static int[] distance;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		distance = new int[N + 1];

//		인접 리스트 초기화
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Edge>();
		}

//		인접 리스트 연결
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			list[A].add(new Edge(B, 1));
			
		}

//		노드 별 거리 최대값으로 초기화
		for (int i = 0; i <= N; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

//		시작 도시 X Q에 삽입
		q.offer(new Edge(X, 0));
		distance[X] = 0; // 자신에서 자신의 거리는 0

		
		while (!q.isEmpty()) {
			Edge current = q.poll();
			int current_vertex = current.vertex;

			if (visited[current_vertex])
				continue;
			visited[current_vertex] = true;

			for (int i = 0; i < list[current_vertex].size(); i++) {
				Edge temp = list[current_vertex].get(i);
				int next = temp.vertex;
				int value = temp.value;

				if (distance[next] > distance[current_vertex] + value) {
					distance[next] = distance[current_vertex] + value;
					q.offer(new Edge(next, distance[next]));
				}

			}

		}

//		정답 출력
		for (int i = 1; i <= N; i++) {
			if (distance[i] == K)
				sb.append(i + "\n");
		}
		if (sb.length() == 0) // sb가 비어있다면 최단거리 도시가 없음 
			sb.append(-1);

		System.out.println(sb);

	}

}
