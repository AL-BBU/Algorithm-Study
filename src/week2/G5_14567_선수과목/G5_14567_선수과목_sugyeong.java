package week2.G5_14567_선수과목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_14567_선수과목_sugyeong {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m;
    static int[] indegree;
    static ArrayList<Layer>[] graph;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        indegree = new int[n + 1];
        ans = new int[n + 1];
        graph = new ArrayList[n + 1];

        int a, b;

        Queue<Layer> q = new ArrayDeque<>();

        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph[a].add(new Layer(b, 0));
            indegree[b]++; // 진입차수 + 1
        }

        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) { // 진입차수가 0인 경우 : 선수 과목이 없음 (∴ 탐색 시작점)
                ans[i] = 1;
                q.offer(new Layer(i, 1));
            }
        }

        while (!q.isEmpty()) {
            Layer now = q.poll();
            for (Layer next : graph[now.num]) {
                indegree[next.num]--; // 진입차수 - 1
                if (indegree[next.num] == 0) { // 진입차수가 더이상없다 -> 사이클 더이상 X
                    q.offer(new Layer(next.num, now.cnt + 1));
                    ans[next.num] = now.cnt + 1;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            sb.append(ans[i] + " ");
        }
        System.out.println(sb.toString().trim());
        br.close();
    }

    static class Layer{
        int num; // 과목 번호
        int cnt; // 현재 과목이 도출된 순서

        Layer(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}