
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1861 {
	static int map [][] ;
	static int alist[]; //湲몄씠�뱾 �떞�쓣 由ъ뒪�듃. 
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			alist = new int[(int) (Math.pow(N, 2)+1)]; //�씤�뜳�뒪媛� 諛⑸쾲�샇, 媛믪� 湲몄씠. 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=sc.nextInt();
				}
			}//留듬컺湲곗셿猷�
			for (int i = 0; i <N; i++) {
				for (int j = 0; j <N; j++) {
					alist[map[i][j]] = dfs(i,j,1);
				}
			}
			int max = 0;
			int idx = 0;
			for (int i = 0; i < alist.length; i++) {
				if(alist[i]>max) {idx =i; max = alist[i];} // 媛숈씠 媛숈�寃쎌슦�뒗 �옉���븷媛� �굹���빞�븿. 
			}
			//System.out.println(Arrays.toString(alist));
			System.out.println("#"+t+" "+idx + " "+ max);
		}
	}
	
	static int dfs(int x, int y,int cnt) {
		int nx=0;
		int ny=0;
		boolean check = false;
		int ans =0;
		for (int i = 0; i < 4; i++) {
			nx = x+dx[i];
			ny = y+dy[i];
			if(nx<N && nx>=0 &&ny<N && ny>=0 && map[nx][ny]==map[x][y]+1) {
				ans = dfs(nx,ny,cnt+1);
				check = true;
				break; //媛덇납�� �븳援곕뜲 諛뽰뿉�뾾�쑝�땲源�. 
			}
		}
		if(!check) {
			return cnt; //�뜑 �쟾吏� 紐삵빐. 
		}else {
			return ans; //�쟾吏꾧��뒫�뻽�뜕寃쎌슦. �쟾�뿉爰쇱뿉�꽌 cnt瑜� 媛��졇�샂. 
		}
		
	}
}
