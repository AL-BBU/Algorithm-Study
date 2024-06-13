package week7.G3_13904_과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G3_13904_과제_mInseo {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static ArrayList<Work> list = new ArrayList<>();
	static int n, d, w, result;

	static class Work implements Comparable<Work> {

		int day, point;

		public Work(int day, int point) {
			super();
			this.day = day;
			this.point = point;
		}

		@Override
		public int compareTo(Work o) {
			if (o.day == this.day) {
				return Integer.compare(o.point, this.point);
			}

			return Integer.compare(this.day, o.day);
		}

		@Override
		public String toString() {
			return "Work [day=" + day + ", point=" + point + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			list.add(new Work(d, w));
			
		}
		Collections.sort(list);
		
		for(Work cur : list) {
			if(pq.size() < cur.day) {
				pq.add(cur.point);
				result += cur.point;
			}else if(!pq.isEmpty() && pq.peek() < cur.point) {
				result -= pq.poll();
				result += cur.point;
				pq.add(cur.point);
			}
		}
		
		System.out.println(result);
	}

}
