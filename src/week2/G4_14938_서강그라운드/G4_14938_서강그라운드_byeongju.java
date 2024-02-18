package week2.G4_14938_서강그라운드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_14938_서강그라운드_byeongju {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static final int INF = Integer.MAX_VALUE; // 초기화에 사용
	static int [] map; // 각 노드에 따라 저장된 아이템의 수 저장
	static int [][] map_dx; // 두 노드사이의 거리를 이중배열로 표기
	static int searchRange, cityNum;
	
	public static void main(String[] args) throws IOException {
		
		st= new StringTokenizer(br.readLine());
		cityNum=Integer.parseInt(st.nextToken()); // 존재하는 node의 수
		searchRange=Integer.parseInt(st.nextToken()); // 최대 움직일 수 있는 거리
		int roadNum=Integer.parseInt(st.nextToken()); //입력받을 간선의 수 
		
		map = new int[cityNum+1]; // 도시의 시작이 1이므로 +1해줌
		map_dx=new int[cityNum+1][cityNum+1];
		
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=cityNum;i++) {
			map[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<roadNum;i++) {
			st=new StringTokenizer(br.readLine());
			int depart=Integer.parseInt(st.nextToken());
			int arrive=Integer.parseInt(st.nextToken());
			int itemNum=Integer.parseInt(st.nextToken());
			
			map_dx[depart][arrive]=itemNum; // 단일 방향 연결이 아니라 양방향이므로 
			map_dx[arrive][depart]=itemNum; // 대칭되는 위치에 함께 읿력
		}
		
		
		int answer=0;
		for(int i=1;i<=cityNum;i++) {
			int item=ItemSearch(i);
			answer=Math.max(answer, item);//반환되는 item의 수 중 가장 큰 값을 저장
		}
		
		System.out.println(answer);
	}
	
    static int ItemSearch(int start) {
        PriorityQueue<Item> pq = new PriorityQueue<>(); // 항상 최선의 값을 선택해 최소 단위를 나타내야해서 우선순위 사용
        int[] distance = new int[cityNum + 1];
        
        Arrays.fill(distance, INF); // array 값 초기화
        distance[start] = 0; // 시작 노드 기준 거리 저장용
        pq.offer(new Item(start, 0));

        while (!pq.isEmpty()) {
            Item current = pq.poll();

            if (current.dx > distance[current.city]) {
                continue; 
            }

            for (int next = 1; next <= cityNum; next++) {
                if (map_dx[current.city][next] != 0) {
                    int nextDistance = current.dx + map_dx[current.city][next];	//현재까지의 거리 + 다음 노드까지의 거리
                    
                    if (nextDistance <= searchRange && nextDistance < distance[next]) {
                        distance[next] = nextDistance;
                        pq.offer(new Item(next, nextDistance));
                    }
                }
            }
        }

        int totalItems = 0;
        for (int i = 1; i <= cityNum; i++) {
            if (distance[i] <= searchRange) { // 저장된 거리들 중 탐색 거리보다 작은item을 저장
                totalItems += map[i];
            }
        }

        return totalItems;
    }

	static class Item implements Comparable<Item>{
		int city;
		int dx;
		
		Item(int item,int dx){
			this.city=item;
			this.dx=dx;
		}
		
		@Override
		public int compareTo(Item o) { // 우선순위에서 사용될 compare
			return Integer.compare(this.dx, o.dx);
		}
	}
}