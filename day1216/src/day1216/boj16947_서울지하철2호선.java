package day1216;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj16947_서울지하철2호선 {
	static ArrayList<Integer> list[];
	static boolean visit[];
	static int ans[];
	static Queue<station> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		list = new ArrayList [N+1];
		visit = new boolean[N+1];
		ans = new int [N+1];
		Arrays.fill(ans, -1);
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < N+1; i++) {
			int s1 = sc.nextInt();
			int s2 = sc.nextInt();
			list[s1].add(s2);
			list[s2].add(s1);
		}
		
	
		boolean getcircle =false;
		Arrays.fill(visit, false);
		for (int i = 0; i <N+1; i++) {
			if(list[i].size()>=2) { //끝단노드가 아니라면
				for (int j = 0; j <list[i].size(); j++) {	
					int next = list[i].get(j);
					visit[next]=true;
					if (circle(i,i,next)) { getcircle =true ; break; }//순환선이 완성되면 종료
					visit[next]=false;
				}
				if(getcircle) break;
			}
		}

		for (int i = 1; i <= N; i++) {
			if(ans[i]<0) { //순환선이 아니야!
				Arrays.fill(visit, false); //재사용 할고
				q = new LinkedList<station>();
				q.add(new station(i,0)); //역과 ,  이 역으로 부터의 거리 
				visit[i]=true;
				while(!q.isEmpty()) {
					station st =  q.poll();
					if(ans[st.station]==0) { ans[i] = st.len; break;} //해당 역이 순환선이면, 
					for (int j = 0; j < list[st.station].size(); j++) {
						if(!visit[list[st.station].get(j)]) {
							visit[list[st.station].get(j)]=true;
						q.add(new station(list[st.station].get(j),st.len+1));
						}
						
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(ans[i]+" ");
		}
	}
	private static boolean circle(int start, int before, int now) { //before는 못가게 한다.
		if(list[now].size()<2) return false; //끝노드 
		if(start!=before && now == start) { //순환 
			visit[start]=true;
			for (int i = 1; i < ans.length; i++) {
				if(visit[i]) ans[i] = 0;
			}
			return true;
		}
		
		for (int i = 0; i < list[now].size(); i++) {
			int next = list[now].get(i);
			if(next!=before&&!visit[next]) {
				visit[next]=true;
				if(circle(start,now,next)) return true;
				visit[next]=false;
			}
		}		
		
		return false;
	}
	
	private static class station{
		int station;
		int len;
		public int getStation() {
			return station;
		}
		public void setStation(int station) {
			this.station = station;
		}
		public int getLen() {
			return len;
		}
		public void setLen(int len) {
			this.len = len;
		}
		public station(int station, int len) {
			super();
			this.station = station;
			this.len = len;
		}
		
	}
}