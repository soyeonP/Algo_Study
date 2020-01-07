import java.util.Scanner;

public class BOJ_14889스타드와링크 {
	static int N;
	static int[][] arr;
	static boolean visit[];
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int [N+1][N+1];
		visit = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		comb(1,0);
		System.out.println(min);
	}
	private static void comb(int st, int num) {
		if(N/2 ==num) {
			//visit 인애들끼리 계산, 아닌애들끼리계산하기 
			getmin();
			return;
		}
		for (int i = st; i <= N; i++) {
			if(!visit[i]) {
			visit[i]=true;
			comb(i+1,num+1);
			visit[i]=false;
			}
		}
	}
	private static void getmin() {
		int start = 0;
		int link = 0;
		for (int i = 1; i <= N; i++) {
			if(visit[i]) {
				for (int j = 1; j <= N; j++) {
					if(j!=i && visit[j]) {
						start +=arr[i][j];
					}
				}
			}else {
				for (int j = 1; j <= N; j++) {
					if(j!=i && !visit[j]) {
						link += arr[i][j];
					}
				}
			}
		}
		int value =Math.abs(start-link);
		if(value <min)
			min = value;
	}
}
