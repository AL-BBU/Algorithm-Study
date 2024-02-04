package week1.S4_1940_주몽;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_1940_주몽_sugyeong {
    static int n;
    static int m;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 정렬해서 투포인터 사용이 가능하도록 자료 구조 변환
        solution();
    }

    static void solution() {
        int a = 0;
        int b = n - 1;
        int cnt = 0;

        while (a != b) {
            if (arr[a] + arr[b] > m) {
                b--;
            } else if (arr[a] + arr[b] < m) {
                a++;
            } else {
                cnt++;
                a++;
            }
        }
        System.out.println(cnt);
    }
}