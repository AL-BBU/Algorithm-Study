package week2.G4_14938_서강그라운드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_14938_서강그라운드_sugyeong {
    static BufferedReader br;
    static StringTokenizer st;
    static PriorityQueue<Edge> pq;
    static int n, m, r; // nodeCnt, distRange, edgeCnt
    static final int MAX_VAL = Integer.MAX_VALUE;
    static ArrayList<Edge>[] graph;
    static int[] distance;
    static int[] items;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        graph = new ArrayList[n + 1];
        items = new int[n + 1];

        int a, b, c;

        for (int i = 1; i < n + 1; i++) {
            items[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        for (int i = 1; i < n + 1; i++) {
            dijkstra(i);
        }
        System.out.println(ans);
        br.close();
    }

    /**
     * @desc 다익스트라를 진행 메서드
     * @param 다익스트라 시작 노드
     */
    static void dijkstra(int start){
        distance = new int[n + 1];
        Arrays.fill(distance, MAX_VAL); // 거리 배열 MAX 값으로 초기화
        pq = new PriorityQueue<>();

        pq.add(new Edge(start, 0));
        distance[start] = 0;
        int result = 0;
        while (!pq.isEmpty()){
            Edge now = pq.poll();
            int nowV = now.vertex;
            int nowW = now.weight;
            if (distance[nowV] < nowW) continue; // 이전에 이미 처리된 노드일 경우 패스
            for (Edge tmp : graph[nowV]) {
                int tmpV = tmp.vertex;
                int tmpW = tmp.weight;
                if (distance[tmpV] > distance[nowV] + tmpW && distance[nowV] + tmpW <= m) { // 거리 제한에 따라 갈 수 있는 노드인지 체킹
                    distance[tmpV] = distance[nowV] + tmpW;
                    pq.add(new Edge(tmpV, distance[tmpV]));
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (distance[i] != MAX_VAL){ // 갈 수 있는 노드의 경우 item 값 증가
                result += items[i];
            }
        }

        ans = Math.max(ans, result);
    }

    static class Edge implements Comparable<Edge> {
        int vertex;
        int weight;

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge){
            return Integer.compare(this.weight, edge.weight);
        }
    }
}