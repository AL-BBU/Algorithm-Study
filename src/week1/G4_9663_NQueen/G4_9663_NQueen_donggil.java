package week1.G4_9663_NQueen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class G4_9663_NQueen_donggil {
	/**
	 * @author �ӵ���
	 * @date 2024-02-04
	 * @link https://www.acmicpc.net/problem/9663
	 * @keyword_solution  
	 * 2���� �迭�� �ƴ� 1���� �迭�� ���� ��Ʈ��ŷ ���
	 * Queen�� ��,��,��,��, 4���� �밢������ 8�� �̵��� ������
	 * 1���� �迭�� ���̸� 2���� �迭�� Column���� ��� -> Array {0, 1, 2, 3}�� �ִٸ�, arr[0]�� 0����, arr[1]�� 1����
	 * 1���� �迭�� ���̿� ����� ���� 2���� �迭�� Row�� ��� -> arr[0] = 1�̶�� (1,0)�� ��ǥ, arr[1] = 2��� (2,1)�� ��ǥ
	 * col - i
	 * @input
	 * 1<= N <= 15 
	 * @output   
	 * ü���ǿ� ���� �� �ִ� ����� ��
	 * @time_complex  
	 * @perf 
	 * 12140KB, 5380ms
	 */
	static int n,m,k;
    static StringTokenizer st;
    static int[]arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int max;
    static boolean[][] visited;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // �Է°� �� ������ ���� N  - 1<=N<=15
        n = Integer.parseInt(br.readLine());
        // 2���� �迭�� 8��Ž���� ���� �ð��ʰ��� ���´�.
        // ������ ���ѽð��� 10��������, �־��� 15x15 2���� �迭���� ��� ����� ���� 8�� Ž���ϸ� �ð��ʰ�
        // ���� 1���� �迭�� �����Ͽ� ����
        arr = new int[n];
        max=0; // n*n ũ���� �迭���� n���� ���� ��� ���� �� �ִ� ����� ��(��°�)
        dfs(0);
        System.out.println(max);
    }
    static void dfs(int depth) {
    	if(depth>=n) {
    		// ���� ��Ͱ� 2���� �迭�� ���� n-1�� �Ѿ�ٸ� ����Ǽ� +1
    		max++;
    		return;
    	}
    	// n�� ũ�⸸ŭ �ݺ��� �����Ͽ� depth(���� ��ȣ)�� i(���� ��ȣ)�� 1���� �迭�� �����Ͽ� ���� �ǽ�
    	for(int i=0; i<n; i++) {
    		arr[depth]=i+1;
    		if(check(depth)) {
    			dfs(depth+1);
    		}
    	}
    }
    static boolean check(int col) {
    	for(int i=0; i<col; i++) {
    		// col ������ �Ѿ�� ���� depth�� 2���� �迭�� ������� ���� Column��
    		// ���� col�� 1, arr[col]�� ���� 1�̶�� 2������ 1������ (1,1)�� ��.
    		// �� ��, depth��ŭ �ݺ��� �����Ͽ� i�� 0, arr[i]�� 1�̶�� (0,1)�� (1,1)�� �ϳ��� ���� ���� �����ϰ� �Ǵ� ������ ���ÿ� ���� �� ����
    		if(arr[col]==arr[i]) {
    			return false;
    		}
    		// Column-i�� ���� arr[col]-arr[i]�� ���ٸ� �밢���� ��ġ�ϴ� ������ �Ұ���
    		// ���� (1,0)�� ���� �����ϰ�, (2,1)�� ���� �����Ѵٸ� col-i���� arr[col]-arr[i]���� ���� �밢�� ���
    		if(col-i == Math.abs(arr[col]-arr[i]))return false;
    	}
    	return true;
    }
}
