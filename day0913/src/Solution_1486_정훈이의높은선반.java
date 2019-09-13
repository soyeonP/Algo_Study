import java.util.Scanner;

public class Solution_1486_정훈이의높은선반 {
	static int N ;
	static int [] arr;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N =sc.nextInt();
			int B = sc.nextInt();
			arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i]=sc.nextInt();
			}
			ans = Integer.MAX_VALUE;
			comb(0,0,B);
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void comb(int idx,int sum,int B) {
		if(sum>=B) { //�������� 
			if(sum-B< ans)
				ans = sum-B;
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			comb(i+1,sum+arr[i],B);
		}
		
		return;
	}
	
	
}
