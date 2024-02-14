package week2.G4_14938_서강그라운드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_14938_서강그라운드_donggil {
	static class Node implements Comparable<Node>{
		int index;
		int cost;
		
		public Node() {}
		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
		@Override
		public String toString() {
			return "Node [index=" + index + ", cost=" + cost + "]";
		}
		
	}
	static int n,m,k;
    static StringTokenizer st;
    static int[]arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int max;
    static int[][] visited;
    static ArrayList<Node>[]list;
    static int[] in_degree;
    static StringBuilder sb; 
    static int[] dist;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n+1];
        for(int i=1; i<=n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken()); 
        }
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
        	list[i] =new ArrayList<>(); 
        }
        for(int i=0; i<k; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	list[from].add(new Node(to, cost));
        	list[to].add(new Node(from, cost));
        }
        int result=0;
        for(int i=1; i<=n; i++) {
        	dist = new int[n+1];
        	Arrays.fill(dist, Integer.MAX_VALUE);
        	int sum=0;
        	dijkstra(i);
        	for(int j=1; j<=n; j++) {
        		if(dist[j]!=Integer.MAX_VALUE && dist[j]<=m) {
        			sum+=arr[j];
        		}
        	}
        	result = Math.max(sum,result);
        }
        System.out.println(result);
        br.close();
        bw.close();
    }
    static void dijkstra(int start) {
    	PriorityQueue<Node> pq= new PriorityQueue<>();
    	pq.offer(new Node(start, 0));
    	dist[start]=0;
    	int sum = arr[start];
    	while(!pq.isEmpty()) {
    		Node now = pq.poll();
    		for(Node next : list[now.index]) {
    			int nextCost = dist[now.index]+next.cost;
    			if(dist[next.index]>nextCost && nextCost<=m) {
    				dist[next.index] = nextCost;
    				pq.offer(new Node(next.index, nextCost));
    			}
    		}
    	}
    }
}
