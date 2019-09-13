
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_16937_baekjoon_twoSticker {
	static int map[][];
	static ArrayList<stk> stickers = new ArrayList<>();
	static int H, W, N;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		N = sc.nextInt();
		if (W > H) { // 湲몄씠媛� 臾댁“嫄� 湲멸쾶!
			int tmp;
			tmp = H;
			H = W;
			W = tmp;
		}
		map = new int[H][W];
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (y > x) { // x媛� 臾댁“嫄� 湲멸쾶!
				int tmp;
				tmp = x;
				x = y;
				y = tmp;
			}
			if (x <= H && y <= W) // 紐⑤늿醫낆씠�뿉 �꽔�쓣 �닔 �엳�뒗�겕湲곕깘.
				stickers.add(new stk(x, y));
		}
		Collections.sort(stickers);
		max = 0;
		comb();
		System.out.println(max);
	}

	static void stickIt(stk stkOne, stk stkTwo) { // 泥ル쾲吏� �뱾�뼱�삤�뒗 �듊�씠而�
		int sx = stkOne.x;
		int sy = stkOne.y;
		int nx = stkTwo.x;
		int ny = stkTwo.y;
		
		if(sy+ny<=W || sx+ nx<=H || (sx+ny<=H && nx<=W) || (sx<=W && sy+nx<=H) || (sx<=W && nx <=W && sy+ny<=H)) {
			int area = stkOne.area+stkTwo.area;
			if(area>max) {
				max = area;
			}
		}
		

	}


	private static void comb() {
		int cnt =0;
		for (int i = 0; i < stickers.size() - 1; i++) {
			stk stkOne = stickers.get(i);
			for (int j = i + 1; j < stickers.size(); j++) {
				stk stkTwo = stickers.get(j);
				stickIt(stkOne, stkTwo);
			}
		}
	}

	static class stk implements Comparable<stk> {
		int x;
		int y;
		int area;

		public stk(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			this.area = x * y;
		}

		@Override
		public int compareTo(stk o) {
			return o.area - this.area; // �겙�닚諛곗튂
		
		}
	}
}
