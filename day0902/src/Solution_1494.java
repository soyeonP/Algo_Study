
import java.util.Scanner;

public class Solution_1494 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			worm wlist[] = new worm[N];
			for (int i = 0; i < N; i++) {
				wlist[i]= new worm(sc.nextInt(),sc.nextInt());
			}//吏��쟻�씠 諛쏄린.  
			for (int i = 0; i < wlist.length-1; i++) {
				worm one = wlist[i];
				for (int j = 0; j < wlist.length; j++) {
					worm two = wlist[j];
					 
				}
			}
			
			
			System.out.println("#"+t);
		}
	}
	static class worm{
		int x,y;

		public worm(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
