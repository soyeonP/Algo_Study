package day1223;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_1260DFS와BFS {
	static ArrayList<Integer> list[] ;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int start = sc.nextInt();
		list = new ArrayList [V+1]; //리스트를 가진 배열생성 
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>(); //초기화 
		}
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		for (int i = 0; i < list.length; i++) {
			Collections.sort(list[i]); // 오름차순 ? 
		}
		visit = new boolean[V+1];
		dfs(V,start);
		System.out.println();
		Arrays.fill(visit, false);
		bfs(V,start);
		
	}
	private static void bfs(int n, int s ) {
		LinkedList<Integer > q = new LinkedList<>();
		q.add(s);
		visit[s]=true;
		System.out.print(s+" ");
		while(!q.isEmpty()) {
			int now = q.pop();
			for (int i = 0; i < list[now].size(); i++) {
				int nxt = list[now].get(i);
				if(!visit[nxt]) {
					q.add(nxt);
					visit[nxt] = true;
					System.out.print(nxt+" ");
				}
			}
		}
		
	}
	private static void dfs(int n, int now) { // 노드개수,현재노
		visit[now]=true;
		System.out.print(now+" ");
		for (int i = 0; i < list[now].size(); i++) {
			if(!visit[list[now].get(i)]) {
				dfs(n,list[now].get(i));
			}
		}
		
	}
}
