

import java.util.Arrays;
import java.util.Scanner;

public class Main_jungol_1863 {
	static int arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // �븰�깮�닔
		arr = new int[N + 1];// �씤�뜳�뒪�뒗 蹂몄씤. 媛믪� ���몴
		for (int i = 1; i < arr.length; i++) {
			arr[i]=i; //珥덇린媛�, �떎 蹂몄씤�쑝濡� �뀑�똿 
		}
		int M = sc.nextInt();
		int a, b;
		for (int i = 0; i < M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			union(a,b);
		}//吏묓빀�쑝濡� 留뚮뱾�뼱以��떎. 媛숈� 醫낃탳�겮由� 
		for (int i = 1; i < N; i++) {
			parent(i);
		}
		Arrays.sort(arr); // sort�븯吏��븡怨� arr瑜� �룎硫댁꽌 ���몴媛��옄�떊�씤寃쎌슦(arr[i]==i) 留� �뜑�빐�꽌 李얜뒗�떎. 
		int cnt =1;
		for (int i = 1; i < arr.length-1; i++) {
			if(arr[i]!=arr[i+1]) cnt++;
		}
		System.out.println(cnt);
		
	}//main
		
	static int parent(int idx) { //���몴媛� �늻援щ뒳 ? 
		if(arr[idx]==idx) {
			return idx;
		}
		int parent = parent(arr[idx]);
		arr[idx]=parent;
		return parent;		
	}
	
	static void union(int i,int j) {
		int pi=parent(i);
		int pj=parent(j);
		if(pj==pi) return; 
		if(pi>pj)arr[pi]=pj;
		else arr[pj]=pi; 
	}
}
