import java.util.ArrayList;
import java.util.Scanner;

public class Solution_1767_프로세서연결하기{
	static int MaxCore;
	static int minLine;
	static int N; // �ʻ�����
	static int map[][];
	static ArrayList<core> arr;
	static int dx []= {1,0,-1,0};
	static int dy []= {0,-1,0,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N + 2][N + 2];
			for (int i = 0; i < map.length; i++) {
				map[i][map.length - 1] = 2;
				map[i][0] = 2;
				map[map.length - 1][i] = 2;
				map[0][i] = 2;
			} // ������ ����� �ƿ����ο�
			
			arr = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1) {
						if (i == 1 || j == 1 || i == N || j == N) {
							map[i][j] = 3; // ����ó �ִ� 3ó��. �ȼ��Ŵϱ�.
						}else {
							arr.add(new core(i,j));
						}
					}
				}
			}
			//show();
			minLine = Integer.MAX_VALUE;
			MaxCore = 0;
			comb(0,0,0);
			if(minLine==Integer.MAX_VALUE)
				minLine =0;
			System.out.println("#"+t+" "+minLine);
			
		}
		sc.close();
	}
	
	static void comb(int idx, int lineSum, int coreNum) {
		if(idx==arr.size()) { //������ �Ӵ� 
			if(coreNum>MaxCore) { //�ھ���� ������ �ƽ��ھ���̻�
				MaxCore = coreNum;
				minLine = lineSum; //���� ���� �ھ���� �������ϱ� ������ �����.		
			}else if(coreNum==MaxCore) {
				if(lineSum<minLine) { //�ھ�������ٸ�, ���� �����𺸴� ������ �������� ����. 
					minLine = lineSum;
				}//�ƴϿ��� 
			}
			return;
		}
		
		for (int i = idx; i < arr.size(); i++) {
			core cor = arr.get(i);
			for (int j = 0; j < dx.length; j++) {	
				if(canGetLine(cor,j)) { //���� ���� ����. 
					//�����ϰ� �޺񳻿��ǳְ� ���������. 
					int Sum = LineSum(cor,j);//������
					comb(i+1,lineSum+Sum,coreNum+1);	
					removeLine(cor,j);
				}
			}
			
		}		
	}
	
	private static void removeLine(core cor, int dir) {
		int cx =cor.x+dx[dir]; //����. 
		int cy = cor.y+dy[dir];
		while(map[cx][cy]==3) { //����������� 
			map[cx][cy]=0;
			cx=cx+dx[dir]; //���������� �̵�.
			cy=cy+dy[dir];
		}
	}

	static int LineSum(core cor, int dir) { //��������
		int lineNum =0;
		int cx =cor.x+dx[dir]; //����. 
		int cy = cor.y+dy[dir];
		while(map[cx][cy]!=2) { //����� �����϶����� 
			map[cx][cy]=3;
			cx=cx+dx[dir]; //���������� �̵�.
			cy=cy+dy[dir];
			lineNum++;
		}
		return lineNum;
	}
	
	static boolean canGetLine(core cor ,int dir) { // core�� ��ġ��, Ȯ���� ����  (2���ִ°����� �� ������) 
		int cx = cor.x+dx[dir];
		int cy = cor.y+dy[dir];
		while(map[cx][cy]==0) {
			cx = cx+dx[dir];
			cy = cy+dy[dir];
		}
		if(map[cx][cy]==2) { //���̾� 
			return true;
		}else
		return false; //���̾ƴ� �ٸ����̾� (1 Ȥ�� 3)
		
	}
	
	static class core {
		int x, y;

		public core(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "core [x=" + x + ", y=" + y + "]";
		}

	}
	
	static void show() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
