package week3.S3_20300_서강근육맨;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_20300_서강근육맨_byeongju {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	// 최대 10의 18제곱이기 때문에 long 사용
	static long max= -1; // 근손실 정도를 저장할 변수
	static long [] numbers; // 운동 강도 저장 배열
	
	public static void main(String[] args) throws Exception{
		int N= Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine());
		numbers = new long [N];
		
		for(int i=0;i<N;i++) {
			numbers[i]= Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(numbers); // 결국 근손실 정도는 두 운동강도의 합이 되기 때문에 
							  // 최소로 만들기 위해선 정렬 후 최대값과 최솟값을 계속 더해주면 된다. 
		
		int start =0;
		int end=N-1;
		
		if(N%2!=0) { // 홀수일 때는 마지막 날에 결국 하나의 근손일이 일어나므로
					 // 최대인 값을 넣어주는 것이 가장 적은 것임
			max=numbers[N-1];
			end--;
		}
		checking(start,end);
		
		System.out.println(max);
		
	}
	
	public static void checking(int start,int end) {
		if(start>=end)
			return;		
		
		long sum= numbers[start]+numbers[end];
		max= Math.max(max, sum); // 계속 값을 더한 후 비교
		
		checking(start+1,end-1);
	}
}
///*==========================================================================*/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.math.BigInteger;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Main {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringTokenizer st;
//
//    static BigInteger max = BigInteger.valueOf(-1); // 근손실 정도를 저장할 변수
//    static BigInteger[] numbers; // 운동 강도 저장 배열
//
//    public static void main(String[] args) throws Exception {
//        int N = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        numbers = new BigInteger[N];
//
//        for (int i = 0; i < N; i++) {
//            numbers[i] = new BigInteger(st.nextToken());
//        }
//
//        Arrays.sort(numbers);
//
//        int start = 0;
//        int end = N - 1;
//
//        if (N % 2 != 0) {
//            max = numbers[N - 1];
//            end--;
//        }
//        checking(start, end);
//
//        System.out.println(max);
//    }
//
//    public static void checking(int start, int end) {
//        if (start >= end)
//            return;
//
//        BigInteger sum = numbers[start].add(numbers[end]);
//        max = max.max(sum);
//
//        checking(start + 1, end - 1);
//    }
//}