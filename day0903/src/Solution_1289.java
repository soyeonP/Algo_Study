
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1289 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= T; t++) {
			int cnt = 0; //諛붽씀�뒗 �슏�닔 
			String s = bf.readLine(); //0�뿉�꽌 �뼐濡� 留뚮뱾�뼱�빞�빐. 
			if(s.charAt(0)=='1') cnt++;
			for (int i = 0; i < s.length()-1; i++) {
				if( s.charAt(i) != s.charAt(i+1)){
					cnt++;
				}
			}
			
			System.out.println("#"+t+" "+ cnt);
		}
		
	}
}
