package day1217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw4040_문자열의거듭제곱 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= T; t++) {
			String s = bf.readLine();
			int len = s.length(); // 문자열의 길이. 약수들이 거듭제곱문자가  될 수 있음.
			int n = 0; //답 .
			for (int i =len ; i >= 1; i--) {
				if(i==len-1) i = len/2;
				if(len%i==0) {
					String sub = s.substring(0, len/i);
					if(hash(s,sub)) {
						n = i;
						break;
					}
				}
				
			}//약수를 구한다
			System.out.println("#"+t+" "+n);
		}
	}

	private static boolean hash(String s, String sub) {
		int sublen = sub.length();
		for (int i = 0; i < s.length(); i+=sublen) {
			if(!s.substring(i, i+sublen).equals(sub)) {
				return false;
			}
			
		}
		
		
		//다 돌고 나오면 true
		return true;
	}
}
