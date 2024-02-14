package week2.S2_1058_친구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_1058_친구_sugyeong {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[][] graph, link;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        link = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (line[j].equals("Y")) {
                    graph[i][j] = 1; // 친구 관계 표시
                    link[i][j] = 1; // 연결 상태 표시
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) { // 나 자신과는 친구가 될 수 없음
                        continue;
                    }
                    link[i][j] |= (graph[i][k] & graph[k][j]); // (i - k) 친구 & (k - j) 친구 = (i - j) 친구 성립
                }
            }
        }

        for (int[] l : link) { // 친구가 가장 많은 사람의 친구 수 도출
            int total = 0;
            for (int elem : l) {
                total += elem;
            }
            ans = Math.max(ans, total);
        }

        System.out.println(ans);
        br.close();
    }
}