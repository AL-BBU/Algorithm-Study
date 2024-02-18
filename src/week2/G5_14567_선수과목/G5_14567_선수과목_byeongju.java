package week2.G5_14567_선수과목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_14567_선수과목_byeongju {
	static ArrayList<Integer> []subject;
	static int[] preSub;
	static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		subject= new ArrayList[n+1];
		preSub=new int[n+1];
		num=new int [n+1];
		
		for(int i=1;i<=n;i++) {
			subject[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a =Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			subject[a].add(b);
			num[b]++;
		}
		
		Prerequisite(n);	
		
		for(int i=1;i<=n;i++) {		
			System.out.print(preSub[i]+" ");
		}
		
	}
	
	static void Prerequisite(int N) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (num[i] == 0) {
                queue.offer(i);
                preSub[i] = 1; 
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : subject[current]) {
                num[next]--;

                preSub[next] = Math.max(preSub[next], preSub[current] + 1);

                if (num[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }

}