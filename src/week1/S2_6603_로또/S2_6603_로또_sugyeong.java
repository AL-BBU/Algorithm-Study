package week1.S2_6603_로또;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_6603_로또_sugyeong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr;
				boolean[] visited;
        int num;

        while ((num = Integer.parseInt(st.nextToken())) != 0) { // '0' 입력 시 종료
            arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[arr.length];
            lottos(arr, visited, 0, num, 6);
            System.out.println(); // 테스트 케이스별 개행 문자 출력
            st = new StringTokenizer(br.readLine());
        }
    }

    static void lottos(int[] arr, boolean[] visited, int depth, int n, int r){
        if (r == 0) { // r개의 숫자 모두 선택 시 출력
            print(arr, visited, n);
            return;
        }

        if (depth == n) { // 모든 경우의 수 다 탐색 완료
            return;
        }

        visited[depth] = true; // depth에 선택된 숫자 포함한 조합
        lottos(arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        lottos(arr, visited, depth + 1, n, r);
    }

    static void print(int[] arr, boolean[] visited, int n){
        for (int i = 0; i < n; i++) {
            if (visited[i] == true){ // 선택된 숫자들만 출력
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}