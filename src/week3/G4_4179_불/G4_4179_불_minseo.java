package week3.G4_4179_불;

import java.awt.Point;

/**
 * @author 강민서
 * @date 2024.02.17
 * @link https://www.acmicpc.net/problem/4179
 * @keyword_solution 지훈이와 불은 매 분마다 한칸씩 수평또는 수직으로(비스듬하게 이동하지 않는다) 이동 그리고 얼마나 빨리 탈출할 수 있는지를 결정
 * => 같이 이동하므로 bfs에서 q를 두개 사용(같은 depth움직이기) , 최단 경로이기 때문에 BFS사용
 *  네 방향으로 확산 => 사방탐색 사용
 *  미로의 가장자리에 접한 공간에서 탈출 => 배열을 벗어나면 탈출 
 * @input 1 ≤ R, C ≤ 1000
 * @output 가장 빠른 탈출시간, 탈출 못 하면 IMPOSSIBLE 
 * @time_complex  O(RC + RC*4)
 * @perf 49108 532
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_4179_불_minseo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int R, C, jihun_x, jihun_y, fire_x, fire_y, result, size;
	static char[][] arr;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Queue<Point> fire_q = new ArrayDeque<>();
	static Queue<Point> jihun_q = new ArrayDeque<>();
	static boolean possible;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();

			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 'J') {
					jihun_q.offer(new Point(i, j));
				} else if (arr[i][j] == 'F') {
					fire_q.offer(new Point(i, j));
				}
			}
		}

		bfs();

	}

//	q를 2개 사용 => 지훈이랑 불 둘다 같이 움직이도록 size-- > 0 조건 추가 
	static void bfs() {

		int ax = 0;
		int ay = 0;
		int x = 0;
		int y = 0;

//		이동
		while (true) {
			size = fire_q.size();
			result++;
//			불 q
			while (size-- > 0) {
				Point cur = fire_q.poll();
				x = cur.x;
				y = cur.y;

				for (int i = 0; i < 4; i++) {
					ax = x + dx[i];
					ay = y + dy[i];

					if (!check(ax, ay) || arr[ax][ay] != '.') {
						continue;
					}

					arr[ax][ay] = 'F';
					fire_q.add(new Point(ax, ay));
				}

			}

//			지훈이 q
			size = jihun_q.size();

			while (size-- > 0) {
				Point cur = jihun_q.poll();
				x = cur.x;
				y = cur.y;

				for (int i = 0; i < 4; i++) {
					ax = x + dx[i];
					ay = y + dy[i];

					if (!check(ax, ay)) {
						System.out.println(result);
						return;
					}

					if (visited[ax][ay] || arr[ax][ay] != '.')
						continue;

					visited[ax][ay] = true; // 방문체크 이미 방문한건 q에 안 넣기
					jihun_q.add(new Point(ax, ay));

				}

			}

//			지훈이 큐가 비어있다면 더 이상 갈 수 있는곳이 없음 불가능 출력 
			if (jihun_q.isEmpty()) {
				System.out.println("IMPOSSIBLE");
				break;
			}

		}

	}

	static boolean check(int x, int y) {
		return (x >= 0 && x < R && y >= 0 && y < C);
	}

}
