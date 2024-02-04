package week1.S1_15565_귀여운라이언;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_15565_귀여운라이언_sugyeong {
    static int k, n, s, e;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        s = -1;

        arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (s == -1 && arr[i] == 1) {
                s = e = i;
            }
        }

        if (s == -1) {
            System.out.println(-1);
        } else {
            solution();
        }
    }

    static void solution() {
        int cnt = arr[s] == 1 ? 1 : 0;
        int ans = Integer.MAX_VALUE;

        while (e < k && s <= e) {
            if (cnt == n) { // 라이언 개수 충족 시
                ans = Math.min(ans, e - s + 1);
                if (arr[s++] == 1){
                    cnt--;
                }
            } else { // 라이언 개수 미충족 시
                if (e >= k - 1) {
                    break;
                }
                if (arr[++e] == 1) {
                    cnt++;
                }
            }
        }
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}