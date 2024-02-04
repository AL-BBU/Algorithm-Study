package week1.S1_11286_절댓값힙;

import java.io.*;
import java.util.*;

public class S1_11286_절댓값힙_sugyeong {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

				// 절댓값 기준으로 우선순위 큐 정렬
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int fAbs = Math.abs(o1);
            int sAbs = Math.abs(o2);
            if (fAbs == sAbs) { 
                return o1 > o2 ? 1 : -1;
            } else {
                return fAbs - sAbs;
            }
        });

        for (int i = 0; i < n; i++) {
            int command = Integer.parseInt(br.readLine());
            if (command == 0) { // 제거 연산
                if (queue.isEmpty()) // 비었을 경우 '0' 출력
                    System.out.println(0);
                else
                    System.out.println(queue.poll());
            } else { // 추가 연산
                queue.add(command);
            }
        }
    }
}