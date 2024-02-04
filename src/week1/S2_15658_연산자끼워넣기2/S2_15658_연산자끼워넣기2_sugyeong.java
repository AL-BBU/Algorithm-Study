package week1.S2_15658_연산자끼워넣기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_15658_연산자끼워넣기2_sugyeong {
    static int n, add, sub, mult, div;
    static int[] arr;
    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        add = Integer.parseInt(st.nextToken());
        sub = Integer.parseInt(st.nextToken());
        mult = Integer.parseInt(st.nextToken());
        div = Integer.parseInt(st.nextToken());

				// 1번째 피연산자는 이미 total에 포함시켰으므로 idx = 1 부터 시작
        backtracking(1, arr[0], add, sub, mult, div);
        System.out.println(maxVal);
        System.out.println(minVal);
    }

    static void backtracking(int idx, int total, int add, int sub, int mult, int div){
        if (idx == n){ // 타겟팅 중인 피연산자가 맨 끝까지 다다랐을때 값 갱신
            maxVal = Math.max(total, maxVal);
            minVal = Math.min(total, minVal);
            return;
        }

        if (add > 0){
            backtracking(idx + 1, total + arr[idx], add - 1, sub, mult, div);
        }
        if (sub > 0){
            backtracking(idx + 1, total - arr[idx], add, sub - 1, mult, div);
        }
        if (mult > 0){
            backtracking(idx + 1, total * arr[idx], add, sub, mult - 1, div);
        }
        if (div > 0){
            backtracking(idx + 1, total < 0 ? -(-total / arr[idx]) : total / arr[idx], add, sub, mult, div - 1);
        }
    }
}
