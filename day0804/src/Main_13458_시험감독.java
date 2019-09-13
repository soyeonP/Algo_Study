import java.util.Scanner;

public class Main_13458_시험감독 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int[] alist = new int[A];
		for (int i = 0; i < alist.length; i++) {
			alist[i] = sc.nextInt();
		}
		int B = sc.nextInt();//총감독관
		int C = sc.nextInt();//부감독관 
		Long ans = (long) A; //일단 A만큼은 감독관 존재. 
		for (int i = 0; i < alist.length; i++) {
			alist[i] = alist[i]- B; //B만큼은 총감독관이 검사가능. 
			if(alist[i]>0) {
				ans= ans + alist[i]/C; //몫이 감독관 수 
				if(alist[i]%C>0) { // 나머지 있으면 감독관 +1 
					ans= ans +1;
				}
			}
		}
//		System.out.println(Arrays.toString(alist));
		System.out.println(ans);
	}
}