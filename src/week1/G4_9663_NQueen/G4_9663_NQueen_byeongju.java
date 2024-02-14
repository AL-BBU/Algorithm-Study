package week1.G4_9663_NQueen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/* 
1. 첫번째 생각 - 2중 boolean 배열을 사용한 visited 작성
- visited와 dfs를 사용하여 dfs에서 while문을 통해 가로, 세로, 대각선을 모두 true로 변경해주고 반복, 반복 횟수가 n과 같아지면 더해주는 방식을 사용하면 되겠다고 생각
→ 메모리 제한과 while 문 사용에 있어 시간적 어려움이 있을 것으로 생각되어 배열을 사용하지 않는 것으로 다시 생각 → 배열의 사용이 아니라면? 수학적으로 접근이 필요하다고 판단

2. Point라는 클래스를 생성하여 Queue 방식으로 좌표를 관리하며 대각선과 가로, 세로 모두 연산을 통해 판단
- 구현하였으나 n이 커짐에 따라 메모리 사용량이 증가하여 메모리 초과 발생

3. 어짜피 가로에는 하나의 퀸만 존재할 수 있으므로 row 좌표가 필요 없다고 생각
- 기존의 Point class를 지우고 queenPosition이라는 배열을 하나 두어 관리
→ 통과
 */

public class G4_9663_NQueen_byeongju {

	static long cnt=0;
	static int[] queenPosition;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n= sc.nextInt();
        queenPosition=new int[n];
        
        dfs(n, 0);
        System.out.println(cnt);
        
        sc.close();
    }

    private static void dfs(int n, int row) {
        if (row == n) {
        	cnt++;
            return;
        }
        for (int col = 0; col < n; col++) {
        	queenPosition[row]=col;
        	
            if (positionChecking(row)) {
                dfs(n, row + 1);              
            }
        }
    }

    private static boolean positionChecking(int x) {
        for (int i=0;i<x; i++) {
            if (queenPosition[i] == queenPosition[x] || Math.abs(queenPosition[i] - queenPosition[x]) == x-i) {
                return false;
            }
        }
        return true;
    }
}
