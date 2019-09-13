
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_1258 {
	static boolean[][] map;
	static PriorityQueue<suff> Stuff = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 留듭궗�씠利�
			map = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (sc.nextInt() == 0)
						map[i][j] = false;
					else
						map[i][j] = true;
				} // 留� 諛쏄린 �셿猷�
			}
			int cnt =0; //�슜湲곗쓽 媛쒖닔 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j]) {
						find(i, j);
						cnt++;
//						for (int j2 = 0; j2 < N; j2++) {
//							for (int k = 0; k < N; k++) {
//								System.out.print(map[j2][k]+" ");
//							}
//							System.out.println();
//						}
					}
				}
			}
			System.out.print("#"+t+" "+cnt);
			while(!Stuff.isEmpty())
				System.out.print(" "+Stuff.peek().x +" "+Stuff.poll().y );
			System.out.println();
		}
	}

	private static void find(int i, int j) {
		for (int y = j; y < map.length; y++) {
			map[i][y] = false;
			if ( y+1>=map.length || !map[i][y + 1]) { // �떎�쓬�냸�씠 boolean�씠硫� �씠�젣 諛묒쑝濡쒓컝爰�
				//System.out.println("y="+ y);
				for (int x = i; x < map.length; x++) {
					map[x][y] = false; // 蹂멸납�� false泥섎━
					if (x+1>=map.length || !map[x + 1][y]) {
						//System.out.println("x="+ x);
						Stuff.add(new suff(x+1-i, y+1-j));
					for (int k = i; k <= x; k++) { //�굹癒몄��룄 �븞�뿉 �엳�뒗嫄� �떎 false �옉�뾽�빐�빞吏� 
						for (int k2 = j; k2 <= y; k2++) {
							map[k][k2]=false;
						}
					}
						
						return;
					}
					
				}
			}
		}
	}

	static class suff implements Comparable<suff> {
		int x, y;
		int size;

		public suff(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			this.size = x*y;
		}

		@Override
		public int compareTo(suff o) {
			if(o.size == this.size) {
				return this.x-o.x ;
			}
			return this.size-o.size ;
		}

	}
}
