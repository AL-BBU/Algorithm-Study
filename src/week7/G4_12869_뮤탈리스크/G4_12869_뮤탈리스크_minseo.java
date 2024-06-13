package week7.G4_12869_뮤탈리스크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G4_12869_뮤탈리스크_minseo {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] arr;
    static ArrayList<int[]> attackPattern;
    static ArrayDeque<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[3];
        attackPattern = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 가능한 모든 공격 패턴 추가
        // 메모리 초과나서 순열코드에서 하드코딩으로 변경
        attackPattern.add(new int[]{9, 3, 1});
        attackPattern.add(new int[]{9, 1, 3});
        attackPattern.add(new int[]{3, 9, 1});
        attackPattern.add(new int[]{3, 1, 9});
        attackPattern.add(new int[]{1, 9, 3});
        attackPattern.add(new int[]{1, 3, 9});

        System.out.println(bfs());
    }

    // bfs로 모든 경우 공격 후 최솟값 구하기
    static int bfs() {
//       탐색 최소화를 위해 방문체크 없어도 답은 나옴
        boolean[][][] visited = new boolean[61][61][61];
        q.offer(new int[]{arr[0], arr[1], arr[2], 0});
        visited[arr[0]][arr[1]][arr[2]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int h1 = cur[0];
            int h2 = cur[1];
            int h3 = cur[2];
            int attackCount = cur[3];

            // 모든 SCV가 파괴된 경우
            if (h1 <= 0 && h2 <= 0 && h3 <= 0) {
                return attackCount;
            }

            for (int[] mutal : attackPattern) {
                int nh1 = Math.max(0, h1 - mutal[0]);
                int nh2 = Math.max(0, h2 - mutal[1]);
                int nh3 = Math.max(0, h3 - mutal[2]);

                if (!visited[nh1][nh2][nh3]) {
                    visited[nh1][nh2][nh3] = true;
                    q.offer(new int[]{nh1, nh2, nh3, attackCount + 1});
                }
            }
        }

        return -1;  // 이 경우는 발생하지 않음
    }
}
