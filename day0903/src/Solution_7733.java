//다시 풀기
import java.util.Scanner;
public class Solution_7733 {
	static int map[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			map = new int [N][N]; 
			int height = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=sc.nextInt();
					if(map[i][j]>height)
						height=map[i][j]; //�넂�씠���옣 
				}
			}
			int max =0;
			for (int i = 0; i < height; i++) {
				int cnt = number(0);
				if(cnt>max)
					max = cnt;
			}
			System.out.println(max);
		}
	}
	
	static int number(int cnt) {
		
	}
	
}
