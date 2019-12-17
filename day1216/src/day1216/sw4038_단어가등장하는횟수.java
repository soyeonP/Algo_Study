package day1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class sw4038_단어가등장하는횟수 {
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= T; t++) {
			ans = 0;
			String B = bf.readLine();
			String S = bf.readLine();

			kmp(B, S);
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void kmp(String B, String S) {
		int pi[] = getPi(S);
		int j = 0;
		int lastidx = S.length()-1;
		for (int i = 0; i < B.length(); i++) {
			while(j>0 && B.charAt(i)!=S.charAt(j)) j = pi[j-1];
			if(B.charAt(i)==S.charAt(j)) {
				if(j==lastidx) {
					j = pi[j];
					ans++;
				}else
					j++;
			}
		}
	}

	private static int[] getPi(String s) {
		int pi[] = new int[s.length()];
		int j = 0;
		char p[] = s.toCharArray();
		for (int i = 1; i < pi.length; i++) {
			while (j > 0 && p[i] != p[j]) {
				j = pi[j - 1];
			}
			if (p[i] == p[j]) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
}
