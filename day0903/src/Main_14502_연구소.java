import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_14502_연구소 {
	static int max;
	static ArrayList<ground> blist = new ArrayList<>();
	static LinkedList<ground> vlist = new LinkedList<>();
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int N;
	static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 0) {
					blist.add(new ground(i, j));
				} // 벽 세울 리스트
				else if (map[i][j] == 2)
					vlist.add(new ground(i, j));
			}
		} // 맵 받기
		max = 0;

		makeWall(0, map);
		System.out.println(max);
	}

	static void makeWall(int n, int[][] map) {
		if (n == 3) { // 벽3개 세움.

			dfs(map);// 바이러스들이 이동할 차례
			return;
		}
		for (int i = 0; i < blist.size(); i++) { // 벽 3개 세우는 경우의 수 돌리기.
			int x = blist.get(i).x;
			int y = blist.get(i).y;
			if (map[x][y] == 0) {
				map[x][y] = 1;
				makeWall(n + 1, map);
				map[x][y] = 0;
			} else {
				continue;
			}
		}

	}

	static void dfs(int[][] map) { // 바이러스 퍼지기
		int[][] remap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				remap[i][j]=map[i][j];
			}
		}		//remap에 map복사. 
		LinkedList<ground> vlists = new LinkedList();
		for (int i = 0; i < vlist.size(); i++) {
			int xx = vlist.get(i).x;
			int yy = vlist.get(i).y;
			vlists.add(new ground(xx,yy));
		}
		
		
		while (!vlists.isEmpty()) {
			int x = vlists.peek().x;// 바이러스 친구 좌표
			int y = vlists.pop().y;
			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && remap[nx][ny] == 0) {
					//System.out.println(nx+" "+ny);
					remap[nx][ny] = 2;
					vlists.add(new ground(nx, ny));


				}
			}
		}


		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (remap[i][j] == 0)
					cnt++;
			}

		}

		if (cnt > max) {
			max = cnt;
		}

	}

	static class ground {
		int x, y;

		public ground(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
