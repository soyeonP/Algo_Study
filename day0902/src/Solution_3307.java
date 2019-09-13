
import java.util.Scanner;

public class Solution_3307 {
	static int[] arr;
	static int max;
	static int[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			arr = new int[N];
			memo = new int[N];
			max = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 0; i < arr.length - 1; i++) {
				if(N-i <= max)
					break;
				check(i, N, 1); // 0踰덈��꽣 ~ n-1踰덇퉴吏��꽔湲�
			}
			System.out.println("#" + t + " " + max);
		}
	}

	static void check(int n, int N, int cnt) {
		if (n >= N) {
			if (cnt > max) {
				max = cnt;
			}
			return;
		}
		
		if(memo[n] >= cnt)
			return;
		
		memo[n] = cnt;
		for (int i = n + 1; i < arr.length; i++) {
			if (arr[i] >= arr[n]) {
				check(i, N, cnt + 1);
			}
		}
		// 留� �걹媛믪씠 �옉�븘�꽌 n�씠 N源뚯� �븞媛� 寃쎌슦�룄 議댁옱�븯�옏�븘.
		if (cnt > max)// 1 3 2 4 6 5 �뿬�꽌 (5(6),N,4)�씤�뜲 d
			max = cnt;

	}

}
