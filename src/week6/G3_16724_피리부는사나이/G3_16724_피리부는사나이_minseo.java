package week6.G3_16724_피리부는사나이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class G3_16724_피리부는사나이_minseo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, result;
	static Node[][] arr;
	static int[] dx = { 1, -1, 0, 0 }; // D, U, R, L
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] visited;
	static int[] parents;

//	행렬 번호와 방향을 함께 계산하기 위해 클래스 생성 
	static class Node {
		char dist;
		int num;

		public Node(char dist, int num) {
			super();
			this.dist = dist;
			this.num = num;
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new Node[n][m];
		visited = new boolean[n][m];
		parents = new int[n * m + 1];

//		유니온파인드 parents 초기화
		for (int i = 1; i < n * m + 1; i++) {
			parents[i] = i;
		}
		int cnt = 1;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < m; j++) {
				arr[i][j] = new Node(str.charAt(j), cnt);
				cnt++;
			}
		}


//		배열 탐색하면서 find로 부모가 동일한지 확인
//		동일하지 않다면 union해서 같은 그룹으로 묶기 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int next = nextDist(i, j, arr[i][j].dist);
				if (find(arr[i][j].num) != find(next)) {
					union(arr[i][j].num, next);
				}
			}
		}

		for (int i = 1; i < parents.length; i++) {
			parents[i] = find(i);
		}

		// set으로 다른 집합 수 출력 
		Set<Integer> s = new HashSet<>();
		for (int i = 1; i < parents.length; i++) {
			s.add(parents[i]);
		}

		System.out.println(s.size());
	}

//	그래프 탐색
	static int nextDist(int x, int y, char d) {

		int ax = 0, ay = 0;

		if (d == 'D') {
			ax = x + dx[0];
			ay = y + dy[0];

		} else if (d == 'U') {
			ax = x + dx[1];
			ay = y + dy[1];
		} else if (d == 'R') {
			ax = x + dx[2];
			ay = y + dy[2];
		} else {
			ax = x + dx[3];
			ay = y + dy[3];
		}

		return arr[ax][ay].num;

	}

//	유니온
	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x < y) {
			parents[y] = x;
		} else {
			parents[x] = y;
		}
	}

//	파인드
	static int find(int x) {
		if (parents[x] == x) {
			return x;
		}

		return parents[x] = find(parents[x]);
	}

}
