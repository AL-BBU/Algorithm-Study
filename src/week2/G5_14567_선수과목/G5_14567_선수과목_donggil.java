package week2.G5_14567_선수과목;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_14567_선수과목_donggil {
	static int n,m,k;
    static StringTokenizer st;
    static int[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int max;
    static int[] visited;
    static ArrayList<Integer>[]list;
    static int[] in_degree;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        in_degree = new int[n+1];
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
        	list[i] = new ArrayList<>(); 
        }
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	list[from].add(to);
        	in_degree[to]++;
        }
        Queue<int[]> q = new LinkedList<>();
        int result[] = new int[n];
        for(int i=1; i<=n; i++) {
        	if(in_degree[i]==0) {
        		q.offer(new int[] {i,1});
        	}
        }
        while(!q.isEmpty()) {
        	int[] now = q.poll();
        	int index = now[0];
        	int cost = now[1];
        	result[index-1]=cost;
        	for(int i : list[index]) {
        		if(--in_degree[i] == 0) {
        			q.offer(new int[] {i, cost+1});
        		}
        	}
        }
        for(int i=0; i<n; i++) {
        	System.out.print(result[i]+" ");
        }
        br.close();
        bw.close();
    }
}
