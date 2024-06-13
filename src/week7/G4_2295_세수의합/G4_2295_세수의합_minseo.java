package week7.G4_2295_세수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class G4_2295_세수의합_minseo {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, result;
    static Set<Integer> plus = new HashSet<>();
    static int[] arr;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            arr[i] = a;
        }

//       x + y 집합 생성
//       세 수의 합 모든 경우(x+y+z)를 찾기 위해서는 O(N^3)으로 시간 초과
//       그래서 x + y = k - z 를 이용해서 x + y 집합에 k - z를 찾아서 최댓값 k를 찾으면 됨
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                plus.add(arr[i] + arr[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int minus = arr[i] - arr[j];
                if (plus.contains(minus)) {
                    result = Math.max(result, arr[i]);
                }
            }
        }

        System.out.println(result);


    }
}
