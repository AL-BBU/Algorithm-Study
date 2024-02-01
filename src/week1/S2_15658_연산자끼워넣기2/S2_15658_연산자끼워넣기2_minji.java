package week1.S2_15658_연산자끼워넣기2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * @author Minji Lee
 * @date 20240201
 * @link https://www.acmicpc.net/problem/15658
 * @keyword_solution 결국 최소, 최대를 구하는거기 때문에, 조합을 만들고 가지치기!  
 * @input 
 * 처음 값 -> 배열의 길이
 * 두번째 줄 값 -> 배열 (순서를 바꾸면 안됨)
 * 
 * 0 1 2 3
 * + - x / 순으로 입력 들어옴 
 * @output 최소값, 최대값
 * @time_complex O()
 * @perf  kb ms
 */
public class S2_15658_연산자끼워넣기2_minji {
	// 연산자 입력값 받는 배열 
	static int[] op_cnt = new int[4];
	// 조합 저장
	static boolean[] choosed; 
	// 주어진 배열의 길이 
	static int numbers_len ;
	// 주어진 배열
	static int[] numbers;
	
	static int depth;
	static int result_cnt =0;
	static int mx = -1000000000;
	static int min = 100000000;
	static ArrayList<Integer> op_list = new ArrayList<Integer>();
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		numbers_len = Integer.parseInt(tokens.nextToken());
		
		numbers = new int[numbers_len];
		depth = numbers_len -1;
		
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < numbers_len; i++) {
			numbers[i] = Integer.parseInt(tokens.nextToken());
		}
		
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < 4; i++) {
			op_cnt[i] = Integer.parseInt(tokens.nextToken());
			for(int j = 0; j < op_cnt[i]; j++) {
				op_list.add(i);
			}
		}
		
		choosed = new boolean[op_list.size()];
		int[] result = new int[numbers_len-1];
		permutation(0, result);
	
		System.out.println(mx);
		System.out.println(min);
	}
	
	//0 1 2 3
	//+ - x / 
	public static void checkingData(int sum,int[] result) {
		int temp ; 
		temp = numbers[0];
		int number_cnt = 1;
		for(int j = 0; j < numbers_len-1; j++) {
			switch (result[j]) {
			case 0:
				temp += numbers[number_cnt];
				break;
			case 1:
				temp -= numbers[number_cnt];
				break;
			case 2:
				temp *= numbers[number_cnt];
				break;
			case 3:
				if(temp < 0) {
					temp *= -1;
					temp = (int) temp/numbers[number_cnt];
					temp *= -1;
				}else {
					temp = (int) temp/numbers[number_cnt];
				}
				break;
			}
			number_cnt++;
			}
			if(temp < min) {
				min = temp;
			}else if (temp > mx){
				mx = temp;
			}
		}
	
	// 순열
	public static void permutation(int cnt, int[] result) {
		if(cnt == numbers_len -1) {
			checkingData(0, result);
			return;
		}
		for(int i = 0; i <op_list.size(); i++) {
			if(!choosed[i]) {
				choosed[i] = true;
				result[cnt] = op_list.get(i);
				permutation(cnt+1, result);
				choosed[i] = false;
			}
		}
	}
	
}
