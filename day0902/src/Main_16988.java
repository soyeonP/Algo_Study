//다시 풀기
import java.util.ArrayList;
import java.util.Scanner;

public class Main_16988 {
	static int map[][];
	static int M;
	static int N;
	static int max, limit;
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static ArrayList<location> cando = new ArrayList<location>();
	static ArrayList<location> enemy = new ArrayList<location>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int num = sc.nextInt();
				map[i][j] = num;
				if (num == 0)
					cando.add(new location(i, j));
				else if (num == 1)
					enemy.add(new location(i, j));
			}
		} // 諛쏄린�셿猷�
		limit = enemy.size();
		max = 0;
		com();
		System.out.println(max);

	}

	private static void com() { // 紐⑤몢 �룎 2媛쒖뵫 �넄蹂닿린. 洹쇰뜲 援ъ� �쁿�뿉2媛� �뾾�뒗�뜲 �� �븘�슂媛� �엳�쓣源� ? //�깮媛곹빐蹂댁옄.
		for (int i = 0; i < cando.size() - 1; i++) {
			location me = cando.get(i);
			map[me.x][me.y] = 1;
			for (int j = i + 1; j < cando.size(); j++) {
				location me2 = cando.get(j);
				map[me2.x][me2.y] = 1;
				boolean flag = false;
				int cnt = killenemy(0, flag);
				map[me2.x][me2.y] = 0;
				if (cnt > max) {
					max = cnt;
					if (max >= limit)
						return; // 紐⑤뱺�쟻�룎�쓣 �떎 �젣嫄고뻽�쑝硫� �뜑 �뫊蹂� �븘�슂 �뾾�씠 醫낅즺.
				}
			}
			map[me.x][me.y] = 0;
		}
	}

	static boolean evisit[][] = new boolean[N][M];

	private static int killenemy(int cnt, boolean flag) {

		for (int i = 0; i < enemy.size(); i++) {
			location eny = enemy.get(i);
			if (!evisit[eny.x][eny.y]) {
				evisit[eny.x][eny.y] = true; // 諛⑸Ц泥섎━.
				for (int j = 0; j < 4; j++) {
					int nx = eny.x + dx[j];
					int ny = eny.y + dy[j];
					if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
						if (map[nx][ny] == 0)
							flag = true; // �꼫�꽕 �떎 �븞 二쇨툑 �뀪
						if (map[nx][ny] == 2)
							killenemy(cnt + 1, flag);
					}
				}
				
				
			}
		}

//		for (int i = 0; i < enemy.size(); i++) {
//			location eny = enemy.get(i);
//			boolean check  = false;
//			int cnt =0;
//			if(!evisit[eny.x][eny.y]) {
//				for (int j = 0; j <4; j++) {
//					int nx = eny.x +dx[j];
//					int ny = eny.y +dy[j];
//					if(nx>=0&&ny>=0 &&nx<N && ny <M) {
//						if(map[nx][ny]==2)
//							evisit[nx][ny]=true;
//						
//					}
//				}
//			}
//		}
//		

	}

	static void dfs(int[][] evisit, location eny) {

	}

	static class location {
		int x, y;

		public location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
