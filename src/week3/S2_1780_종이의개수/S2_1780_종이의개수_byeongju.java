package week3.S2_1780_종이의개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_1780_종이의개수_byeongju {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int size;
    static int[][] coloredpaper;
    static int[] answer = new int[3]; // 0: -1종이 1: 0 종이 2: 1종이의 수 배열

    public static void main(String[] args) throws Exception {
        size = Integer.parseInt(br.readLine());
        coloredpaper = new int[size ][size ]; // 색종이가 아니네 종이네? 

        for (int r = 0; r < size; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < size; c++) {
                coloredpaper[r][c] = Integer.parseInt(st.nextToken()); // 종이의 원소 입력
            }
        }

        PaperCheck(0, 0, size);// 0,0 부터 시작하며 시작크기를 n으로 두어 원소 확인

        for (int ans : answer) {
            System.out.println(ans);
        }
    }

    public static void PaperCheck(int row, int col, int maxSize) {
        if (check(row, col, maxSize)) { // check함수 실행
            answer[coloredpaper[row][col] + 1]++; // 기본 값 추가
            return;
        }

        int newSize = maxSize / 3; // 최대 비교하는 범위를 나누기 3씩하며 비교 진행
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                PaperCheck(row + r * newSize, col + c * newSize, newSize);// 분할한 범위로 재귀
            }
        }
    }

    static boolean check(int x, int y, int size) {
        int value = coloredpaper[x][y];//기본 값 설정 후 

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (coloredpaper[i][j] != value) { // 값을 돌아다니며 기본값과 다르면 false
                    return false; 
                }
            }
        }
        return true;
    }
}
