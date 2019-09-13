
import java.util.Arrays;
import java.util.Scanner;

public class Solution_5215 {
	static burger  bglist[]; 
	static int maxtst;
	static int Cal;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			Cal=sc.nextInt();
			bglist= new burger [N];
			for (int i = 0; i <N; i++) {
				int tst = sc.nextInt();
				int cal = sc.nextInt();
				bglist[i]= new burger(tst,cal);
			}
			maxtst = 0;
			Arrays.sort(bglist);
//			for (int i = 0; i < bglist.length; i++) {
//				System.out.println(bglist[i].cal);				
//			}
			findrecip(-1,0,0);
			System.out.println("#"+t+" "+maxtst);
		}
	}
	
	
	static void findrecip(int n,int ttst,int tcal) {
		if(tcal==Cal) {
			if(ttst>maxtst) {
				maxtst = ttst;
			}
			return;
		}	
		for (int i = n+1; i < bglist.length; i++) {
			if(bglist[i].cal+tcal>Cal)break;
			findrecip(i,bglist[i].tasty+ttst,bglist[i].cal+tcal);
		}
		if(ttst>maxtst) {
			maxtst=ttst;
		}
		
		
	}
	
	static class burger implements Comparable<burger> {
		int tasty,cal;

		public burger(int tasty, int cal) {
			super();
			this.tasty = tasty;
			this.cal = cal;
		}

		@Override
		public int compareTo(burger o) {
			// TODO Auto-generated method stub
			return this.cal -o.cal;
		}
	}
}
