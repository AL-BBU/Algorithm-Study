package week3.S3_20300_서강근육맨;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_20300_서강근육맨_donggil {
	static int n, m, k;
	static int[] arr;
	static int total;
	static StringTokenizer st;
	static StringBuilder sb;
	static int max, min;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] timer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		long[] arr = new long[n];
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(st.nextToken()); 
		}
		Arrays.sort(arr);
		long max=0;
		int start=0;
		int end = n-1;
		if(n%2==0) {
			while(start<end) {
				long sum = arr[start]+arr[end];
				max = Math.max(max, sum);
				start++;
				end--;
			}
		}
		else {
			end = n-2;
			while(start<end) {
				long sum = arr[start] + arr[end];
				max = Math.max(max, sum);
				start++;
				end--;
			}
			max = Math.max(max, arr[n-1]);
		}
		System.out.println(max);
		br.close();
		bw.close();
	}
}
