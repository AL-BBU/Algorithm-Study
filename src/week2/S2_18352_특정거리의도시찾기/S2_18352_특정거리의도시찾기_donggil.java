package week2.S2_18352_특정거리의도시찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_18352_특정거리의도시찾기_donggil {
	static int n,m,k;
    static StringTokenizer st;
    static int[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int max;
    static int[] visited;
    static ArrayList<Integer>[]list;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
        	list[i]= new ArrayList<>(); 
        }
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine()," ");
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	list[a].add(b);
        }
        visited = new int[n+1];
        Arrays.fill(visited, -1);
        bfs(x);
        ArrayList<Integer>list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
        	if(visited[i]==k) {
        		list.add(i);
        	}
        }
        if(list.size()==0) {
        	System.out.println("-1");
        }
        else {
        	Collections.sort(list);
        	for(int i : list) {
        		System.out.println(i);
        	}
        }
        br.close();
        bw.close();
    }
    static void bfs(int start) {
    	Queue<Integer>q = new LinkedList<>();
    	q.offer(start);
    	visited[start]=0;
    	while(!q.isEmpty()) {
    		int now = q.poll();
    		for(int i : list[now]) {
    			if(visited[i]== -1) {
    				visited[i] = visited[now]+1;
    				q.offer(i);
    			}
    		}
    	}
    }
}
