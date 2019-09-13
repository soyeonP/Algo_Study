import java.util.Scanner;

public class Main_14503_로봇청소기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] dx = { -1, 0, 1, 0 }; // 북 동 남 서 // 검사할때는 3,2,1,0 순으로 체크 //내 위치의 왼쪽이 0,-1 이잖아.
		int[] dy = { 0, 1, 0, -1 };

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] map = new int[N][M];

		int r = sc.nextInt();// 로봇청소기 좌표
		int c = sc.nextInt();
		int d = sc.nextInt();// 로봇청소기 보는 방향.
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int ans = 0; // 청소한 칸 수 .
		while (true) {
			if (map[r][c] == 0) { // 청소해야해!? 청소!
				map[r][c] = 2; //청소 위치를 2로 표시. 
				ans = ans + 1; // 청소수 +1
			}

			boolean allblock =true; // 4군데 다 막혔는지 체크 
			
			for (int i = 0; i < 4; i++) { //왼쪽 회전  4회 진행. 
				if (d == 0) d = 3;
				else d = d - 1; // 현 위치의 왼쪽꺼를 보자! 
				
				int nwr = r + dx[d]; // 탐색할 위치
				int nwc = c + dy[d];

				if (map[nwr][nwc] == 0) {
					r = nwr;
					c = nwc;
					allblock = false;// 갈수 있는곳이 있네요! 
					break;
				} else {
					nwr = r + dx[d]; // 탐색할 위치
					nwc = c + dy[d];
				}
			}
			
			if(allblock) { //모두 막혀있어요.d는 다시 원래방향으로 돌아옴. 
				if(map[r - dx[d]][c-dy[d]] != 1) { //방향 에서 후진한곳이 갈수 있는곳이다. 
					r= r - dx[d]; //현재 보는방향에서 후진  
					c= c - dy[d];
				}else if(map[r - dx[d]][c-dy[d]] == 1) {//후진하면 벽이다. 
					break; //종료 
				}
				
			}
			
		}
		
		System.out.println(ans);
	}

}
