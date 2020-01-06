package day1224;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260DFS¿ÍBFS {
	static ArrayList<Integer> list[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V =sc.nextInt();
		int M =sc.nextInt();
		int startV = sc.nextInt();
		list = new ArrayList [V+1];
		for (int i = 1; i < V+1; i++) {
			list[i]=new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		DFS(V,startV);
		BFS(V,startV);
	}
	private static void BFS(int v, int startV) {
		boolean visit[] = new boolean [v+1];
		Queue q = new LinkedList<Integer>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		q.add(v);
		while(!q.isEmpty()) {
			int n = (int) q.poll();
			for (int i = 0; i < list[n].size(); i++) {
				pq.add(list[n].get(i));
				visit[list[n].get(i)]=true;
			}
		};
		
	}
	private static void DFS(int v, int startV) {
		boolean visit[] = new boolean[v+1];
		
		
	}
}
