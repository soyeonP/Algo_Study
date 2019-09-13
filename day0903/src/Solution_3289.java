
import java.util.Scanner;

public class Solution_3289 {
	static int list[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			list = new int[N+1];
			for (int i = 1; i <= N; i++) {
				list[i]=i;
			}
			System.out.print("#"+t+" ");
			for (int m = 0; m < M; m++) {
				int way = sc.nextInt();
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				if(way==0){ //union
				union(n1,n2);	
				}else { //1 �븿猿섎뒳? 
					System.out.print(isparent(n1,n2));
				}
			}
			System.out.println();
		}
	}
	static void union(int n1,int n2) {
		int p1 = parent(n1);
		int p2 = parent(n2);
		if(p1==p2) return;
		if(p1<p2) list[p2]=p1;
		else list[p1]=p2;
	}
	static int parent(int n) {
		if(list[n]==n) return n;
		int parent = parent(list[n]);
		list[n]=parent;
		return parent;
	}
	
	static int isparent(int n1,int n2) {
		if(parent(n1)==parent(n2)) return 1;
		else return 0;
	}
}
