
import java.util.Scanner;

public class Solution_1494_tch {
	static int TC, N;
	static long ans; // 踰≫꽣媛� ���옣�븷 怨�
	static Point[] worms;
	static boolean visit[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			
			worms = new Point[N]; //吏��쟻�씠�뱾 紐⑥씪怨� 
			visit = new boolean[N];
			
			for (int n = 0; n < N; n++) { //吏��쟻�씠 醫뚰몴 �엯�젰 
				int x = sc.nextInt();
				int y = sc.nextInt();
				worms[n]= new Point(x,y);
			}
			ans = Long.MAX_VALUE;
			//異쒕컻�븯�뒗 吏��쟻�씠�뱾 �꽑�젙. �굹癒몄��뒗 吏앸�湲곕�� 湲곕떎由щ뒗 吏��쟻�씠 . 
			dfs(0,0);
			System.out.println("#"+tc+" "+ans);
			

			
		}//tc
	}//main 

	static void dfs(int idx,int cnt) {
		if(cnt ==(N/2)) { // N留덈━以� �젅諛섏쓣 �꽑�깮�븯���떎. 洹몃윭硫� �쟾泥� N�쓣 �룎硫� �꽑�깮�맂�뀋 �뀗�뱾�씠 異쒕컻 踰≫꽣濡� �쟾泥� �빀 怨꾩궛. 
			long tmpx =0, tmpy =0;
			for (int i = 0; i <N; i++) { //踰≫꽣 �빀 怨꾩궛. 
				if(visit[i]) { //踰≫꽣 異쒕컻�븯�뒗 i踰� 吏��쟻�씠
					tmpx-=worms[i].x;
					tmpy-=worms[i].y;
				}else { //�룄李⑺븷 吏��쟻�씠�떎. 
					tmpx+=worms[i].x;
					tmpy+=worms[i].y;		
				}
			}
			
			ans = Math.min(ans, tmpx*tmpx + tmpy*tmpy); //踰≫꽣�쓽 珥� �빀 湲몄씠 怨꾩궛 
			return;
		}
		
		for (int i = idx; i <N; i++) {
			if(!visit[i]) {
				visit[i] = true; // i踰덉쓣 �궗�슜�븯�뒗 �꽑�깮�쓣 �븯怨� 
				dfs(i+1,cnt+1 ); // i+1踰� 遺��꽣�쓽 �꽑�깮�쓣 �옱洹�濡� �꽆寃⑤큵. 
				visit[i]=false; //�떎�쓬 i++�쓣 �궗�슜�빐 蹂쇨굅�땲源� 吏�湲늝�뒗 鍮쇰뒗 �꽑�깮�쓣 �빐蹂댁옄. 
			}
		}
	}
	
	static class Point{
	int x,y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
