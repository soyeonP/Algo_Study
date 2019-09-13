
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_5577 {
	static LinkedList<Integer> rlist = new LinkedList<>();
	static rby alist[]; // 諛붽��븷�뱾 �꽔�쓣嫄�.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			rlist.add(sc.nextInt()); // 由ъ뒪�듃�뿉 �꽔�뒗�떎.
		}
		alist = new rby[N]; // �씤�뜳�뒪 �꽔�쓣怨�.
		int n = 0;
		for (int i = 0; i < N - 1; i++) {
			if (rlist.get(i) == rlist.get(i + 1)) {// �뮘�뿣�닔�옉 �꽌濡� �뿰�냽�릺�뼱.
				if (i + 3 < N && rlist.get(i + 1) == rlist.get(i + 3)) { // �븯�굹 嫄대꼫�쎇怨� 洹� �뮘�뿣爰쇰옉 媛숈븘
					alist[n++] = new rby(i + 2, rlist.get(i));// 諛붽퓭�빞 �븯�뒗�옄由�, 媛믪� 諛붽� �닽�옄.
				} else if (i - 1 >= 0 && rlist.get(i) == rlist.get(i - 2)) { // �븯�굹 �븵�뿉嫄대꼫�쎇怨� 洹� �븵�뿉爰쇰옉 媛숈�寃쎌슦
					alist[n++] = new rby(i - 1, rlist.get(i));// 諛붽� �븷 //留뚯빟 2硫� �뼐瑜쇰컮袁몃㈃ 5媛��맆�븷��嫄곗짛.(�븵�뮘濡� 2媛쒖뵫)
				} else if (i + 2 < N && rlist.get(i + 1) == rlist.get(i + 2)) { // 3�뿰�냽�씠�빞 .
					if (i + 3 < N)
						alist[n++] = new rby(i + 3, rlist.get(i));
					if (i - 1 >= 0)
						alist[n++] = new rby(i - 1, rlist.get(i));
				}
			}
		}
	//	System.out.println(Arrays.toString(alist));
		int min = N; // 理쒖냼媛믪쓣 �꽔�쓣 怨�
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (alist[i] == null)
				break;
			cnt = pang(alist[i].idx, alist[i].color); // 諛� 轅� �닔 �엳�뒗�븷�뒗 �떎 �뙜 �빐蹂몃떎
			if (cnt <= min)
				min = cnt;
		}

		System.out.println(min);
	}// main

	static int pang(int idx, int color) { // rlist�쓽 idx瑜� �젣嫄고븳 �썑 pang �룄�뀭�뒗寃껋쓣 吏�耳쒕낯�떎.
		LinkedList<Integer> clist = new LinkedList<>();
		clist = rlist; // 源�? �뼍?
		// checklist瑜� �룎硫� 4媛� �씠�긽�씤 �븷�뒗 �젣嫄고빐 以� 寃껋씠�떎.
		clist.set(idx, color);
	
		while (true) {
			boolean check = false;
            	int cnt = 1;
			for (int i = 0; i < clist.size() - 1; i++) {
				if (clist.get(i) == clist.get(i + 1)) {
					cnt++;
				} else {
					if (cnt >= 4) {
						check = true;
						clist.remove(i);
						clist.remove(i - 1);
						clist.remove(i - 2);
						clist.remove(i - 3);
						if (cnt >= 5) {
							clist.remove(i - 4);
							if (cnt == 6) {
								clist.remove(i - 5);
							}
						}
						break;
					}
					cnt=1;
				}
			}
			if (!check)
				break;
		}

		int num = clist.size();
		return num;
	}

	static class rby {
		int idx;
		int color;

		public rby(int idx, int color) {
			super();
			this.idx = idx;
			this.color = color;
		}

	}
}
