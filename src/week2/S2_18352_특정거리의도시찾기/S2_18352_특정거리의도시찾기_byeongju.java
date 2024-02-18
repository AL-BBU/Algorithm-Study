package week2.S2_18352_특정거리의도시찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_18352_특정거리의도시찾기_byeongju {
    static int N, M, K, X;
    static ArrayList<Integer>[] citys;
    static int[] dx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 도시의 개수
        M = Integer.parseInt(st.nextToken());  // 도로의 개수
        K = Integer.parseInt(st.nextToken());  // 최단 거리
        X = Integer.parseInt(st.nextToken());  // 출발 도시 번호

        citys = new ArrayList[N + 1];
        dx = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            citys[i] = new ArrayList<>();
            dx[i] = -1;  
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            citys[a].add(b);
        }

        br.close();

        bfs(X);

        boolean found = false;

        for (int i = 1; i <= N; i++) {
            if (dx[i] == K) { // 각 도시의 방문 횟수(최단거리)가 K인 값을 차례로 출력
                System.out.println(i);
                found = true;
            }
        }

        if (!found) { // 없으면? -1출력
            System.out.println("-1");
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        dx[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : citys[current]) {
                if (dx[next] == -1) { // 해당 도시는 아직 방문한 적이 없다.
                    dx[next] = dx[current] + 1; //방문 했음 표시, 방문횟수가 많으면 그만큼 증가
                    queue.offer(next);
                }
            }
        }
    }
}