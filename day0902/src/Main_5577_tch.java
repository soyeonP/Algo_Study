
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_5577_tch {
	private static int[] ball;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ball = new int[N];
		for (int i = 0; i < N; i++) {
			ball[i] = sc.nextInt();
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			int origin = ball[i];
			for (int j = 1; j < 4; j++) {
				if (origin == j)
					continue;
				ball[i] = j;
				int cnt = 0;
				int left = i, right = i;

				while (left >= 0 && right < N && ball[left] == ball[right]) {
					int color = ball[left];

					int tmp = 0;
					while (left >= 0 && ball[left] == color) {
						if(left ==right) tmp--;
						tmp++;
						left--;
					}
					while (right < N && ball[right] == color) {
						tmp++;
						right++;
					}

					if (tmp >= 4) {
						cnt += tmp;
					}
				}
				max = Math.max(max, cnt);
			}
			ball[i] = origin;

		}
		System.out.println(N - max);

	}

}
